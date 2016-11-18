/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Ponto;

@Stateless
public class PontoBL extends AbstractBL<Ponto> {

    @PersistenceContext
    private EntityManager em;
    
    public PontoBL() {
        super(Ponto.class);
    }

    @Override
    protected EntityManager getManager() {
        return em;
    }

    @Override
    public void validateFields(Ponto obj) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
