/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;
import modelos.Funcionario;

/**
 *
 * @author demetrius
 */
@Named(value = "funcionarios")
@SessionScoped
public class FuncionarioMB implements Serializable {

    @Inject
    RepositorioMB repositorio;
    
    /**
     * Creates a new instance of FuncionarioMB
     */
    public FuncionarioMB() {
    }
    
    public ArrayList<Funcionario> obterTodos(){
        
        return repositorio.getFuncionarios();
        
    }
    
}
