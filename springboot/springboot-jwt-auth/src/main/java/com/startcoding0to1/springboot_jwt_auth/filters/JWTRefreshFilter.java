package com.startcoding0to1.springboot_jwt_auth.filters;

import com.startcoding0to1.springboot_jwt_auth.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTRefreshFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil;

    public  JWTRefreshFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/refresh-token")){
            filterChain.doFilter(request,response);
            return;
        }
        String refreshToken = extractRefreshJWTFromRequest(request);
    }

    private String extractRefreshJWTFromRequest(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        if (cookies != null) {
            return null;
        }
        String refreshToken = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh-token")) {
                refreshToken = cookie.getValue();
            }
        }
        return refreshToken;
    }
}
