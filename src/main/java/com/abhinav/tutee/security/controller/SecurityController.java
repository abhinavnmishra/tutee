package com.abhinav.tutee.security.controller;



import com.abhinav.tutee.security.dto.AuthenticationRequest;
import com.abhinav.tutee.security.dto.AuthenticationResponse;
import com.abhinav.tutee.security.service.JwtUtil;
import com.abhinav.tutee.security.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SecurityController {

    @Autowired
    org.springframework.security.authentication.AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;



    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@javax.validation.Valid @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }

        final org.springframework.security.core.userdetails.UserDetails userDetails = securityUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


}
