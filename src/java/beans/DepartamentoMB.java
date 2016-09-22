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
import modelos.Departamento;

/**
 *
 * @author demetrius
 */
@Named(value = "departamentoMB")
@SessionScoped
public class DepartamentoMB implements Serializable {
    
    private Departamento deptoParaCadastro, deptoSelecionado;
    
    private int nextId = 6;
    
    @Inject RepositorioMB repositorio;
    
    /**
     * Creates a new instance of DepartamentoMB
     */
    public DepartamentoMB() {
        
        deptoParaCadastro = new Departamento();
        
    }
    
    public boolean incluir( Departamento d ){
        
        deptoParaCadastro.setId(nextId++);
        
        return repositorio.getDepartamentos().add(d);
    }
    
    public Departamento obter( int id ){
        
        for( Departamento d : repositorio.getDepartamentos() )
            
            if( d.getId() == id )
                
                return d;
        
        return null;
        
    }
    
    public ArrayList<Departamento> obterTodos(){
        
        return repositorio.getDepartamentos();
        
    }
    
    public ArrayList<Departamento> filtrarPorNome( String nome ){
        
        ArrayList<Departamento>
                departamentos = repositorio.getDepartamentos(),
                resultado = new ArrayList<>();
        
        departamentos.stream().filter((d) -> ( d.getNome().contains(nome) )).forEach((d) -> {
            resultado.add(d);
        });
        
        return resultado;
        
    }
    
    public boolean remover( Departamento d ){
        
        return repositorio.getDepartamentos().remove(d);
        
    }
    
}
