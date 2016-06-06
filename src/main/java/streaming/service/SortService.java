/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import streaming.entity.Ingredient;
import streaming.entity.Sort;

/**
 *
 * @author ajc
 */
public class SortService {
    
    @Autowired
    private SortCRUDService scs;
    
    public void lancerSort(Ingredient ingredient1, Ingredient ingredient2, Long sorciereID)
    {
        List<Sort> sorts = scs.findAll();
        for(Sort s : sorts)
        {
            
        }
    }
    
}
