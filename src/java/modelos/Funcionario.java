/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Objects;

/**
 *
 * @author demetrius
 */
public class Funcionario {
    
    private int matricula;
    private Departamento departamento;
    private String CPF, nome, login, senha;
    private boolean admin;

    public Funcionario() {
    }

    public Funcionario(Departamento departamento, String CPF, String nome, String login, String senha, boolean admin) {
        this.departamento = departamento;
        this.CPF = CPF;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public Funcionario(int matricula, Departamento departamento, String CPF, String nome, String login, String senha, boolean admin) {
        this(departamento, CPF, nome, login, senha, admin);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean isAdmin() {
        return admin;
    }
    
    public String getAdminIcon(){
        return admin ? "<i class=\"yellow bookmark icon\"></i>" : "<i class=\"grey remove icon\"></i>";
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
