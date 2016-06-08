/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import magic.entity.Ingredient;
import magic.entity.Partie;
import magic.entity.Sorciere;
import magic.service.IngredientService;
import magic.service.PartieService;
import magic.service.SorciereService;
import magic.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ajc
 */
@Controller
public class AjaxController {
    
    @Autowired
    private PartieService ps;
    
    @Autowired
    private IngredientService is;
    
    @Autowired
    private SorciereService ss;
    
    @Autowired
    private SortService sos;
    
    @RequestMapping(value = "/actualiseringredients", method = RequestMethod.GET)
    public String ajaxActualiserIngredients(Model model, HttpSession session) {
        
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        Sorciere nouvSorciere = ss.findOne(sorciere.getId());
        List<Ingredient> ingredients = nouvSorciere.getIngredients();
        model.addAttribute("ingredientsDispo", ingredients);
        return "ingredients_dispo";
    }
    
    @RequestMapping(value = "/actualisertour", method = RequestMethod.GET)
    public String ajaxActualiserTour(Model model, HttpSession session) {
        
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        model.addAttribute("partieEnCours", ps.getPartieEnCours(sorciere.getId()));
        
        return "tour_actuel";
    }
    
    @RequestMapping(value = "/actualiserjeu", method = RequestMethod.GET)
    public String ajaxActualiserJeu(Model model, HttpSession session) {
        
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        model.addAttribute("partieEnCours", ps.getPartieEnCours(sorciere.getId()));
        return "actualiser_jeu";
    }
    
    @RequestMapping(value = "/piocher", method = RequestMethod.POST)
    public String ajaxPiocher(Model model, HttpSession session) {
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        Partie partieEnCours = sorciere.getPartieEnCours();//TODO incrémenter le tour actuel
        is.ajouterIngredientAleatoire(sorciere.getId());
        
        session.setAttribute("sorciereCo", ss.findOne(sorciere.getId()));
        
        return "page_vide";
    }
    
    @RequestMapping(value = "/sort/{idCarte1}/{idCarte2}", method = RequestMethod.POST)
    public String ajaxLancerSort(@PathVariable("idCarte1") Long idCarte1, @PathVariable("idCarte2") Long idCarte2, Model model, HttpSession session) {
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        Partie partieEnCours = sorciere.getPartieEnCours();
        
        
        
        sos.lancerSort(idCarte1, idCarte2, sorciere.getId(), null);
        
        ps.joueurSuivant(partieEnCours.getId());
        
        
        session.setAttribute("sorciereCo", ss.findOne(sorciere.getId()));
        
        return "page_vide";
    }
    
}
