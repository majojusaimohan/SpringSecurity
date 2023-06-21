package com.Keycloak.KeyCloakSSO.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/balance")
    public String getBalanceDetails(){
        return "Welcome to balance details";
    }
}
