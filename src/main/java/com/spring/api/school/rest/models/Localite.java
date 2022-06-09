/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.spring.api.school.rest.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author The_Me
 */
@Entity
@Table(name = "localite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localite.findAll", query = "SELECT l FROM Localite l"),
    @NamedQuery(name = "Localite.findByIdLoc", query = "SELECT l FROM Localite l WHERE l.idLoc = :idLoc"),
    @NamedQuery(name = "Localite.findByCodeLoc", query = "SELECT l FROM Localite l WHERE l.codeLoc = :codeLoc"),
    @NamedQuery(name = "Localite.findByNomLoc", query = "SELECT l FROM Localite l WHERE l.nomLoc = :nomLoc"),
    @NamedQuery(name = "Localite.findByPopulation", query = "SELECT l FROM Localite l WHERE l.population = :population")})
public class Localite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLoc")
    private Long idLoc;
    @Column(name = "codeLoc")
    private String codeLoc;
    @Column(name = "nomLoc")
    private String nomLoc;
    @Column(name = "population")
    private Integer population;
    @JoinColumn(name = "idPays", referencedColumnName = "id")
    @ManyToOne
    private Pays idPays;

    public Localite() {
    }

    public Localite(Long idLoc) {
        this.idLoc = idLoc;
    }

    public Long getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(Long idLoc) {
        this.idLoc = idLoc;
    }

    public String getCodeLoc() {
        return codeLoc;
    }

    public void setCodeLoc(String codeLoc) {
        this.codeLoc = codeLoc;
    }

    public String getNomLoc() {
        return nomLoc;
    }

    public void setNomLoc(String nomLoc) {
        this.nomLoc = nomLoc;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Pays getIdPays() {
        return idPays;
    }

    public void setIdPays(Pays idPays) {
        this.idPays = idPays;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoc != null ? idLoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localite)) {
            return false;
        }
        Localite other = (Localite) object;
        if ((this.idLoc == null && other.idLoc != null) || (this.idLoc != null && !this.idLoc.equals(other.idLoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.api.school.rest.models.Localite[ idLoc=" + idLoc + " ]";
    }

}
