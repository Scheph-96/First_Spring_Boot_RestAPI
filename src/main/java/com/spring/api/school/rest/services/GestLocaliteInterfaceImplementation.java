/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.spring.api.school.rest.services;

import com.spring.api.school.rest.models.Localite;
import com.spring.api.school.rest.models.Pays;
import com.spring.api.school.rest.repository.LocaliteRepository;
import com.spring.api.school.rest.repository.PaysRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author The_Me
 */
public class GestLocaliteInterfaceImplementation implements GestLocaliteInterface{
    
    @Autowired
    private PaysRepository paysRepo;
    private LocaliteRepository localiteRepo;

    @Override
    public String createPays(Pays pays) {
        String message;
        try{
            paysRepo.save(pays);
            message = "Done!";
        }catch(Exception e){
            if(e instanceof IllegalArgumentException){
                message = "Invalid Pays data";
            }else{
                message = "Something went wrong! "+e.getMessage(); 
                System.out.println(e);
            }
        }
        
        return message;
    }

    @Override
    public List<Pays> readPays() {
        List<Pays> pays = paysRepo.findAll();
        
        return pays;
    }

    @Override
    public String updatePays(long idPays, Pays pays) {
        String message;
        
        try {
            Pays updatedPays = paysRepo.getById(idPays);
            updatedPays.setNom(pays.getNom());
            updatedPays.setCode(pays.getCode());
            updatedPays.setIndicatif(pays.getIndicatif());
            updatedPays.setLangOff(pays.getLangOff());
            updatedPays.setLocaliteCollection(pays.getLocaliteCollection());
            paysRepo.save(updatedPays);
            
            message = "Done!";
        } catch (Exception e) {
            if(e instanceof EntityNotFoundException){
                message = "Not found!";
            }else{
                message = "Something went wrong! "+e.getMessage();
                System.out.println(e);
            }
        }
        
        return message;
    }

    @Override
    public String deletePays(Pays pays) {
        String message;
        
        try {
            paysRepo.delete(pays);
            message = "Done!";
        } catch (Exception e) {
            if(e instanceof IllegalArgumentException){
                message = "Invalid Pays data";
            }else{
                message = "Something went wrong "+e.getMessage();
                System.out.println(e);
            }
        }
        
        return message;
    }

    @Override
    public String createLocalite(Localite localite) {
        String mesage;
        
        try {
            localiteRepo.save(localite);
            
        } catch (Exception e) {
        }
    }

    @Override
    public List<Localite> readLocalite() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String deleteLocalite(Localite localite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updateLocalite(long idLocalite, Localite localite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
