/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.FuncionarioBL;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.Departamento;
import modelos.Funcionario;

/**
 *
 * @author demetrius
 */
@Named(value = "login")
@SessionScoped
public class LoginMB implements Serializable {

    @Inject
    FuncionarioBL funcionarioBL;

    private Funcionario paraLogin, logado = null;

    /**
     * Creates a new instance of LoginMB
     */
    public LoginMB() {

        paraLogin = new Funcionario();

    }

    public Funcionario getParaLogin() {
        return paraLogin;
    }

    public void setParaLogin(Funcionario paraLogin) {
        this.paraLogin = paraLogin;
    }

    public Funcionario getLogado() {
        return logado;
    }

    public void setLogado(Funcionario logado) {
        this.logado = logado;
    }

    public String realizarLogin() {

        for (Funcionario funcionario : funcionarioBL.findAll()) {

            if (funcionario.getLogin().equals(paraLogin.getLogin())
                    && funcionario.getSenha().equals(paraLogin.getSenha())) {

                logado = funcionario;
                
                paraLogin = null;

                if (logado.isAdmin()) {
                    return "admin/index";
                } else {
                    return "usuario/index";
                }

            }

        }

        FacesContext
            .getCurrentInstance()
            .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados inválidos.", ""));
        
        paraLogin = new Funcionario();

        return "login";
        
    }
    
    public String realizarLogout(){
        
        logado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
        
    }

}
