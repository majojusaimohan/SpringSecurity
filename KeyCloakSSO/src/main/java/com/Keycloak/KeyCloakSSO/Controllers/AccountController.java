package com.Keycloak.KeyCloakSSO.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/account")
    public String getAccountDetails(){
        return "Welcome to Account details";
    }
}
