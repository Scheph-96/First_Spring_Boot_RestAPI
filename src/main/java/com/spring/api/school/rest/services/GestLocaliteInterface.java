/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.api.school.rest.services;

import com.spring.api.school.rest.models.Localite;
import com.spring.api.school.rest.models.Pays;
import java.util.List;

/**
 *
 * @author The_Me
 */
public interface GestLocaliteInterface {
    
    public String createPays(Pays pays);
    public List<Pays> readPays();
    public String updatePays(long idPays, Pays pays);
    public String deletePays(Pays pays);
    
    public String createLocalite(Localite localite);
    public List<Localite> readLocalite();
    public String updateLocalite(long idLocalite, Localite localite);
    public String deleteLocalite(Localite localite);
    
}
