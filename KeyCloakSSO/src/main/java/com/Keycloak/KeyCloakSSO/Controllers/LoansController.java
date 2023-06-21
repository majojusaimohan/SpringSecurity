package com.Keycloak.KeyCloakSSO.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/loans")
    public String getLoansDetails(){
        return "Welcome to loans details";
    }
}
