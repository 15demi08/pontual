/**
 * Pontual - Controle de Ponto Eletrônico
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.Funcionario;

/**
 *
 * @author demetrius
 */
@Named(value = "login")
@SessionScoped
public class LoginMB implements Serializable {
    
    @Inject
    RepositorioMB repositorioMB;
    
    private Funcionario funcionarioLogado;
    private String login, senha;

    /**
     * Creates a new instance of LoginMB
     */
    public LoginMB() {
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }
    
    public String realizaLogin(){
        
        ArrayList<Funcionario> repo = repositorioMB.getFuncionarios();
        
        for (Funcionario funcionario : repo) {
            
            if( funcionario.getLogin().equals(login) &&
                funcionario.getSenha().equals(senha)){
                
                funcionarioLogado = funcionario;
                
                if( funcionarioLogado.isAdmin() )
                    return "/admin/index?faces-redirect=true";
                else
                    return "/usuario/index?faces-redirect=true";
                
            }
            
        }
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "<i class=\"small warning icon\"></i>Login ou senha incorretos! <i class=\"close icon\"></i>", "");
        contexto.addMessage(null, mensagem);
        
        return "login";
        
    }
    
    public String realizaLogout() {
        funcionarioLogado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ("/login?faces-redirect=true");
    }
    
}
