package exercicio_operacao_bancaria.testes;

import exercicio_operacao_bancaria.ContaBancaria;
import exercicio_operacao_bancaria.ContaEspecial;
import exercicio_operacao_bancaria.ContaPoupanca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    ContaBancaria c1;
    ContaBancaria c2;
    ContaEspecial e1;
    ContaEspecial e2;
    ContaPoupanca p1;
    ContaPoupanca p2;
    @BeforeEach
    public void iniciaContas(){
        c1 = new ContaBancaria();
        c2 = new ContaBancaria(1,100);
        e1 = new ContaEspecial();
        e2 = new ContaEspecial(1,100,2000);
        p1 = new ContaPoupanca();
        p2 = new ContaPoupanca(1,100);
    }

//    @Test
//    public void construtorVazioTest(){
//        assertEquals(0,c1.getNumeroConta());
//        assertEquals(-1,c1.getSaldo());
//        assertEquals("ContaBancaria{ numeroConta= 0, saldo= -1.0}",c1.toString());
//        assertEquals(0,e1.getNumeroConta());
//        assertEquals(-1,e1.getSaldo());
//        assertEquals(1000,e1.getLimiteSaque());
//        assertEquals("ContaEspecial{ numeroConta= 0, saldo= -1.0, limite= 1000.0}",e1.toString());
//        assertEquals(0,p1.getNumeroConta());
//        assertEquals(-1,p1.getSaldo());
//        assertEquals("ContaPoupanca{ numeroConta= 0, saldo= -1.0}",p1.toString());
//        assertEquals(0,p1.getQtSaques());
//    }
//
//    @Test
//    public void construtorValoresTest() {
//        c2 = new ContaBancaria(1, 100);
//        e2 = new ContaEspecial(2, 200, 2000);
//        p2 = new ContaPoupanca(3, 300);
//        assertEquals(1, c2.getNumeroConta());
//        assertEquals(100, c2.getSaldo());
//        assertEquals("ContaBancaria{ numeroConta= 1, saldo= 100.0}", c2.toString());
//        assertEquals(2, e2.getNumeroConta());
//        assertEquals(200, e2.getSaldo());
//        assertEquals(2000, e2.getLimiteSaque());
//        assertEquals("ContaEspecial{ numeroConta= 2, saldo= 200.0, limite= 2000.0}", e2.toString());
//        assertEquals(3, p2.getNumeroConta());
//        assertEquals(300, p2.getSaldo());
//        assertEquals("ContaPoupanca{ numeroConta= 3, saldo= 300.0}", p2.toString());
//        assertEquals(0, p2.getQtSaques());
//    }
//    @Test
//    public void saquesErroTest(){
//        c2 = new ContaBancaria(1,1000);
//        e2 = new ContaEspecial(2,2000,100);
//        p2 = new ContaPoupanca(3,3000);
//        //Comum
//        assertFalse(c2.validaSaque(1500));
//        assertFalse(c2.validaSaque(-1));
//        c2.saque(1500);
//        assertEquals(1000,c2.getSaldo());
//        c2.saque(-1);
//        assertEquals(1000,c2.getSaldo());
//        //Especial
//        assertFalse(e2.validaSaque(2200));
//        assertFalse(e2.validaSaque(-1));
//        e2.saque(2200);
//        assertEquals(2000,e2.getSaldo());
//        e2.saque(-1);
//        assertEquals(2000,e2.getSaldo());
//        //Poupança
//        assertFalse(p2.validaSaque(3100));
//        assertFalse(p2.validaSaque(-1));
//        p2.setQtSaques(5);
//        assertFalse(p2.validaSaque(100));
//        assertFalse(p2.validaSaque(-1));
//        p2.setQtSaques(0);
//        p2.saque(3300);
//        assertEquals(3000,p2.getSaldo());
//        p2.saque(-1);
//        assertEquals(3000,p2.getSaldo());
//        p2.setQtSaques(5);
//        p2.saque(100);
//        assertEquals(3000,p2.getSaldo());
//        p2.saque(-1);
//        assertEquals(3000,p2.getSaldo());
//    }
//    @Test
//    public void saquesSucessoTest(){
//        c2 = new ContaBancaria(1,1000);
//        e2 = new ContaEspecial(2,2000,100);
//        p2 = new ContaPoupanca(3,3000);
//        //Comum
//        assertTrue(c2.validaSaque(100));
//        assertTrue(c2.validaSaque(1000));
//        c2.saque(100);
//        assertEquals(900,c2.getSaldo());
//        c2.saque(900);
//        assertEquals(0,c2.getSaldo());
//        assertFalse(c2.validaSaque(1));
//        //Especial
//        assertTrue(e2.validaSaque(100));
//        assertTrue(e2.validaSaque(2000));
//        assertTrue(e2.validaSaque(2050));
//        assertTrue(e2.validaSaque(2100));
//        e2.saque(100);
//        assertEquals(1900,e2.getSaldo());
//        e2.saque(1900);
//        assertEquals(0,e2.getSaldo());
//        e2.saque(50);
//        assertEquals(-50,e2.getSaldo());
//        e2.saque(50);
//        assertEquals(-100,e2.getSaldo());
//        assertFalse(e2.validaSaque(1));
//        //Pouoança
//        assertTrue(p2.validaSaque(100));
//        assertTrue(p2.validaSaque(3000));
//        p2.setQtSaques(4);
//        assertTrue(p2.validaSaque(100));
//        assertTrue(p2.validaSaque(3000));
//        p2.setQtSaques(0);
//        p2.saque(100);
//        assertEquals(2900,p2.getSaldo());
//        assertEquals(1,p2.getQtSaques());
//        p2.saque(2900);
//        assertEquals(0,p2.getSaldo());
//        assertEquals(2,p2.getQtSaques());
//        assertFalse(p2.validaSaque(1));
//        p2.setSaldo(1);
//        p2.setQtSaques(5);
//        assertFalse(p2.validaSaque(1));
//    }
//    @Test
//    public void depositoTest(){
//        c1 = new ContaBancaria(1,0);
//        e1 = new ContaEspecial(2,0,100);
//        p1 = new ContaPoupanca(3,0);
//        //Normal
//        c1.deposito(100);
//        assertEquals(100,c1.getSaldo());
//        c1.saque(100);
//        assertEquals(0,c1.getSaldo());
//        //Especial
//        e1.deposito(100);
//        assertEquals(100,e1.getSaldo());
//        e1.saque(150);
//        assertEquals(-50,e1.getSaldo());
//        //Poupança
//        p1.deposito(100);
//        assertEquals(100,p1.getSaldo());
//        assertEquals(0,p1.getQtSaques());
//        p1.saque(100);
//        assertEquals(0,p1.getSaldo());
//        assertEquals(1,p1.getQtSaques());
//    }
    @Test
    public void transferenciaTest(){
        c1 = new ContaBancaria(1,0);
        c2 = new ContaBancaria(2,100);
        e1 = new ContaEspecial(3,0,100);
        e2 = new ContaEspecial(4,100,100);
        p1 = new ContaPoupanca(5,0);
        p2 = new ContaPoupanca(6,100);
        // Dinheiro saindo de normal
        c1.transferencia(c2,50);
        assertEquals(0,c1.getSaldo());
        assertEquals(100,c2.getSaldo());
        c1.transferencia(c2,-1);
        assertEquals(0,c1.getSaldo());
        assertEquals(100,c2.getSaldo());
        c2.transferencia(c1,50);
        assertEquals(50,c1.getSaldo());
        assertEquals(50,c2.getSaldo());
        // Dinheiro saindo de especial
        e1.transferencia(e2,250);
        assertEquals(0,e1.getSaldo());
        assertEquals(100, e2.getSaldo());
        e1.transferencia(e2,-1);
        assertEquals(0,e1.getSaldo());
        assertEquals(100, e2.getSaldo());
        e1.transferencia(e2,50);
        assertEquals(-50,e1.getSaldo());
        assertEquals(150, e2.getSaldo());
        e2.transferencia(e1,100);
        assertEquals(50,e1.getSaldo());
        assertEquals(50, e2.getSaldo());
        // Dinheiro saindo de Poupança
        p1.transferencia(p2,150);
        assertEquals(0,p1.getSaldo());
        assertEquals(100,p2.getSaldo());
        assertEquals(0,p1.getQtSaques());
        assertEquals(0,p2.getQtSaques());
        p1.transferencia(p2,-1);
        assertEquals(0,p1.getSaldo());
        assertEquals(100,p2.getSaldo());
        assertEquals(0,p1.getQtSaques());
        assertEquals(0,p2.getQtSaques());
        p2.setQtSaques(5);
        p2.transferencia(p1,50);
        assertEquals(0,p1.getSaldo());
        assertEquals(100,p2.getSaldo());
        assertEquals(0,p1.getQtSaques());
        assertEquals(5,p2.getQtSaques());
        p2.setQtSaques(0);
        p2.transferencia(p1,50);
        assertEquals(50,p1.getSaldo());
        assertEquals(50,p2.getSaldo());
        assertEquals(0,p1.getQtSaques());
        assertEquals(1,p2.getQtSaques());
    }
}