/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import modelos.Departamento;
import modelos.Funcionario;
import modelos.Ponto;
import modelos.Rotina;

/**
 *
 * @author demetrius
 */
@Named(value = "repositorio")
@ApplicationScoped
public class RepositorioMB {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Departamento> departamentos;
    private ArrayList<Rotina> rotinas;
    private ArrayList<Ponto> pontos;

    /**
     * Inicializa os repositórios (ArrayLists '-.-) com dados pré-prontos
     */
    public RepositorioMB() {

        // Inicializar Departamentos
        departamentos = new ArrayList<>();

        departamentos.add(new Departamento(0, "Direção Administrativa"));
        departamentos.add(new Departamento(1, "RH"));
        departamentos.add(new Departamento(2, "Finanças"));
        departamentos.add(new Departamento(3, "Linha de Montagem"));
        departamentos.add(new Departamento(4, "Vendas"));

        // Inicializar Funcionários
        funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(0, departamentos.get(0), "00000000000", "Admin", "admin", "admin", true));
        funcionarios.add(new Funcionario(1, departamentos.get(1), "00000000001", "Excalibur", "a", "123456", false));
        funcionarios.add(new Funcionario(2, departamentos.get(2), "00000000002", "Valkyr", "b", "123456", false));
        funcionarios.add(new Funcionario(3, departamentos.get(3), "00000000003", "Zephyr", "c", "123456", false));
        funcionarios.add(new Funcionario(4, departamentos.get(3), "00000000004", "Nyx", "d", "123456", false));
        funcionarios.add(new Funcionario(5, departamentos.get(4), "00000000005", "Mag", "e", "123456", false));

        // Inicializar Rotinas
        rotinas = new ArrayList<>();

        LocalDate inicio = LocalDate.parse("2016-09-20");
        LocalTime e = LocalTime.parse("09:00"),
                si = LocalTime.parse("12:00"),
                vi = LocalTime.parse("13:00"),
                s = LocalTime.parse("18:00");

        rotinas.add(new Rotina(0, funcionarios.get(0), inicio, null, true, e, si, vi, s));
        rotinas.add(new Rotina(1, funcionarios.get(1), inicio, null, true, e, si, vi, s));
        rotinas.add(new Rotina(2, funcionarios.get(2), inicio, null, true, e, si, vi, s));
        rotinas.add(new Rotina(3, funcionarios.get(3), inicio, null, true, e, si, vi, s));
        rotinas.add(new Rotina(4, funcionarios.get(4), inicio, null, true, e, si, vi, s));
        rotinas.add(new Rotina(5, funcionarios.get(5), inicio, null, true, e, si, vi, s));

        // Inicializar Pontos
        pontos = new ArrayList<>();

        LocalDate hoje = LocalDate.now();

        pontos.add(new Ponto(0, funcionarios.get(0), hoje, e, si, vi, si));
        pontos.add(new Ponto(1, funcionarios.get(1), LocalDate.parse("2016-09-20"), e.minusMinutes(30), si, vi, si.minusMinutes(30)));
        pontos.add(new Ponto(1, funcionarios.get(1), LocalDate.parse("2016-09-21"), e, si, vi, null));
        pontos.add(new Ponto(2, funcionarios.get(2), hoje, e, si, vi, si));
        pontos.add(new Ponto(3, funcionarios.get(3), hoje, e, si, vi, si));
        pontos.add(new Ponto(4, funcionarios.get(4), hoje, e, si, vi, si));
        pontos.add(new Ponto(5, funcionarios.get(5), hoje, e, si, vi, si));

    }

    //--------------------------------
    //        Departamentos
    //--------------------------------
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }            
    
    
    //--------------------------------
    //        Funcionários
    //--------------------------------

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    
    //--------------------------------
    //            Pontos
    //--------------------------------

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }
    

}
