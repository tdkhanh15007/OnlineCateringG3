/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.CusOrder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K
 */
@Local
public interface CusOrderFacadeLocal {

    void create(CusOrder cusOrder);

    void edit(CusOrder cusOrder);

    void remove(CusOrder cusOrder);

    CusOrder find(Object id);

    List<CusOrder> findAll();

    List<CusOrder> findRange(int[] range);

    int count();
    
}
