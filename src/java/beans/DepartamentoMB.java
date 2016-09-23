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

    private Departamento deptoParaCadastro, deptoSelecionado;

    private int nextId = 6;

    @Inject
    RepositorioMB repositorio;

    /**
     * Creates a new instance of DepartamentoMB
     */
    public DepartamentoMB() {

        deptoParaCadastro = new Departamento();
        deptoSelecionado = new Departamento();

    }

    public Departamento getDeptoParaCadastro() {
        return deptoParaCadastro;
    }

    public void setDeptoParaCadastro(Departamento deptoParaCadastro) {
        this.deptoParaCadastro = deptoParaCadastro;
    }

    public Departamento getDeptoSelecionado() {
        return deptoSelecionado;
    }

    public void setDeptoSelecionado(Departamento deptoSelecionado) {
        this.deptoSelecionado = deptoSelecionado;
    }

    private boolean incluir() {

        Departamento d = deptoParaCadastro;

        deptoParaCadastro = new Departamento();

        d.setId(nextId++);

        return repositorio.getDepartamentos().add(d);
    }

    public Departamento obter(int id) {

        for (Departamento d : repositorio.getDepartamentos()) {
            if (d.getId() == id) {
                return d;
            }
        }

        return null;

    }

    private boolean remover() {

        Departamento d = deptoSelecionado;

        deptoSelecionado = new Departamento();

        return repositorio.getDepartamentos().remove(d);

    }

    public String atualizar() {

        Departamento departamento = obter(deptoSelecionado.getId());

        departamento = deptoSelecionado;

        deptoSelecionado = new Departamento();

        String msg = "<i class=\"warning icon\"></i>Departamento atualizado com sucesso! <i class=\"close icon\"></i>";

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));

        return "departamentos";

    }

    public ArrayList<Departamento> obterTodos() {

        return repositorio.getDepartamentos();

    }

    public ArrayList<Departamento> filtrarPorNome(String nome) {

        ArrayList<Departamento> departamentos = repositorio.getDepartamentos(),
                resultado = new ArrayList<>();

        departamentos.stream().filter((d) -> (d.getNome().contains(nome))).forEach((d) -> {
            resultado.add(d);
        });

        return resultado;

    }

    public String cadastrar() {

        String msg;

        if (!incluir()) {

            msg = "<i class=\"small warning icon\"></i>Erro ao cadastrar departamento! <i class=\"close icon\"></i>";

            FacesContext
                    .getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));

            return "novoDepartamento";

        }

        msg = "<i class=\"small warning icon\"></i>Departamento cadastrado com sucesso! <i class=\"close icon\"></i>";

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));

        return "departamentos";

    }

    public String editarDepartamento(Departamento d) {

        deptoSelecionado = d;

        return "editarDepartamento";

    }

}
