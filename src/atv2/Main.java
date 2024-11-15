package atv2;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Ford", "Fiesta", 2012, 4);
        carro.exibirDetalhes();

        System.out.println("_________________________________");

        Moto moto = new Moto("Honda", "NXR 160 Bros", 2022, false);
        moto.exibirDetalhes();
    }
}
