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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author ajc
 */
@Entity
public class Sort implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public enum TypeSort
    {
        INVISIBILITE,
        FILTREAMOUR,
        HYPNOSE,
        DIVINATION,
        SOMMEILPROFOND
    }
    
    
    
    @Enumerated(EnumType.STRING)
    private TypeSort typeSort;
    
    private List<Ingredient.TypeIngredient> recette = new ArrayList<>();
        
    
    private Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient.TypeIngredient> getRecette() {
        return recette;
    }

    public void setRecette(List<Ingredient.TypeIngredient> recette) {
        this.recette = recette;
    }

    public TypeSort getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(TypeSort typeSort) {
        this.typeSort = typeSort;
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
        if (!(object instanceof Sort)) {
            return false;
        }
        Sort other = (Sort) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "magic.entity.Sort[ id=" + id + " ]";
    }

}
