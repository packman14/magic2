/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import DAO.PartieCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import streaming.entity.Partie;

/**
 *
 * @author ajc
 */
@Service
public class PartieService 
{

    @Autowired
    private PartieCRUDService pcs;
    
    public void joueurSuivant(Long partieID)
    {
        Partie partieActuelle = pcs.findOne(partieID);
        int joueurActuel = partieActuelle.getNumeroSorciere();
        if(joueurActuel < partieActuelle.getNbJoueurs())
        {
            partieActuelle.setNumeroSorciere(++joueurActuel);
        }
        else
        {
            partieActuelle.setNumeroSorciere(1);
        }
        pcs.save(partieActuelle);
    }
}
