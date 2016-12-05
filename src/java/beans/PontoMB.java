/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.FuncionarioBL;
import business.PontoBL;
import business.RotinaBL;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.Funcionario;
import modelos.Ponto;

/**
 *
 * @author demetrius
 */
@Named(value = "pontos")
@SessionScoped
public class PontoMB implements Serializable {
    
    private int matricula;
    
    @Inject
    FuncionarioBL funcionarioBL;

    @Inject
    RotinaBL rotinaBL;
    
    @Inject
    PontoBL pontoBL;
    
    /**
     * Creates a new instance of PontoMB
     */
    public PontoMB() {}

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public void marcarPonto(){
        
        Funcionario funcionario = funcionarioBL.findOne(matricula);
        
        if( funcionario == null ){
            
            //Mensagem
            
        } else {
            
            FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario encontrado: " + funcionario.getNome(), ""));
            
            /*
            LocalDate hoje = LocalDate.now();
            LocalTime agora = LocalTime.now();
            Rotina rotina = null;
            
            try {
                rotina = rotinaBL.findByFuncionario(funcionario);
            } catch (BusinessException ex) {
                //Mensagem
            }
            
            // 1 Descobrir de qual horário se trata, com base no horário atual e na rotina do funcionário
            
            // 2 Verificar se é possível marcar o ponto, com base em uma tolerência
            
                // 2.1 Se sim, verificar se já existe ponto marcado para este funcionário, nesta data.
                
                    // 2.1.1 Se sim, atualizá-lo com o novo horário no campo apropriado
                    
                    // 2.1.2 Se não, inserí-lo na base, com o horário no campo apropriado
                
                // 2.2 Se não, retornar mensagem de erro
                
            */
            
        }
        
    }
    
    public List<Ponto> marcacoesPorFuncionario( Funcionario f ){
        
        return pontoBL.findByFuncionario(f);
        
    }
    
}
