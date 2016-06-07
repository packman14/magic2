/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.service;

import java.util.ArrayList;
import magic.DAO.SortCRUDService;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import magic.DAO.IngredientCRUDService;
import magic.DAO.SorciereCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import magic.entity.Ingredient;
import magic.entity.Sorciere;
import magic.entity.Sort;

/**
 *
 * @author moi
 */
@Service
public class SortService {

    @Autowired
    private SortCRUDService scs;
    
    @Autowired
    private SorciereCRUDService socr;
    
    @Autowired
    private IngredientCRUDService ics;

    public void lancerSort(Ingredient ingredient1, Ingredient ingredient2, Long sorciereIDSource, Long sorciereIDCible) throws RuntimeException {
        
        //récupérer tous les sorts
        List<Sort> sorts = scs.findAll();
        
        //pour tous les sorts existant
        for (Sort s : sorts) {
            
            //ingrédients correspondant à un sort
            if (s.getRecette().contains(ingredient1.getTypeIngredient()) 
                    && s.getRecette().contains(ingredient2.getTypeIngredient())) {
                effetsSort(s.getTypeSort(), sorciereIDSource, sorciereIDCible);
                ics.delete(ingredient2);
                ics.delete(ingredient1);
            }
            else{
                throw new RuntimeException("pas de recette correspondant aux ingrédients");
            }
        }
    }

    public void effetsSort(Sort.TypeSort typeSort, Long sorciereIDSource, Long sorciereIDCible) {
        switch (typeSort) {
            case DIVINATION: {
                
            }
            case FILTREAMOUR: {
                Sorciere sorciereCible = socr.findOne(sorciereIDCible);
                List<Ingredient> ingredientsCible = sorciereCible.getIngredients();
                if (ingredientsCible.size()>=1)
                {
                    
                }
                else
                {
                    
                }
                

            }
            case HYPNOSE: {

            }
            case INVISIBILITE: {
               List<Sorciere> sorciereCible = socr.findAllById(sorciereIDCible);
               for (Sorciere so:sorciereCible)
               {
                volerCarte(sorciereIDSource, sorciereIDCible);
               }
            }
            case SOMMEILPROFOND: {
                
            }
        }
    }
    public void volerCarte(Long sorciereIDSource, Long SorciereIDCible)
        {
            //Récuperation des sorcieres cibles et sources par ID
            Sorciere sorciereCible = socr.findOne(SorciereIDCible);
            Sorciere sorciereSource = socr.findOne(sorciereIDSource);
            //List des ingrédients de la sorciere cible
            List<Ingredient> ingredientsCible = sorciereCible.getIngredients();
            //récuperation d'un ingrédient random
            Ingredient ic = ingredientsCible.get(ThreadLocalRandom.current().nextInt(0, ingredientsCible.size()));
            //Modification de la sorciere propriétaire de l'ingrédient
            ic.setSorciere(sorciereSource);
//            //ajout de l'ingrédient dans la liste de la sorciere source
//            sorciereSource.addIngredient(ic);
//            //sauvegarde de l'ingrédient
//            is.save(ic);
//            //suppresion de l'ingrédient dans la liste de la sorciere cible
//            ingredientsCible.remove(ic);
        }
    

}
