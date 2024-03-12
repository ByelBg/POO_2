package exercicio_operacao_bancaria;

public class ContaBancaria {
    private int numeroConta;
    private double saldo;

    public ContaBancaria(){
        setNumeroConta(0);
        setSaldo(-1);
    }
    public ContaBancaria(int numero, double sd){
        setNumeroConta(numero);
        setSaldo(sd);
    }
    public void deposito(double valor){
        setSaldo(getSaldo()+valor);
    }
    public boolean validaSaque(double valor){
        return !(getSaldo() < valor) && !(valor <= 0);
    }
    public void saque (double valor){
        if(validaSaque(valor)){
            setSaldo(getSaldo()-valor);
        }
    }
    public void transferencia(ContaBancaria contaDestino, double valor){
        if (validaSaque(valor)) {
            contaDestino.deposito(valor);
            saque(valor);
        }
    }

    @Override
    public String toString() {
        return "ContaBancaria{ numeroConta= " + numeroConta +", saldo= " + saldo + "}";
    }

    //Gets e sets
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}