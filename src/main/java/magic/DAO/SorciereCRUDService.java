/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.DAO;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import magic.entity.Sorciere;

/**
 *
 * @author ajc
 */
public interface SorciereCRUDService extends CrudRepository<Sorciere, Long>{
    
    @Override
    public List<Sorciere> findAll();
}
