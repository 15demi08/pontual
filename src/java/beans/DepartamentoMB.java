/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.BusinessException;
import business.DepartamentoBL;
import business.FuncionarioBL;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.Departamento;

/**
 *
 * @author demetrius
 */
@Named(value = "departamentos")
@SessionScoped
public class DepartamentoMB implements Serializable {

    @Inject
    DepartamentoBL departamentoBL;
    
    @Inject
    FuncionarioBL funcionarioBL;
    
    private Departamento tempDepartamento, deptoSelecionado;
    
    /**
     * Creates a new instance of DepartamentoMB
     */
    public DepartamentoMB() {
        
        tempDepartamento = new Departamento();
        
    }

    public Departamento getTempDepartamento() {
        return tempDepartamento;
    }

    public void setTempDepartamento(Departamento tempDepartamento) {
        this.tempDepartamento = tempDepartamento;
    }

    public Departamento getDeptoSelecionado() {
        return deptoSelecionado;
    }

    public void setDeptoSelecionado(Departamento deptoSelecionado) {
        this.deptoSelecionado = deptoSelecionado;
    }
    
    public List<Departamento> listAll(){
        
        return departamentoBL.findAll();
        
    }
    
    public String cadastrar(){
        
        try {
            
            departamentoBL.validateFields(tempDepartamento);
            
            departamentoBL.insert(tempDepartamento);
            
            tempDepartamento = new Departamento();
            
            FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
            
            return "departamentos";
            
        } catch( BusinessException ex ){
            
            FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
            
            return "novoDepartamento";
            
        }
        
    }
    
    public String visualizar( Departamento departamento ){
        
        deptoSelecionado = departamento;
        
        return "visualizarDepartamento";
        
    }
    
    public String editar( Departamento departamento ){
        
        deptoSelecionado = departamento;
        
        return "editarDepartamento";
        
    }
    
    public String atualizar(){
        
        try {
            
            departamentoBL.validateFields(deptoSelecionado);
            
            departamentoBL.update(deptoSelecionado);
            
            deptoSelecionado = new Departamento();
            
            FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", ""));
            
            return "departamentos";
        
        } catch (BusinessException ex) {
         
            FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
            
            return "editarDepartamento";
            
        }
        
    }
    
}
