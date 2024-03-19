package exercicio_perguntas_respostas;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Arquivo {
    public static void main(String[] args) {
        String menu = "1 - Rodada de Perguntas\n" +
                "2 - Score total\n\n" +
                "3- Sair";
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        ArrayList<String> resultados = new ArrayList<>();
        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            if (op == 1) {
                gerarPerguntas(perguntas);
                resultados.add(rodadaPerguntas(perguntas));
            }
            if (op == 2) {
                int contador = 1;
                String result = "Score total:\n\n";
                for (String s : resultados) {
                    result += contador + "- " + s + "\n";
                    contador++;
                }
                JOptionPane.showMessageDialog(null, result);
            }
        } while (op != 3);
    }

    public static void gerarPerguntas(ArrayList<Pergunta> perguntas) {
        try {
            Random r = new Random();
            int[] numeros = new int[10];
            String linha = "";
            FileReader fr = new FileReader("perguntas.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 10; i++) {
                numeros[i] = r.nextInt(50);
            }
            if (perguntas.size() > 2) {
                while ((linha = br.readLine()) != null) {
                    String[] p = null;
                    p = linha.split(",");

                    for (int j = 0; j < 10; j++) {
                        if (Integer.parseInt(p[0]) == numeros[j]) {
                            Pergunta pergunta = new Pergunta(p[1], p[2]);
                            perguntas.set(j, pergunta);
                        }
                    }
                }
            }else{
                while ((linha = br.readLine()) != null) {
                    String[] p = null;
                    p = linha.split(",");
                    for (int j = 0; j < 10; j++) {
                        if (Integer.parseInt(p[0]) == numeros[j]) {
                            Pergunta pergunta = new Pergunta(p[1], p[2]);
                            perguntas.add(pergunta);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String rodadaPerguntas(ArrayList<Pergunta> perguntas) {
        int acertos = 0;
        int contador = 1;
        for (Pergunta p : perguntas) {
            String resposta = JOptionPane.showInputDialog(contador + "- " + p.getTitulo() + " (F/V)").toUpperCase();
            if (resposta.equals(p.getResposta())) {
                acertos++;
                System.out.println("Certa resposta!");
            } else {
                System.out.println("Resposta errada!");
            }
            contador++;
        }
        return acertos + "/10";
    }
}
