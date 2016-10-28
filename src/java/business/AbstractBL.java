/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.persistence.EntityManager;

/**
 *
 * @author demetrius
 */
public abstract class AbstractBL<T> {
   
    private Class<T> entityType;

    public AbstractBL(Class<T> entityType) {
        this.entityType = entityType;
    }
    
    protected abstract EntityManager getManager();
    
    public void create(){}
    
    public void update(){}
    
    public void delete(){}
    
    public void findAll(){}
    
    public void findOne(){}
    
}
