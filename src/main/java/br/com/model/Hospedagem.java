package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Hospedagem {

    @Id
    private int _id;
    private float qtd;
    private String valor;
    private String moeda;
    private String total;
    private String formaPagamento;
    private Estado estado;


    public Hospedagem() {
    }

    public Hospedagem(int _id, float qtd, String valor, String moeda, String total, String formaPagamento, Estado estado) {
        this._id = _id;
        this.qtd = qtd;
        this.valor = valor;
        this.moeda = moeda;
        this.total = total;
        this.formaPagamento = formaPagamento;
        this.estado = estado;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public float getQtd() {
        return qtd;
    }

    public void setQtd(float qtd) {
        this.qtd = qtd;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


}
