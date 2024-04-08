package primeira_prova;

public class Compra {

    private String produto;
    private int qtdCompra;

    public Compra(){
    }

    public Compra(String linha){
        String[] dados = linha.split(",");
        setProduto(dados[0]);
        setQtdCompra(Integer.parseInt(dados[1]));
    }
    @Override
    public String toString() {
        return "Produto= " + produto +", Quantidade Comprada= " + qtdCompra;
    }

    //Gets e Sets
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtdCompra() {
        return qtdCompra;
    }

    public void setQtdCompra(int qtdCompra) {
        this.qtdCompra = qtdCompra;
    }
}
