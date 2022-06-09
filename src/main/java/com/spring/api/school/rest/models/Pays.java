/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.spring.api.school.rest.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author The_Me
 */
@Entity
@Table(name = "pays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"),
    @NamedQuery(name = "Pays.findById", query = "SELECT p FROM Pays p WHERE p.id = :id"),
    @NamedQuery(name = "Pays.findByCode", query = "SELECT p FROM Pays p WHERE p.code = :code"),
    @NamedQuery(name = "Pays.findByNom", query = "SELECT p FROM Pays p WHERE p.nom = :nom"),
    @NamedQuery(name = "Pays.findByIndicatif", query = "SELECT p FROM Pays p WHERE p.indicatif = :indicatif"),
    @NamedQuery(name = "Pays.findByLangOff", query = "SELECT p FROM Pays p WHERE p.langOff = :langOff")})
public class Pays implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "nom")
    private String nom;
    @Column(name = "indicatif")
    private Integer indicatif;
    @Column(name = "langOff")
    private String langOff;
    @OneToMany(mappedBy = "idPays")
    private Collection<Localite> localiteCollection;

    public Pays() {
    }

    public Pays(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIndicatif() {
        return indicatif;
    }

    public void setIndicatif(Integer indicatif) {
        this.indicatif = indicatif;
    }

    public String getLangOff() {
        return langOff;
    }

    public void setLangOff(String langOff) {
        this.langOff = langOff;
    }

    @XmlTransient
    public Collection<Localite> getLocaliteCollection() {
        return localiteCollection;
    }

    public void setLocaliteCollection(Collection<Localite> localiteCollection) {
        this.localiteCollection = localiteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.api.school.rest.models.Pays[ id=" + id + " ]";
    }

}
