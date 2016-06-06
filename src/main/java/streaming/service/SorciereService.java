/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import streaming.entity.Sorciere;

/**
 *
 * @author ajc
 */
@Service
public class SorciereService {
    
    @Autowired
    private SorciereCRUDService socs;
    
    @Autowired
    private IngredientService is;
    
    public void initialiserRessources(Long sorciereID)
    {
        for(int i = 1; i<=7; ++i)
        {
            is.ajouterIngredientAleatoire(sorciereID);
        }
    }
}
