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
import org.springframework.stereotype.Service;

/**
 * 
 * @author The_Me
 */
@Service
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
                message = "Object Not found!";
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
                message = "Invalid Pays Object";
            }else{
                message = "Something went wrong! "+e.getMessage();
                System.out.println(e);
            }
        }
        
        return message;
    }

    @Override
    public String createLocalite(Localite localite) {
        String message;
        
        try {
            localiteRepo.save(localite);
            
            message = "Done!";
        } catch (Exception e) {
            if(e instanceof IllegalArgumentException){
                message = "Invalid Localite Object";
            }else{
                message = "Something went wrong! "+e.getMessage();
                System.out.println(e);
            }
        }
        
        return message;
    }

    @Override
    public List<Localite> readLocalite() {
        List<Localite> localites = localiteRepo.findAll();
        
        return localites;
    }

    @Override
    public String updateLocalite(long idLocalite, Localite localite) {
        String message;
        
        try{
             Localite updateLocalite = localiteRepo.getById(idLocalite);
             
             updateLocalite.setCodeLoc(localite.getCodeLoc());
             updateLocalite.setIdPays(localite.getIdPays());
             updateLocalite.setNomLoc(localite.getNomLoc());
             updateLocalite.setPopulation(localite.getPopulation());
             localiteRepo.save(updateLocalite);
             
             message = "Done!";
        }catch(Exception e){
            if(e instanceof EntityNotFoundException){
                message = "Object Not Found!";
            }else{
                message = "Something went wrong! "+e.getMessage();
                System.out.println(e);
            }
        }
        
        return message;
    }

    @Override
    public String deleteLocalite(Localite localite) {
        String message;
        
        try{
            localiteRepo.delete(localite);
            
            message = "Done!";
        }catch(Exception e){
            if(e instanceof IllegalArgumentException){
                message = "Invalid Localite Object";
            }else{
                message = "Something went wrong! "+e.getMessage();
                System.out.println(e);
            }
        }
        
        return message;
    }

}
