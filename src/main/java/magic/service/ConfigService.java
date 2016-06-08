/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.service;

import java.util.ArrayList;
import java.util.List;
import magic.DAO.SortCRUDService;
import magic.entity.Ingredient;
import magic.entity.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajc
 */
@Service
public class ConfigService {
    
    @Autowired
    private SortCRUDService scs;
    
    public List<String> urlCartesSorcieres()
    {
        List<String> cartes = new ArrayList<>();
        
        for(int i = 1; i<= 8; ++i)
        {
            cartes.add("IMG/sorciere" + i + ".jpg");
        }
        
        return cartes;
        
    }
    
    public String urlCarteIngredient(Ingredient.TypeIngredient typeIngredient)
    {
        switch(typeIngredient)
        {
            case BATWING:
            {
                return "IMG/batwing.jpg";
            }
            case BAVECRAPAUD:
            {
                return "IMG/bave_crapaud.jpg";
            }
            case LAPIS:
            {
                return "IMG/lapis.jpg";
            }
            case LICORNE:
            {
                return "IMG/licorne.jpg";
            }
            case SANGVIERGE:
            {
                return "IMG/sang_vierge.jpg";
            }
            default:
            {
                return "";
            }
        }
    }
    
//    public Sort.TypeSort recetteSort(Ingredient.TypeIngredient ingredient1, Ingredient.TypeIngredient ingredient2) 
//    {
//        if (ingredient1.equals(Ingredient.TypeIngredient.LICORNE) || ingredient2.equals(Ingredient.TypeIngredient.LICORNE)) 
//        {
//            if (ingredient1.equals(Ingredient.TypeIngredient.BAVECRAPAUD) || ingredient2.equals(Ingredient.TypeIngredient.BAVECRAPAUD))
//            {
//                return Sort.TypeSort.INVISIBILITE;
//            }
//            else if(ingredient1.equals(Ingredient.TypeIngredient.SANGVIERGE) || ingredient2.equals(Ingredient.TypeIngredient.SANGVIERGE))
//        }
//        return Sort.TypeSort.DIVINATION;
//    }
    
    public void initialiserSorts()
    {
        if(scs.findAll().isEmpty())
        {
            
            
            Sort sort = new Sort();
            List<Ingredient.TypeIngredient> recette = new ArrayList<>();
            
            recette.add(Ingredient.TypeIngredient.LICORNE);
            recette.add(Ingredient.TypeIngredient.BAVECRAPAUD);
            sort.setTypeSort(Sort.TypeSort.INVISIBILITE);
            sort.setRecette(recette);
            
            scs.save(sort);
            
            
            sort = new Sort();
            recette = new ArrayList<>();
            
            recette.add(Ingredient.TypeIngredient.LICORNE);
            recette.add(Ingredient.TypeIngredient.SANGVIERGE);
            sort.setTypeSort(Sort.TypeSort.FILTREAMOUR);
            sort.setRecette(recette);
            
            scs.save(sort);
            
            
            sort = new Sort();
            recette = new ArrayList<>();
            
            recette.add(Ingredient.TypeIngredient.BAVECRAPAUD);
            recette.add(Ingredient.TypeIngredient.LAPIS);
            sort.setTypeSort(Sort.TypeSort.HYPNOSE);
            sort.setRecette(recette);
            
            scs.save(sort);
            
            
            sort = new Sort();
            recette = new ArrayList<>();
            
            recette.add(Ingredient.TypeIngredient.LAPIS);
            recette.add(Ingredient.TypeIngredient.BATWING);
            sort.setTypeSort(Sort.TypeSort.DIVINATION);
            sort.setRecette(recette);
            
            scs.save(sort);
            
            
            sort = new Sort();
            recette = new ArrayList<>();
            
            recette.add(Ingredient.TypeIngredient.SANGVIERGE);
            recette.add(Ingredient.TypeIngredient.BAVECRAPAUD);
            sort.setTypeSort(Sort.TypeSort.SOMMEILPROFOND);
            sort.setRecette(recette);
            
            scs.save(sort);
        }
    }
}
