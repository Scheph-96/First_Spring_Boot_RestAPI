/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.spring.api.school.rest.controller;

import com.spring.api.school.rest.models.Pays;
import com.spring.api.school.rest.repository.LocaliteRepository;
import com.spring.api.school.rest.repository.PaysRepository;
import com.spring.api.school.rest.services.GestLocaliteInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author The_Me
 */

@RestController
public class ApiControllers {
    
    @Autowired
    private GestLocaliteInterface gestLocImpl;
    
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }
    
    @PostMapping(value = "/save")
    public String createPays(@RequestBody Pays pays) {
        return gestLocImpl.createPays(pays);
    }
    
    @GetMapping(value = "/pays")
    public List<Pays> readPays(){
        return gestLocImpl.readPays();
    }

}
