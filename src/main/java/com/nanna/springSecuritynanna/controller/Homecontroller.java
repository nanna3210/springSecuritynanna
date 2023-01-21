package com.nanna.springSecuritynanna.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Homecontroller {
    
//    method level authorization
    @PreAuthorize ( "hasRole('normal')" )
    @GetMapping("/normal")
    public ResponseEntity<String>  normaluser() {
    
        return ResponseEntity.ok ( "NOrmal user _____ " );
    }
    
    
    @PreAuthorize ( "hasRole('admin')" )
    @GetMapping("/admin")
    public ResponseEntity<String>  adminuser() {
        
        return ResponseEntity.ok ( "admmin user _____ " );
    }
    
    @GetMapping("/public")
    public ResponseEntity<String>  publicuser() {
        
        return ResponseEntity.ok ( "public user _____ " );
    }
    
    
    
}
