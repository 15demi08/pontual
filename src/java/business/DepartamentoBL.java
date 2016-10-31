/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Departamento;

/**
 *
 * @author demetrius
 */
@Stateless
public class DepartamentoBL extends AbstractBL<Departamento> {

    @PersistenceContext(unitName = "PontualPU")
    private EntityManager em;

    public DepartamentoBL() {
        super(Departamento.class);
    }
    
    @Override
    protected EntityManager getManager() {
        return em;
    }
    
}
