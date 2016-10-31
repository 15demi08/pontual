/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.DepartamentoBL;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import modelos.Departamento;

/**
 *
 * @author demetrius
 */
@Named(value = "departamentos")
@SessionScoped
public class DepartamentoMB implements Serializable {
    
    private Departamento tempDepartamento;

    @Inject
    DepartamentoBL departamentoBL;
    
    /**
     * Creates a new instance of DepartamentoMB
     */
    public DepartamentoMB() {
    }

    public Departamento getTempDepartamento() {
        return tempDepartamento;
    }

    public void setTempDepartamento(Departamento tempDepartamento) {
        this.tempDepartamento = tempDepartamento;
    }
    
    public List<Departamento> listAll(){
        
        return departamentoBL.findAll();
        
    }
    
}
