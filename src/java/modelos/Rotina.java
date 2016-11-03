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
public class Rotina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Funcionario funcionario;
    
    private LocalDate dataInicio, dataFim;
    private boolean temIntervalo;
    private LocalTime entrada, saidaIntervalo, voltaIntervalo, saida;

    public Rotina() {
    }

    public Rotina(Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim, boolean temIntervalo, LocalTime entrada, LocalTime saidaIntervalo, LocalTime voltaIntervalo, LocalTime saida) {
        this.funcionario = funcionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.temIntervalo = temIntervalo;
        this.entrada = entrada;
        this.saidaIntervalo = saidaIntervalo;
        this.voltaIntervalo = voltaIntervalo;
        this.saida = saida;
    }

    public Rotina(Long id, Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim, boolean temIntervalo, LocalTime entrada, LocalTime saidaIntervalo, LocalTime voltaIntervalo, LocalTime saida) {
        this(funcionario, dataInicio, dataFim, temIntervalo, entrada, saidaIntervalo, voltaIntervalo, saida);
        this.id = id;
    }

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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isTemIntervalo() {
        return temIntervalo;
    }

    public void setTemIntervalo(boolean temIntervalo) {
        this.temIntervalo = temIntervalo;
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
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.funcionario);
        hash = 73 * hash + Objects.hashCode(this.dataInicio);
        hash = 73 * hash + Objects.hashCode(this.dataFim);
        hash = 73 * hash + (this.temIntervalo ? 1 : 0);
        hash = 73 * hash + Objects.hashCode(this.entrada);
        hash = 73 * hash + Objects.hashCode(this.saidaIntervalo);
        hash = 73 * hash + Objects.hashCode(this.voltaIntervalo);
        hash = 73 * hash + Objects.hashCode(this.saida);
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
        final Rotina other = (Rotina) obj;
        if (this.temIntervalo != other.temIntervalo) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataFim, other.dataFim)) {
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
