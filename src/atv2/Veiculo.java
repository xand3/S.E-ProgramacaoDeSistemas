package atv2;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirDetalhes() {
        String detalhes = """
                Marca: %s
                Modelo: %s
                Ano: %s
                """.formatted(marca, modelo, ano);

        System.out.println(detalhes);
    }
}
