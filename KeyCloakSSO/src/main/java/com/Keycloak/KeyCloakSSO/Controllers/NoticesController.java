package com.Keycloak.KeyCloakSSO.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getNoticeDetails(){
        return "Welcome to Notice details";
    }
}
