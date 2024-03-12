package exercicio_operacao_bancaria;

public class ContaEspecial extends ContaBancaria {
    private double limiteSaque;

    public ContaEspecial(){
        super();
        setLimiteSaque(1000);
    }
    public ContaEspecial(int conta, double saldo, double limite){
        super(conta,saldo);
        setLimiteSaque(limite);
    }
    @Override
    public boolean validaSaque(double valor){
        return !((getSaldo() + getLimiteSaque()) < valor) && !(valor <= 0);
    }

    @Override
    public String toString() {
        return "ContaEspecial{ numeroConta= " + getNumeroConta() +", saldo= " + getSaldo() + ", limite= " + limiteSaque +"}";
    }

    //Gets e Sets
    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
}
