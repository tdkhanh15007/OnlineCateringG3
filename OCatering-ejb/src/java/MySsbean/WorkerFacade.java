/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.Worker;
import MyEntity.Worker_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Khanh
 */
@Stateless
public class WorkerFacade extends AbstractFacade<Worker> implements WorkerFacadeLocal {
    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkerFacade() {
        super(Worker.class);
    }

    @Override
    public List<Worker> findType(int type) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root root = query.from(Worker.class);
        query.select(root);
        query.where(builder.equal(root.get(Worker_.worktypeId),type));
        Query q = em.createQuery(query);
        return q.getResultList();
    }
    
}
