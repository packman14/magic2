/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import magic.entity.Sorciere;
import magic.service.ConfigService;
import magic.service.PartieService;
import magic.service.SorciereService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ajc
 */
@Controller
public class AccueilController {

    @Autowired
    private ConfigService cs;
    
    @Autowired
    private SorciereService ss;
    
    @Autowired
    private PartieService ps;
    
    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String logGET(Model model) {

        model.addAttribute("sorciereCo", new Sorciere());
        return "accueil";
    }
    
    
    @RequestMapping(value = "/accueil", method = RequestMethod.POST)
    public String logPOST(@ModelAttribute(value = "sorciereCo") Sorciere so, HttpSession session)
    {
        session.setAttribute("sorciereCo", so);
        return "redirect:/choix";
    }
    
    
    @RequestMapping(value = "/choix", method = RequestMethod.GET)
    public String choixGet(Model model)
    {
        model.addAttribute("mesSkins",cs.urlCartesSorcieres());
        
        return "choix";
    }
    
    
    @RequestMapping(value = "/choix/{numSkin}", method = RequestMethod.GET)
    public String choixPost(@PathVariable("numSkin") int numSorciere, HttpSession session)
    {
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        ss.initialiserSorciere(sorciere, numSorciere);
        
        ps.initPartie(sorciere.getId());
        
        return "redirect:/attente";
    }

    
    @RequestMapping(value = "/attente", method = RequestMethod.GET)
    public String ajaxAttente(Model model, HttpSession session) {
        
        Sorciere sorciereCo = (Sorciere) session.getAttribute("sorciereCo");
        model.addAttribute("partieEnCours", ps.listeAutresSorcieres(sorciereCo.getId()));
        return "attente";
    }

    
    
}
