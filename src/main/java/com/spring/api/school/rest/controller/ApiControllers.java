/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.spring.api.school.rest.controller;

import com.spring.api.school.rest.models.Localite;
import com.spring.api.school.rest.models.Pays;
import com.spring.api.school.rest.repository.LocaliteRepository;
import com.spring.api.school.rest.repository.PaysRepository;
import com.spring.api.school.rest.services.GestLocaliteInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    //Pays CRUD
    @PostMapping(value = "/save_pays")
    public String createPays(@RequestBody Pays pays) {
        return gestLocImpl.createPays(pays);
    }
    
    @GetMapping(value = "/pays")
    public List<Pays> readPays(){
        return gestLocImpl.readPays();
    }
    
    @PutMapping(value = "/update_localite/{id}")
    public String updatePays(@PathVariable long id, @RequestBody Pays pays){
        return gestLocImpl.updatePays(id, pays);
    }
    
    @DeleteMapping(value = "/delete_pays")
    public String deletePays(@RequestBody Pays pays){
        return gestLocImpl.deletePays(pays);
    }
    
    
    //Localite CRUD
    @PostMapping(value = "/save_localite")
    public String createLocalite(@RequestBody Localite localite){
        return gestLocImpl.createLocalite(localite);
    }
    
    @GetMapping(value = "/localites")
    public List<Localite> readLocalite(){
        return gestLocImpl.readLocalite();
    }
    
    @PutMapping(value = "/update_localite/{id}")
    public String updateLocalite(@PathVariable long id, @RequestBody Localite localite){
        return gestLocImpl.updateLocalite(id, localite);
    }
    
    @DeleteMapping(value = "/delete_localite")
    public String deleteLocalite(@RequestBody Localite loclite){
        return gestLocImpl.deleteLocalite(loclite);
    }

}
