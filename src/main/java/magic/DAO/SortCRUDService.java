/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.DAO;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import magic.entity.Sort;

/**
 *
 * @author ajc
 */
public interface SortCRUDService extends CrudRepository<Sort, Long>{
    @Override
    public List<Sort> findAll();
    
}
