/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.BusinessException;
import business.FuncionarioBL;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.Departamento;
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
        
    Funcionario funcionarioSelecionado, tempFuncionario;

    /**
     * Creates a new instance of FuncionarioMB
     */
    public FuncionarioMB() {
        
        tempFuncionario = new Funcionario();
        
    }

    public Funcionario getTempFuncionario() {
        return tempFuncionario;
    }

    public void setTempFuncionario(Funcionario tempFuncionario) {
        this.tempFuncionario = tempFuncionario;
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
    
    public String cadastrar(){
        
        try {
            
            funcionarioBL.validateFields(tempFuncionario);
            
            funcionarioBL.insert(tempFuncionario);
            
            tempFuncionario = new Funcionario();
            
            FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso! <i class=\"icon close\"></i>", ""));
            
            return "funcionarios";
            
        } catch( BusinessException ex ){
            
            FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
            
            return "novoFuncionario";
            
        }
        
    }
    
}
