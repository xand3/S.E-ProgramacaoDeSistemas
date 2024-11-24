package MAPAS.Programacao2;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientController {
    private ArrayList<Client> clients;
    private int proximoID;
    public Scanner scan;

    public ClientController() {
        this.clients = new ArrayList<>();
        this.proximoID = 1;
        this.scan = new Scanner(System.in);
    }

    public void createClient() {
        System.out.println("\n ##### CADASTRO DE CLIENTES #####");
        try {
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Email: ");
            String email = scan.nextLine();
            System.out.print("Telefone: ");
            String telefone = scan.nextLine();

            Client client = new Client(proximoID++, nome, email, telefone);
            clients.add(client);
            System.out.println("CLIENTE CADASTRADO! ID: " + client.getId());
            System.out.println(client);
        } catch (Exception error) {
            System.out.println("Erro ao cadastrar cliente");
        }
    }

    public void getClients() {
        System.out.println("\n ##### LISTA DE CLIENTES #####");
        if (clients.isEmpty()) {
            System.out.println("!!NENHUM CLIENTE ENCONTRADO!!");
            return;
        }
        for (Client client : clients) {
            System.out.println(client);
            System.out.println("##############################");
        }
    }

    public void updateClientByID() {
        System.out.println("\n ##### ATUALIZAÇÃO DE CLIENTE #####");

        System.out.print("Digite o ID do cliente para atualização: ");
        int id = Integer.parseInt(scan.nextLine());
        Client client = getClientByID(id);
        if (client == null) {
            System.out.println("!!!NENHUM CLIENTE ENCONTRADO!!!");
            return;
        }

        // Atualizando nome do cliente
        System.out.println("nome atual: " + client.getNome());
        System.out.print("Digite o novo nome: ");
        String nome = scan.nextLine();
        if (!nome.isEmpty()) client.setNome(nome);

        // Atualizando email do cliente
        System.out.println("email atual: " + client.getEmail());
        System.out.print("Digite o novo email: ");
        String email = scan.nextLine();
        if (!email.isEmpty()) client.setEmail(email);

        // Atualizando telefone do cliente
        System.out.println("telefone atual: " + client.getTelefone());
        System.out.print("Digite o novo telefone: ");
        String telefone = scan.nextLine();
        if (!telefone.isEmpty()) client.setTelefone(telefone);

        System.out.println("Informações atualizadas com sucesso!");
        client = getClientByID(id);
        System.out.println(client);
    }

    public void getClient() {
        System.out.println("\n##### BUSCA DE CLIENTE #####");
        System.out.print("Digite o ID do cliente: ");
        int id = Integer.parseInt(scan.nextLine());

        Client client = getClientByID(id);
        if (client == null) {
            System.out.println("!!!CLIENTE NÃO ENCONTRADO!!!");
            return;
        }

        System.out.println("Cliente encontrado: ");
        System.out.println(client);
    }

    public void deleteClientByID() {
        System.out.println("\n##### DELETAR CLIENTE #####");
        System.out.print("Digite o ID do cliente: ");
        int id = Integer.parseInt(scan.nextLine());
        Client client = getClientByID(id);

        if (client == null) {
            System.out.println("!!!CLIENTE NÃO ENCONTRADO!!!");
            return;
        }
        clients.remove(client);
        System.out.println("Cliente removido com sucesso!");
    }

    private Client getClientByID(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
