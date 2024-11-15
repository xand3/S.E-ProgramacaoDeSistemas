package atv2;

public class Moto extends Veiculo {
    private boolean temSidecar;

    public Moto(String marca, String modelo, int ano, boolean temSidecar) {
        super(marca, modelo, ano);
        this.temSidecar = temSidecar;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tem sidecar: " + (temSidecar ? "Sim" : "Não"));
    }
}
