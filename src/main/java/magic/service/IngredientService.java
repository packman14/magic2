/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.service;

import magic.DAO.SorciereCRUDService;
import magic.DAO.IngredientCRUDService;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import magic.entity.Ingredient;
import magic.entity.Sorciere;

/**
 *
 * @author ajc
 */
@Service
public class IngredientService {

    @Autowired
    private IngredientCRUDService ics;

    @Autowired
    private SorciereCRUDService socs;

    public void ajouterIngredient(Long sorciereID, Ingredient.TypeIngredient typeIngredient) {
        Ingredient monIngredient = new Ingredient();
        monIngredient.setTypeIngredient(typeIngredient);

        Sorciere maSorciere = socs.findOne(sorciereID);
        maSorciere.addIngredient(monIngredient);

        ics.save(monIngredient);
        socs.save(maSorciere);
    }

    public void ajouterIngredientAleatoire(Long sorciereID) throws RuntimeException{
        Ingredient.TypeIngredient typeIngredient;
        switch (ThreadLocalRandom.current().nextInt(1, 5 + 1)) {
            case 1: {
                typeIngredient = Ingredient.TypeIngredient.BATWING;
                break;
            }
            case 2: {
                typeIngredient = Ingredient.TypeIngredient.BAVECRAPAUD;
                break;
            }
            case 3: {
                typeIngredient = Ingredient.TypeIngredient.LAPIS;
                break;
            }
            case 4: {
                typeIngredient = Ingredient.TypeIngredient.LICORNE;
                break;
            }
            case 5: {
                typeIngredient = Ingredient.TypeIngredient.SANGVIERGE;
                break;
            }
            default: {
                throw new RuntimeException("Erreur lors de la génération d'un type d'ingrédient aléatoire");
            }
        }
        ajouterIngredient(sorciereID, typeIngredient);
    }
}
