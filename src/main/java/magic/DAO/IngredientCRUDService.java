/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.DAO;

import org.springframework.data.repository.CrudRepository;
import magic.entity.Ingredient;

/**
 *
 * @author ajc
 */
public interface IngredientCRUDService extends CrudRepository<Ingredient, Long>{
    
}
