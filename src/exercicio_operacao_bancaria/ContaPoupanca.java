package exercicio_operacao_bancaria;

public class ContaPoupanca extends ContaBancaria {
    private int qtSaques;
    public ContaPoupanca(){
        super();
        setQtSaques(0);
    }
    public ContaPoupanca(int numConta, double saldoInicial){
        super(numConta, saldoInicial);
        setQtSaques(0);
    }
    @Override
    public boolean validaSaque(double valor) {
        if (getSaldo() < valor || valor <= 0) {
            return false;
        } else return qtSaques < 5;
    }
    @Override
    public void saque(double valor){
        if(validaSaque(valor)){
            setSaldo(getSaldo()-valor);
            qtSaques++;
        }
    }

    @Override
    public String toString() {
        return "ContaPoupanca{ numeroConta= " + getNumeroConta() +", saldo= " + getSaldo() + "}";
    }

    //Gets e Sets
    public int getQtSaques() {
        return qtSaques;
    }

    public void setQtSaques(int qtSaques) {
        this.qtSaques = qtSaques;
    }
}
