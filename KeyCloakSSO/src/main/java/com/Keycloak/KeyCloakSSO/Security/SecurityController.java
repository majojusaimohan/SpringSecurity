package com.Keycloak.KeyCloakSSO.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/welcome")
    public String Welcome(){
        return "Welcome to Spring security";
    }

}
