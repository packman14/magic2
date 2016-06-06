/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajc
 */
@Service
public class ConfigService {
    
    public List<String> urlCartesSorcieres()
    {
        List<String> cartes = new ArrayList<>();
        
        for(int i = 1; i<= 8; ++i)
        {
            cartes.add("IMG/sorciere" + i + ".jpg");
        }
        
        return cartes;
        
    }
}
