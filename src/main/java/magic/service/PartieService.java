/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.service;

import java.util.List;
import magic.DAO.PartieCRUDService;
import magic.DAO.SorciereCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import magic.entity.Partie;
import magic.entity.Sorciere;

/**
 *
 * @author ajc
 */
@Service
public class PartieService 
{

    @Autowired
    private PartieCRUDService pcs;
    
    @Autowired
    private SorciereCRUDService scs;
    
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
    
    public void initPartie(Long sorciereID)
    {
        List<Partie> partiesEnAttente= pcs.findAllByPartieEnCours(Boolean.FALSE);
        if(partiesEnAttente.isEmpty())
        {
            Partie partie = new Partie();
            Sorciere sorciere = scs.findOne(sorciereID);
            
            partie.addSorciereEnJeu(sorciere);
            partie.setPartieEnCours(Boolean.FALSE);
            
            sorciere.setPartieEnCours(partie);
            
            scs.save(sorciere);
            pcs.save(partie);
            
        }
        else
        {
            Partie partie = partiesEnAttente.get(0);
            Sorciere sorciere = scs.findOne(sorciereID);
            
            partie.addSorciereEnJeu(sorciere);
            partie.setPartieEnCours(Boolean.FALSE);
            
            sorciere.setPartieEnCours(partie);
            
            scs.save(sorciere);
            pcs.save(partie);
        }
        
    }
    
    
    public List<Sorciere> listeSorcieresDeLaPartie(Long partieID)
    {
        return pcs.findOne(partieID).getSorcieresEnJeu();
    }
    
    public List<Sorciere> listeAutresSorcieres(Long sorciereID)
    {
        Sorciere sorciere = scs.findOne(sorciereID);
        List<Sorciere> sorcieres = sorciere.getPartieEnCours().getSorcieresEnJeu();
        sorcieres.remove(sorciere);
        return sorcieres;
    }
}
