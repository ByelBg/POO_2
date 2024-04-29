package banco_de_dados.model;

import java.util.PrimitiveIterator;

public class Cidade {

    private int idcidade;
    private String nome;
    private String uf;

    public Cidade() {
    }
    public Cidade(int idcidade, String nome, String uf) {
        this.idcidade = idcidade;
        this.nome = nome;
        this.uf = uf;
    }
    public String toString(){
        return getIdcidade()+"-"+getNome()+"-"+getUf();
    }

    // Gets e sets
    public int getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(int idcidade) {
        this.idcidade = idcidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
