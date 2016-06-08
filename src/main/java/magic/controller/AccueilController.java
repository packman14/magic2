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
import magic.service.SortService;
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
    
    @Autowired SortService sos;
    
    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String logGET(Model model, HttpSession session) {

        cs.initialiserSorts();
        model.addAttribute("nouvSorciere", new Sorciere());
        return "accueil";
    }
    
    
    @RequestMapping(value = "/connex", method = RequestMethod.POST)
    public String logPOST(@ModelAttribute(value = "nouvSorciere") Sorciere so, HttpSession session)
    {
        ss.save(so);
        session.setAttribute("sorciereCo", ss.findOne(so.getId()));
        return "redirect:/choix";
    }
    
    @RequestMapping(value = "/deconnex", method = RequestMethod.GET)
    public String delogPOST(HttpSession session)
    {
        Sorciere sorciere = (Sorciere) session.getAttribute("sorciereCo");
        ps.deconnecterSorciere(sorciere.getId());
        session.invalidate();
        return "redirect:/accueil";
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
        session.setAttribute("sorciereCo", sorciere);
        ps.initPartie(sorciere.getId());
        
        session.setAttribute("sorciereCo", ss.findOne(sorciere.getId()));
        
        return "redirect:/plateau";
    }

    
    
}
