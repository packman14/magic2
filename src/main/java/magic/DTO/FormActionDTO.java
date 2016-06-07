package magic.DTO;

import java.util.List;
import magic.entity.Ingredient;
import magic.entity.Sorciere;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ajc
 */
public class FormActionDTO {
    
    private String action;
    
    private Ingredient ingredient1;
   
    private Ingredient ingredient2;
    
    private Sorciere cible;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Ingredient getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(Ingredient ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public Ingredient getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(Ingredient ingredient2) {
        this.ingredient2 = ingredient2;
    }


    public Sorciere getCible() {
        return cible;
    }

    public void setCible(Sorciere cible) {
        this.cible = cible;
    }
    
    
}
