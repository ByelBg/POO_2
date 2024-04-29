package banco_de_dados.testes;

import banco_de_dados.CidadeService;
import banco_de_dados.ClienteService;
import banco_de_dados.Conexao;
import banco_de_dados.model.Cidade;
import banco_de_dados.model.Cliente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.ConvertWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConexaoTest {

    @BeforeAll
    static void inicializa(){
        CidadeService.limpaTblCidade();
        ClienteService.limpaTblCliente();
    }

    @Test
    void conexaoTest() {
        assertNotNull(Conexao.concectaMySql());
    }

    @Test
    void insereCidadeTest(){
        Cidade c = new Cidade(0,"Araranguá","SC");
        assertEquals(1, CidadeService.insereCidade(c));
    }

    @Test
    void alteraCidadeExistenteTest(){
        Cidade c = new Cidade(1, "Goiânia","GO");
        assertEquals(1, CidadeService.alteraCidade(c));
    }

    @Test
    void alteraCidadeInexistenteTest(){
        Cidade c = new Cidade(25, "Goiânia","GO");
        assertEquals(0, CidadeService.alteraCidade(c));
    }

    @Test
    void excluiCidadeExistenteTest(){
        Cidade c = new Cidade(1,"","");
        assertEquals(1,CidadeService.excluiCidade(c));
    }

    @Test
    void excluiCidadeInexistenteTest(){
        Cidade c = new Cidade(25,"","");
        assertEquals(0,CidadeService.excluiCidade(c));
    }

    @Test
    void listaCidadeTest(){
        ArrayList<Cidade> lista = CidadeService.listAll();
        for (Cidade c : lista){
            System.out.println(c);
        }
    }

    @Test
    void insereClienteTest(){
        Cliente c = new Cliente(0,"A",11,"M", new Cidade(2,"Orleans","SC"));
        assertEquals(1, ClienteService.insereCliente(c));
    }
}