package com.startcoding0to1.springboot_jwt_auth.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.startcoding0to1.springboot_jwt_auth.entity.LoginRequest;
import com.startcoding0to1.springboot_jwt_auth.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {


    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!request.getServletPath().equals("/generate-token")) {
            filterChain.doFilter(request, response);
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        LoginRequest loginRequest = objectMapper.readValue(request.getInputStream(), LoginRequest.class);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if(authentication.isAuthenticated()) {
            String token = jwtUtil.generateToken(authentication.getName(), 1);
            response.setHeader("Authorization", "Bearer " + token);

            String refreshToken = jwtUtil.generateToken(authentication.getName(), 7*24*60); //7day
            // Set Refresh Token in HttpOnly Cookie
            // We can also send it in response body but then client has to store it in local storage  or in-memory
            Cookie refreshTokenCookie = new Cookie("refresh_token", refreshToken);
            refreshTokenCookie.setHttpOnly(true); // Prevent javascript from accessing it
            refreshTokenCookie.setSecure(true); // Sent only over HTTPS
            refreshTokenCookie.setPath("/refresh-token"); // Cookies available only for refresh endpoint
            refreshTokenCookie.setMaxAge(7*24*60*60); // 7 days expiry
            response.addCookie(refreshTokenCookie);
        }
    }
}
