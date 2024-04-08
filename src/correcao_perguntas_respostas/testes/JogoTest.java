package correcao_perguntas_respostas.testes;

import correcao_perguntas_respostas.Jogo;
import correcao_perguntas_respostas.Pergunta;
import correcao_perguntas_respostas.Resposta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class JogoTest {
    private Jogo jogo = new Jogo();

    @Test
    void carregaArquivoTest(){
        jogo.lerArquivo();
        assertEquals(50, jogo.getPerguntas().size());
        Pergunta quarta = jogo.getPerguntas().get(3);
        assertEquals("A Lua tem sua própria luz",quarta.getTitulo());
        assertFalse(quarta.isRespostaCorreta());
    }
    @Test
    void fazCorrecaoAcertoTest(){
        Pergunta pergunta = new Pergunta("ABCD É EFGH,F");
        Resposta r = new Resposta(pergunta, false);
        assertEquals("acerto", r.correcao());
    }
    @Test
    void fazCorrecaoErroTest(){
        Pergunta pergunta = new Pergunta("ABCD É EFGH,F");
        Resposta r = new Resposta(pergunta, true);
        assertEquals("erro", r.correcao());
    }
    @Test
    void calculaPontuacaoTest(){
        assertEquals(2, jogo.calculaPontuacao(respostasControladas()));
    }
    @Test
    void gravarRespostasTest(){
        ArrayList<Resposta> respostas = respostasControladas();
        jogo.gravaResultado(respostas);
        String conteudoArq = jogo.lerRespostas();
        assertEquals("1,A,acerto\n" +
                "2,B,acerto\n" +
                "3,C,erro\n" +
                "4,D,erro\n",conteudoArq);
    }
    private ArrayList<Resposta> respostasControladas(){
        ArrayList<Resposta> respostas = new ArrayList<>();
        Pergunta pa = new Pergunta("A", false);
        Pergunta pb = new Pergunta("B", false);
        Pergunta pc = new Pergunta("C", true);
        Pergunta pd = new Pergunta("D", true);
        respostas.add(new Resposta(pa, false));
        respostas.add(new Resposta(pb, false));
        respostas.add(new Resposta(pc, false));
        respostas.add(new Resposta(pd, false));
        return respostas;
    }
}