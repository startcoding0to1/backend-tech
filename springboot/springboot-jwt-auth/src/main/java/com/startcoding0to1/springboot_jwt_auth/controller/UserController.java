package com.startcoding0to1.springboot_jwt_auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startcoding0to1.springboot_jwt_auth.entity.UserRegisterEntity;
import com.startcoding0to1.springboot_jwt_auth.service.UserRegisterEntityService;
import com.startcoding0to1.springboot_jwt_auth.util.JSONUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRegisterEntityService userRegisterEntityService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JSONUtil  jsonUtil;


    @PostMapping("/user-register")
    public ResponseEntity<String> register(@RequestBody UserRegisterEntity userRegisterDetails)
            throws JsonProcessingException {

        // Payload
        Map<String, String> payload = new HashMap<>();
        payload.put("username", userRegisterDetails.getUsername());
        payload.put("password", userRegisterDetails.getPassword());

        // Encode & save
        userRegisterDetails.setPassword(
                passwordEncoder.encode(userRegisterDetails.getPassword())
        );
        userRegisterEntityService.save(userRegisterDetails);



        // Make request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8081/generate-token",
                HttpMethod.POST,
                request,
                String.class
        );

        // Extract Authorization header
        String authHeader = response.getHeaders().getFirst("Authorization");

        // Return response with header
        return ResponseEntity.ok()
                .header("Authorization", authHeader)
                .body(userRegisterDetails.getUsername() + " user register successfully.");
    }


    @GetMapping("/users")
    public String getUserDetails(String username){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Return user details successfully";
    }

}
