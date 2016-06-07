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
public class formActionDTO {
    
    private String action;
    
    private List<Ingredient> ingredients;
    
    private Sorciere cible;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Sorciere getCible() {
        return cible;
    }

    public void setCible(Sorciere cible) {
        this.cible = cible;
    }
    
    
}
