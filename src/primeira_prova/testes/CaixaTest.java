package primeira_prova.testes;

import org.junit.jupiter.api.Test;
import primeira_prova.Caixa;
import primeira_prova.Compra;
import primeira_prova.Produto;

import static org.junit.jupiter.api.Assertions.*;

class CaixaTest {

    Caixa caixa = new Caixa();

    @Test
    void carregaArquivoTest() {
        caixa.lerCompras();
        caixa.lerProdutos();
        Produto sexto = caixa.getProdutos().get(5);
        Compra segunda = caixa.getCompras().get(1);
        assertEquals(10, caixa.getCompras().size());
        assertEquals(50, caixa.getProdutos().size());
        assertEquals("Ovos", sexto.getNome());
        assertEquals(9.0, sexto.getPreco());
        assertEquals("Banana", segunda.getProduto());
        assertEquals(3, segunda.getQtdCompra());
    }

    @Test
    void realizaComprasTest() {
        caixa.lerCompras();
        caixa.lerProdutos();
        caixa.lerRealizadas();
        caixa.realizaCompras(caixa.getCompras(), caixa.getProdutos());
        Produto leite = caixa.getProdutos().get(46);
        Produto maca = caixa.getProdutos().get(13);
        String terceira = caixa.getRealizadas().get(2);
        assertEquals("Laranja,4,3.0,12.0", terceira);
        assertEquals(0, leite.getQuantidade());
        assertEquals(5, maca.getQuantidade());
    }

    @Test
    void comprasControladasTest() {
        Produto p1 = new Produto("A,5,R$ 4,00");
        Produto p2 = new Produto("B,0,R$ 5,50");
        assertTrue(p1.validaCompra(2));
        assertFalse(p2.validaCompra(1));
        assertEquals(5,p1.getQuantidade());
        p1.realizaCompra(2);
        assertEquals(3,p1.getQuantidade());
        assertEquals(4.0,p1.getPreco());
        assertEquals(5.5,p1.getPreco());
    }

    @Test
    void toStringsTest(){
        Produto p1 = new Produto("A,5,R$ 4,00");
        Compra c1 = new Compra("A,5");
        assertEquals("Produto: A, Quantidade= 5, Preço= 4.0",p1.toString());
        assertEquals("Produto= A, Quantidade Comprada= 5",c1.toString());
    }
}