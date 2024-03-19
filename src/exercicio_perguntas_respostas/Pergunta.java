package exercicio_perguntas_respostas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Pergunta {
    private String titulo;
    private String resposta;

    public Pergunta(String t, String r){
        setResposta(r);
        setTitulo(t);
    }

    @Override
    public String toString() {
        return titulo + ", " + resposta;
    }

    //Gets e Sets
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
