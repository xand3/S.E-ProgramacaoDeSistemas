package MAPAS.Programacao2;

public class Client {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    public Client(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("""
           -----------------------------------------
           ID: %d
           Nome: %s
           Email: %s
           Telefone: %s
           -----------------------------------------""",
                id, nome, email, telefone);
    }
}
