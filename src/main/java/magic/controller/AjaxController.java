/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.controller;

import javax.servlet.http.HttpSession;
import magic.entity.Sorciere;
import magic.service.IngredientService;
import magic.service.PartieService;
import magic.service.SorciereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ajc
 */
public class AjaxController {
    
    @Autowired
    private PartieService ps;
    
    @Autowired
    private IngredientService is;
    
    @Autowired
    private SorciereService ss;
    
    
    @RequestMapping(value = "/actualiserjeu", method = RequestMethod.GET)
    public String ajaxActualiserJeu(Model model, HttpSession session) {
        
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        model.addAttribute("partieEnCours", ps.getPartieEnCours(sorciere.getId()));
        return "actualiser_jeu";
    }
    
    @RequestMapping(value = "/piocher", method = RequestMethod.POST)
    public String ajaxPiocher(Model model, HttpSession session) {
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        
        is.ajouterIngredientAleatoire(sorciere.getId());
        
        session.setAttribute("sorciereCo", ss.findOne(sorciere.getId()));
        
        return "page_vide";
    }
    
}
