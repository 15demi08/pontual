/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.CascadeType;
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

    private LocalDate data;
    private LocalTime entrada, saidaIntervalo, voltaIntervalo, saida;

    // Auxiliar
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");

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

    public Ponto(Long id, Funcionario funcionario, LocalDate data, LocalTime entrada, LocalTime saidaIntervalo, LocalTime voltaIntervalo, LocalTime saida) {
        this(funcionario, data, entrada, saidaIntervalo, voltaIntervalo, saida);
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

    public LocalDate getData() {
        return data;
    }

    // Retorna a data convertida para o formato brasileiro
    public String getDataString() {
        return formatoData.format(data);
    }

    public void setData(LocalDate data) {
        this.data = data;
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
}
