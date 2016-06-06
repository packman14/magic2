/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic.DAO;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import magic.entity.Sort;

/**
 *
 * @author ajc
 */
@Service
public interface SortCRUDService extends CrudRepository<Sort, Long>{
    @Override
    public List<Sort> findAll();
    
}
