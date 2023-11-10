package org.yna.sec.securitykeycloack.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    
    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public String hello(){
        return "Bonjour ma sécurité avec keycloack";
    }

     @GetMapping("/hello")
     @PreAuthorize("hasRole('client_admin')")
    public String hello1(){
        return "Bonjour ma sécurité avec keycloack en tant que ADMIN";
    }

}
