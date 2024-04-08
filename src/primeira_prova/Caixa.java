package primeira_prova;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Caixa {

    private ArrayList<Produto> produtos;
    private ArrayList<Compra> compras;
    private ArrayList<String> realizadas;
    public Caixa(){
        compras = new ArrayList<>();
        produtos = new ArrayList<>();
        realizadas = new ArrayList<>();
    }

    public void lerProdutos(){
        try {
            FileReader fr = new FileReader("lista_produtos.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                produtos.add(new Produto(linha));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lerCompras(){
        try {
            FileReader fr = new FileReader("lista_compras.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                compras.add(new Compra(linha));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void realizaCompras(ArrayList<Compra> compras, ArrayList<Produto> produtos){
        try {
            FileWriter fw = new FileWriter("compra.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(Compra c : compras){
                for(Produto p : produtos){
                    if(c.getProduto().equals(p.getNome())){
                        if (p.validaCompra(c.getQtdCompra())){
                            p.realizaCompra(c.getQtdCompra());
                            bw.append(c.getProduto()+","+c.getQtdCompra()+","+p.getPreco()+","+(c.getQtdCompra()*p.getPreco())+"\n");
                        }
                    }
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lerRealizadas(){
        try {
            FileReader fr = new FileReader("compra.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                realizadas.add(linha);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Gets e Sets

    public ArrayList<String> getRealizadas() {
        return realizadas;
    }

    public void setRealizadas(ArrayList<String> realizadas) {
        this.realizadas = realizadas;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
}
