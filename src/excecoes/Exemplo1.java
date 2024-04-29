package excecoes;

import org.w3c.dom.ls.LSOutput;

import javax.print.attribute.standard.JobPriority;
import javax.swing.*;
import java.sql.SQLOutput;

public class Exemplo1 {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Insira numero"));
            if (n%2 != 0){
                throw new Exception("Apenas números pares");
            }
            int vetor[] = new int[n];
            for (int i = 0; i < n; i++) {
                vetor[i] = i * i;
            }
            int indice = Integer.parseInt(JOptionPane.showInputDialog("Indice"));
            System.out.println(vetor[indice]);
        }catch (NumberFormatException e) {
            System.out.println("Número inválido");
        }catch (NegativeArraySizeException e) {
            System.out.println("Tamanho do Array não pode ser negativo");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Índice inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Adeus");
    }
}