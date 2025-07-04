package foro.API.Api.foro.controller;

import foro.API.Api.foro.domain.user.AuthenticationData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationData dataUser){
        var token = new UsernamePasswordAuthenticationToken(dataUser.username(), dataUser.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
