/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.Caterer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Khanh
 */
@Stateless
public class CatererFacade extends AbstractFacade<Caterer> implements CatererFacadeLocal {
    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatererFacade() {
        super(Caterer.class);
    }
    
}
