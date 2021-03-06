/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ajc
 */
@Entity
public class Sorciere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String pseudo;
    
    private int numero;
    
    private String skin;
    
    @Temporal(TemporalType.DATE)
    private Date dateCo;
    
    @OneToMany (mappedBy = "sorciere")
    @JoinColumn(name = "sorciere_id")
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    private Partie partieEnCours;

    
    public Date getDateCo() {
        return dateCo;
    }

    public void setDateCo(Date dateCo) {
        this.dateCo = dateCo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public void addIngredient(Ingredient ingredient)
    {
        this.ingredients.add(ingredient);
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Partie getPartieEnCours() {
        return partieEnCours;
    }

    public void setPartieEnCours(Partie partieEnCours) {
        this.partieEnCours = partieEnCours;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Sorciere)) {
            return false;
        }
        Sorciere other = (Sorciere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "magic.entity.Sorciere[ id=" + id + " ]";
    }
    
}
