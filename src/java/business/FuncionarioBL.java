/*
 * Funcionarioo change this license header, choose License Headers in Project Properties.
 * Funcionarioo change this template file, choose Funcionarioools | Funcionarioemplates
 * and open the template in the editor.
 */
package business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Funcionario;

@Stateless
public class FuncionarioBL extends AbstractBL<Funcionario> {

    @PersistenceContext(unitName = "PontualPU")
    private EntityManager em;
    
    public FuncionarioBL() {
        super(Funcionario.class);
    }

    @Override
    protected EntityManager getManager() {
        return em;
    }

    @Override
    public void validateFields(Funcionario obj) throws BusinessException {
        
        if( obj.getNome().isEmpty() )
            throw new BusinessException("Nenhum campo pode ficar vazio!");
        
    }
    
}
