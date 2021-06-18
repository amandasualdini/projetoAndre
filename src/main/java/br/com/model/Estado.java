package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estado {

    @Id
    private int _id;
    private  String nome;

    public Estado(int _id, String nome) {
        this._id = _id;
        this.nome = nome;
    }

    public Estado(){

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}