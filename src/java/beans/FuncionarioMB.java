/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.FuncionarioBL;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
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
    FuncionarioBL funcionarioBL;
    
    Funcionario funcionarioSelecionado;

    /**
     * Creates a new instance of FuncionarioMB
     */
    public FuncionarioMB() {
        
        funcionarioSelecionado = new Funcionario();
        
    }

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }
    
    public List<Funcionario> listAll(){
        return funcionarioBL.findAll();
    }
    
}
