/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author demetrius
 */
@Entity
public class Ponto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Funcionario funcionario;

    private LocalDate dataPonto;
    private LocalTime entrada, saidaIntervalo, voltaIntervalo, saida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataPonto() {
        return dataPonto;
    }

    public void setDataPonto(LocalDate dataPonto) {
        this.dataPonto = dataPonto;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public String getEntradaString() {
        return entrada == null ? "---" : entrada.toString();
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaidaIntervalo() {
        return saidaIntervalo;
    }

    public String getSaidaIntervaloString() {
        return saidaIntervalo == null ? "---" : saidaIntervalo.toString();
    }

    public void setSaidaIntervalo(LocalTime saidaIntervalo) {
        this.saidaIntervalo = saidaIntervalo;
    }

    public LocalTime getVoltaIntervalo() {
        return voltaIntervalo;
    }

    public String getVoltaIntervaloString() {
        return voltaIntervalo == null ? "---" : voltaIntervalo.toString();
    }

    public void setVoltaIntervalo(LocalTime voltaIntervalo) {
        this.voltaIntervalo = voltaIntervalo;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public String getSaidaString() {
        return saida == null ? "---" : saida.toString();
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.funcionario);
        hash = 83 * hash + Objects.hashCode(this.dataPonto);
        hash = 83 * hash + Objects.hashCode(this.entrada);
        hash = 83 * hash + Objects.hashCode(this.saidaIntervalo);
        hash = 83 * hash + Objects.hashCode(this.voltaIntervalo);
        hash = 83 * hash + Objects.hashCode(this.saida);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.dataPonto, other.dataPonto)) {
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
