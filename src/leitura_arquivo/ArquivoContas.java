package leitura_arquivo;

import exercicio_operacao_bancaria.ContaBancaria;
import exercicio_operacao_bancaria.ContaEspecial;
import exercicio_operacao_bancaria.ContaPoupanca;

import javax.swing.text.DefaultEditorKit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ArquivoContas {

    public static void main(String[] args) {
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        try {
            // Usa pra encontrarum arquivo, como esse contas.txt ta dentro da pasta do projeto, só precisa colocar o nome
            // Se estivesse fora da pasta do projeto, precisaria colocar o caminho pro arquivo
            FileReader fr = new FileReader("contas.txt");
            // Usa pra ler um arquivo
            BufferedReader br = new BufferedReader(fr);
            // Normalmente se declara o fr dentro do br, mas os dois sempre andam juntos

            String linha = "";

            // Repetição que vai ler o arquivo enquanto ainda estiver linhas com conteúdo pra ler
            while ((linha = br.readLine()) !=null){
                String v[] = linha.split(",");
                int nr = Integer.parseInt(v[1]);
                double saldo = Double.parseDouble(v[2]);
                if(v[0].equals("0")){
                    contas.add(new ContaBancaria(nr, saldo));
                }if(v[0].equals("1")){
                    contas.add(new ContaPoupanca(nr, saldo));
                }if(v[0].equals("2")){
                    double limite = Double.parseDouble(v[3]);
                    contas.add(new ContaEspecial(nr, saldo, limite));
                }
            }
            // Aqui ele só leu o arquivo e criou contas com as informações que tinha nele

            // Aqui ele fecha o arquivo
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Só um SysOut pra conferir que criou certinho
        for(ContaBancaria c : contas){
            System.out.println(c);
        }
    }
}
