/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.api.school.rest.repository;

import com.spring.api.school.rest.models.Localite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Me
 */

@Repository
public interface LocaliteRepository extends JpaRepository<Localite, Long>{
    
}
