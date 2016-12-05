/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.DepartamentoBL;
import business.FuncionarioBL;
import business.PontoBL;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.Departamento;
import modelos.Funcionario;
import modelos.Ponto;

/**
 *
 * @author demetrius
 */
@Named(value = "login")
@SessionScoped
public class LoginMB implements Serializable {

    @Inject
    FuncionarioBL funcionarioBL;
    
    @Inject
    DepartamentoBL departamentoBL;
    
    @Inject
    PontoBL pontoBL;

    private Funcionario paraLogin, logado = null;

    /**
     * Creates a new instance of LoginMB
     */
    public LoginMB() {}
    
    @PostConstruct
    public void init(){
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
    
    public void cadastrarUm(){
        
        Departamento dep = departamentoBL.findOne(101L);
        
        Funcionario func1 = new Funcionario();
        func1.setMatricula(765432);
        func1.setAdmin(true);
        func1.setCPF("12345678901");
        func1.setNome("Teste2345");
        func1.setLogin("testeTrabalho");
        func1.setSenha("123456");
        func1.setDepartamento(dep);
        
        funcionarioBL.insert(func1);
        
    }
    
    public void cadastrarPontos(){
        
        Funcionario f = funcionarioBL.findOne(321432);
        
        Ponto p = new Ponto();
        p.setFuncionario(f);
        p.setDataPonto(LocalDate.now().minusDays(3L));
        p.setEntrada(LocalTime.parse("09:00"));
        p.setSaidaIntervalo(LocalTime.parse("12:00"));
        p.setVoltaIntervalo(LocalTime.parse("13:00"));
        p.setSaida(LocalTime.parse("18:00"));
        
        Ponto p2 = new Ponto();
        p2.setFuncionario(f);
        p2.setDataPonto(LocalDate.now().minusDays(4L));
        p2.setEntrada(LocalTime.parse("09:00"));
        p2.setSaidaIntervalo(LocalTime.parse("12:00"));
        p2.setVoltaIntervalo(LocalTime.parse("13:00"));
        p2.setSaida(LocalTime.parse("18:00"));
        
        Ponto p3 = new Ponto();
        p3.setFuncionario(f);
        p3.setDataPonto(LocalDate.now().minusDays(5L));
        p3.setEntrada(LocalTime.parse("09:00"));
        p3.setSaidaIntervalo(LocalTime.parse("12:00"));
        p3.setVoltaIntervalo(LocalTime.parse("13:00"));
        p3.setSaida(LocalTime.parse("18:00"));
        
        pontoBL.insert(p);
        pontoBL.insert(p2);
        pontoBL.insert(p3);
        
    }
    
    public void preencherBanco(){
        
        //List<Departamento> deps = departamentoBL.findAll();
        
        Departamento direcao = new Departamento("Direção Administrativa"),
                     financas = new Departamento("Finanças"),
                     vendas = new Departamento("Vendas");
        
        departamentoBL.insert(direcao);
        departamentoBL.insert(financas);
        departamentoBL.insert(vendas);
        
        Funcionario admin = new Funcionario();
        admin.setMatricula(111111);
        admin.setAdmin(true);
        admin.setCPF("00000000000");
        admin.setNome("Admin");
        admin.setLogin("admin");
        admin.setSenha("admin");
        admin.setDepartamento(direcao);
        
        Funcionario func1 = new Funcionario();
        func1.setMatricula(123456);
        func1.setAdmin(true);
        func1.setCPF("11111111111");
        func1.setNome("Demétrius");
        func1.setLogin("demetrius");
        func1.setSenha("123456");
        func1.setDepartamento(direcao);
        
        Funcionario func2 = new Funcionario();
        func2.setMatricula(321432);
        func2.setAdmin(false);
        func2.setCPF("2222222222");
        func2.setNome("Jeovana");
        func2.setLogin("jeovana");
        func2.setSenha("123456");
        func2.setDepartamento(financas);
        
        Funcionario func3 = new Funcionario();
        func3.setMatricula(938693);
        func3.setAdmin(false);
        func3.setCPF("33333333333");
        func3.setNome("Rodrigo");
        func3.setLogin("rodrigo");
        func3.setSenha("123456");
        func3.setDepartamento(vendas);
        
        Funcionario func4 = new Funcionario();
        func4.setMatricula(198731);
        func4.setAdmin(false);
        func4.setCPF("44444444444");
        func4.setNome("Vinícius");
        func4.setLogin("vivicius");
        func4.setSenha("123456");
        func4.setDepartamento(vendas);
        
        funcionarioBL.insert(admin);
        funcionarioBL.insert(func1);
        funcionarioBL.insert(func2);
        funcionarioBL.insert(func3);
        funcionarioBL.insert(func4);
        
    }

}
