/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import streaming.entity.Ingredient;
import streaming.entity.Sort;

/**
 *
 * @author moi
 */
public class SortService {

    @Autowired
    private SortCRUDService scs;

    public void lancerSort(Ingredient ingredient1, Ingredient ingredient2, Long sorciereIDSource, Long sorciereIDCible) throws RuntimeException {
        List<Sort> sorts = scs.findAll();
        for (Sort s : sorts) {
            if (s.getRecette().contains(ingredient1.getTypeIngredient()) 
                    && s.getRecette().contains(ingredient2.getTypeIngredient())) {
                effetsSort(s.getTypeSort(), sorciereIDSource, sorciereIDCible);
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

            }
            case HYPNOSE: {

            }
            case INVISIBILITE: {

            }
            case SOMMEILPROFOND: {

            }
        }
    }

}
