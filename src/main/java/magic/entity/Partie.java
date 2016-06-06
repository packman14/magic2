/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ajc
 */
@Entity
public class Partie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numeroSorciere;
    
    private int nbJoueurs;
    
    @OneToMany (mappedBy = "partieEnCours")
    @JoinColumn(name = "partie_id")
    private List<Sorciere> sorcieresEnJeu= new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroSorciere() {
        return numeroSorciere;
    }

    public void setNumeroSorciere(int numeroSorciere) {
        this.numeroSorciere = numeroSorciere;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public List<Sorciere> getSorcieresEnJeu() {
        return sorcieresEnJeu;
    }

    public void setSorcieresEnJeu(List<Sorciere> sorcieresEnJeu) {
        this.sorcieresEnJeu = sorcieresEnJeu;
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
        if (!(object instanceof Partie)) {
            return false;
        }
        Partie other = (Partie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "magic.entity.Partie[ id=" + id + " ]";
    }
    
}
