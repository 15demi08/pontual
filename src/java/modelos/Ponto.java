/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author demetrius
 */
public class Ponto {

    private int id;
    private Funcionario funcionario;
    private LocalDate data;
    private LocalTime entrada, saidaIntervalo, voltaIntervalo, saida;

    public Ponto() {
    }

    public Ponto(Funcionario funcionario, LocalDate data, LocalTime entrada, LocalTime saidaIntervalo, LocalTime voltaIntervalo, LocalTime saida) {
        this.funcionario = funcionario;
        this.data = data;
        this.entrada = entrada;
        this.saidaIntervalo = saidaIntervalo;
        this.voltaIntervalo = voltaIntervalo;
        this.saida = saida;
    }

    public Ponto(int id, Funcionario funcionario, LocalDate data, LocalTime entrada, LocalTime saidaIntervalo, LocalTime voltaIntervalo, LocalTime saida) {
        this(funcionario, data, entrada, saidaIntervalo, voltaIntervalo, saida);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaidaIntervalo() {
        return saidaIntervalo;
    }

    public void setSaidaIntervalo(LocalTime saidaIntervalo) {
        this.saidaIntervalo = saidaIntervalo;
    }

    public LocalTime getVoltaIntervalo() {
        return voltaIntervalo;
    }

    public void setVoltaIntervalo(LocalTime voltaIntervalo) {
        this.voltaIntervalo = voltaIntervalo;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.funcionario);
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.entrada);
        hash = 97 * hash + Objects.hashCode(this.saidaIntervalo);
        hash = 97 * hash + Objects.hashCode(this.voltaIntervalo);
        hash = 97 * hash + Objects.hashCode(this.saida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ponto other = (Ponto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.entrada, other.entrada)) {
            return false;
        }
        if (!Objects.equals(this.saidaIntervalo, other.saidaIntervalo)) {
            return false;
        }
        if (!Objects.equals(this.voltaIntervalo, other.voltaIntervalo)) {
            return false;
        }
        return Objects.equals(this.saida, other.saida);
    }

}
