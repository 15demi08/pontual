/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelos.Funcionario;
import modelos.Rotina;

/**
 *
 * @author demetrius
 */
@Stateless
public class RotinaBL extends AbstractBL<Rotina>{

    @PersistenceContext
    private EntityManager em;
    
    public RotinaBL() {
        super(Rotina.class);
    }

    @Override
    protected EntityManager getManager() {
        return em;
    }

    @Override
    public void validateFields(Rotina obj) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Rotina findByFuncionario(Funcionario funcionario) throws BusinessException {
        
        String queryStr = "SELECT r FROM Rotina r WHERE funcionario_matricula = :matricula";
        
        Query q = em.createQuery(queryStr);
        
        q.setParameter("matricula", funcionario.getMatricula());
        
        Rotina r = (Rotina) q.getSingleResult();
        
        if( r == null )            
            throw new BusinessException("Erro ao carregar a rotina do funcionário.");
        else
            return r;
        
    }
    
}
