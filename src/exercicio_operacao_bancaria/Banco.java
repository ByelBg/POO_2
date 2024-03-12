package exercicio_operacao_bancaria;

import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas;

    //Gets e Sets
    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }
}
