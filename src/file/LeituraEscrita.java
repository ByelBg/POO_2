package file;

import javax.swing.*;
import java.io.*;
import java.util.Random;

public class LeituraEscrita {
    public static void main(String[] args) {
        String menu = "1 - Escrever\n" +
                "2 - ler\n\n" +
                "3- Sair";
        int op = 0;
        do{op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            if(op==1) escreve();
            if(op==2) leitura();
        }while (op!=3);
    }

    private static void escreve(){
        try{
            //Ao colocar um true após o nome do arquivo, ele não apaga e cria um novo, ele só adiciona os números por cima
            FileWriter fw = new FileWriter("sorteio.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for( int i=0; i<10; i++){
                Random r = new Random();
                bw.append(r.nextInt(1000)+"\n");
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void leitura(){
        try{
            FileReader fr = new FileReader("sorteio.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) !=null){
                System.out.println(linha);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
