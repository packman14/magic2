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

/**
 *
 * @author ajc
 */
@Controller
public class JeuController {

    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String logGET(Model model) {

        model.addAttribute("sorciereCo", new Sorciere());
        return "accueil";
    }
    @RequestMapping(value = "/accueil", method = RequestMethod.POST)
    public String logPOST(@ModelAttribute(value = "sorciereCo") Sorciere so, HttpSession session)
    {
        session.setAttribute("sorciereCo", session);
        return "redirect:/plateau";
    }

    @RequestMapping(value = "/plateau", method = RequestMethod.GET)
    public String ajaxPlateau() {

        return "plateau";
    }

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
}
