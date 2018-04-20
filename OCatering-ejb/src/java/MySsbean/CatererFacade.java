/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.Caterer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author K
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
    
    
    @Override
    public boolean checklogin(String a, String b){
        Query q = em.createQuery("SELECT c FROM Caterer c WHERE c.catererUs = :catererUs and c.password = :password");
        q.setParameter("catererUs", a);
        q.setParameter("password", b);
        try{
        q.getSingleResult();
        return true;
        }catch(Exception e){
        return false;
        }
    }
}
