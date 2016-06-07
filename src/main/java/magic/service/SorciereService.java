/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.service;

import magic.DAO.SorciereCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import magic.entity.Sorciere;

/**
 *
 * @author ajc
 */
@Service
public class SorciereService {
    
    @Autowired
    private ConfigService cs;
    
    @Autowired
    private IngredientService is;
    
    @Autowired
    private SorciereCRUDService scs;
    
    public void initialiserRessources(Long sorciereID)
    {
        for(int i = 1; i<=7; ++i)
        {
            is.ajouterIngredientAleatoire(sorciereID);
        }
    }
    
    public void initialiserSorciere(Sorciere sorciere, int numSorciere)
    {
        sorciere.setSkin(cs.urlCartesSorcieres().get(numSorciere));
        
        scs.save(sorciere);
        
        initialiserRessources(sorciere.getId());
    }
    
    public void save(Sorciere sorciere)
    {
        scs.save(sorciere);
    }
    
    public Sorciere findOne(Long sorciereID)
    {
        return scs.findOne(sorciereID);
    }
}
