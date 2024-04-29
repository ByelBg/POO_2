package excecoes;

import javax.swing.*;

public class Dado {
    int numero;
    public void lerNumero(){
        try {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Numero"));
        }catch (Exception e){
            System.out.println("Erro na classe dado");
        }
    }
    public void lerNumero2(){
        try {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Numero"));
        }catch (Exception e){
            throw e;
        }
    }
    public void lerNumero3(){
        try {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Numero"));
        }catch (Exception e){
            System.out.println("Desconectando da AWS");
            throw e;
        }
    }
}
