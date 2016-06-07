/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.controller;

import javax.servlet.http.HttpSession;
import magic.entity.Partie;
import magic.entity.Sorciere;
import magic.service.ConfigService;
import magic.service.PartieService;
import magic.service.SorciereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ajc
 */
@Controller
public class JeuController {

    @Autowired
    private ConfigService cs;

    @Autowired
    private SorciereService ss;

    @Autowired
    private PartieService ps;

    
    @RequestMapping(value = "/ressources/{idSorciere}", method = RequestMethod.GET)
    public String ajaxRessources(@PathVariable("idSorciere") Long idSorciere, Model model) 
    {
        if (idSorciere == 1) 
        {
            model.addAttribute("maRessource", "ailes de chauve souris");
        } else if (idSorciere == 2) 
        {
            model.addAttribute("maRessource", "sang de vierge");
        }

        return "ressources";
    }
    
    @RequestMapping(value = "/attente", method = RequestMethod.GET)
    public String ajaxAttente(Model model, HttpSession session) {
        
        Sorciere sorciereCo = (Sorciere) session.getAttribute("sorciereCo");
        model.addAttribute("partieEnCours", ps.getPartieEnCours(sorciereCo.getId()));
        return "attente";
    }
    
    
    @RequestMapping(value = "/plateau", method = RequestMethod.GET)
    public String plateauGet(Model model, HttpSession session)
    {
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        model.addAttribute("partieEnCours", ps.getPartieEnCours(sorciere.getId()));
        return "plateau";
    }
    
    @RequestMapping(value = "/debut", method = RequestMethod.GET)
    public String debutGet(Model model, HttpSession session)
    {
        Sorciere sorciere = (Sorciere)session.getAttribute("sorciereCo");
        ps.commencerPartie(sorciere.getId());
        ps.getPartieEnCours(sorciere.getId());
        
        session.setAttribute("sorciereCO", ss.findOne(sorciere.getId()));
        return "redirect:/jeu";
    }
    
    @RequestMapping(value = "/jeu", method = RequestMethod.GET)
    public String jeuGet(Model model, HttpSession session)
    {
        Sorciere sorciere = (Sorciere)session.getAttribute("sorciereCo");
        model.addAttribute("partieEnCours", ps.getPartieEnCours(sorciere.getId()));
//        model.addAttribute("formActionDTO", new FormActionDTO());
        
        return "jeu";
    }
    
}
