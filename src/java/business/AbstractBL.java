/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author demetrius
 * @param <T>
 */
public abstract class AbstractBL<T> {
   
    private Class<T> entityType;

    public AbstractBL(Class<T> entityType) {
        this.entityType = entityType;
    }
    
    protected abstract EntityManager getManager();
    
    public void insert(T obj){
        getManager().persist(obj);
    }
    
    public void update(T obj){
        getManager().merge(obj);
    }
    
    public void delete(T obj){
        getManager().remove(getManager().merge(obj));
    }
    
    public T findOne( Long id ){
    
        return getManager().find(entityType, id);
    
    }
    
    public List<T> findAll(){
    
        CriteriaQuery cq = getManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityType));
        return getManager().createQuery(cq).getResultList();
        
    }
    
}
