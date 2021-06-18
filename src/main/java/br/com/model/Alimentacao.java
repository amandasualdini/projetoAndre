package br.com.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Alimentacao {

    @Id
    private int _id;
    private float qtd;
    private String valor;
    private String moeda;
    private String total;
    private String formaPagamento;
    private Hospedagem hospedagem;

    public Alimentacao(int _id, float qtd, String valor, String moeda, String total, String formaPagamento, Hospedagem hospedagem) {
        this._id = _id;
        this.qtd = qtd;
        this.valor = valor;
        this.moeda = moeda;
        this.total = total;
        this.formaPagamento = formaPagamento;
        this.hospedagem = hospedagem;
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

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
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

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }



    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
