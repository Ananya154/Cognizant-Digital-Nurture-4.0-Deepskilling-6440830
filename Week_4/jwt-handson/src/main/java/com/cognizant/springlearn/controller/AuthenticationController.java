package com.cognizant.springlearn.controller;

import java.util.*;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.*;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authentication");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String username = getUser(authHeader);
        LOGGER.info("Authenticating user: {}", username);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            roles.add(authority.getAuthority());
        }

        String token = generateJwt(username, roles);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        LOGGER.info("Token generated successfully");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decoded = new String(decodedBytes);
        return decoded.split(":")[0]; 
    }

    private String generateJwt(String user, List<String> roles) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.claim("roles", roles);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + 1200000)); 
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        return builder.compact();
    }
}
