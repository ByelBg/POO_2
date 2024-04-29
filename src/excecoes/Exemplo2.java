package excecoes;

public class Exemplo2 {
    public static void main(String[] args) {

        Dado d = new Dado();
        try {
//          d.lerNumero();
            d.lerNumero2();
            d.lerNumero3();
        }catch (Exception e){
            System.out.println("Erro na classe Dado");
        }
        System.out.println("Adeus");
    }
}
