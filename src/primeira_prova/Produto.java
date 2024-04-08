package primeira_prova;

public class Produto {

    private String nome;
    private int quantidade;
    private double preco;

    public Produto(){

    }
    public Produto(String linha){
        String[] dados = linha.split(",");
        setNome(dados[0]);
        setQuantidade(Integer.parseInt(dados[1]));
        String valorPreco = dados[2].trim().substring(3);
        setPreco(Double.parseDouble(valorPreco.replace(",",".")));
    }
    public boolean validaCompra(int qtd){
        return qtd <= getQuantidade();
    }
    public void realizaCompra(int qtd){
        quantidade -= qtd;
    }
    @Override
    public String toString() {
        return "Produto: " + nome + ", Quantidade= " + quantidade + ", Preço= " + preco;
    }

    //Gets e sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
