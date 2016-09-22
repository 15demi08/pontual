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
import modelos.Ponto;

/**
 *
 * @author demetrius
 */
@Named(value = "pontos")
@SessionScoped
public class PontoMB implements Serializable {
    
    @Inject
    RepositorioMB repositorio;

    /**
     * Creates a new instance of PontoMB
     */
    public PontoMB() {
        
    }
    
    public ArrayList<Ponto> filtrarPontosPorFuncionario( int matricula ){
            
        ArrayList<Ponto>
                pontos = repositorio.getPontos(),
                resultado = new ArrayList<>();
        
        pontos.stream().filter((p) -> ( p.getFuncionario().getMatricula() == matricula )).forEach((p) -> {
            resultado.add(p);
        });
        
        return resultado;
        
    }
    
    public void marcarPonto( int matricula ){
        
        // TO-DO
        
    }
    
}
