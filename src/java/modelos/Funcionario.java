/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author demetrius
 */
@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricula;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Departamento departamento;

    private String CPF, nome, login, senha;
    private boolean administrador;

    public Funcionario() {
    }

    public Funcionario(Departamento departamento, String CPF, String nome, String login, String senha, boolean admin) {
        this.departamento = departamento;
        this.CPF = CPF;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.administrador = admin;
    }

    public Funcionario(Long matricula, Departamento departamento, String CPF, String nome, String login, String senha, boolean admin) {
        this(departamento, CPF, nome, login, senha, admin);
        this.matricula = matricula;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
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
        return administrador;
    }

    public String getAdminIcon() {
        return administrador ? "<i class=\"yellow bookmark icon\"></i>" : "<i class=\"grey remove icon\"></i>";
    }

    public void setAdmin(boolean admin) {
        this.administrador = admin;
    }

}
