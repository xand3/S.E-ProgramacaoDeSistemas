package MAPAS.Programacao2;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteController {
    private ArrayList<Cliente> clientes;
    private int proximoID;
    public Scanner scan;

    public ClienteController() {
        this.clientes = new ArrayList<>();
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

            Cliente cliente = new Cliente(proximoID++, nome, email, telefone);
            clientes.add(cliente);
            System.out.println("CLIENTE CADASTRADO! ID: " + cliente.getId());
            System.out.println(cliente);
        } catch(Exception error) {
            System.out.println("Erro ao cadastrar cliente");
        }
    }

    public void getClients() {
        System.out.println("\n ##### LISTA DE CLIENTES #####");
        if(clientes.isEmpty()) {
            System.out.println("!!NENHUM CLIENTE ENCONTRADO!!");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println("##############################");
        }
    }

    public void updateClientByID() {
        System.out.println("\n ##### ATUALIZAÇÃO DE CLIENTE #####");

        System.out.print("Digite o ID do cliente para atualização: ");
        int id = Integer.parseInt(scan.nextLine());
        Cliente cliente = getClientByID(id);
        if(cliente == null) {
            System.out.println("!!NENHUM CLIENTE ENCONTRADO!!");
            return;
        }

        // Atualizando nome do cliente
        System.out.println("nome atual: " + cliente.getNome());
        System.out.print("Digite o novo nome: ");
        String nome = scan.nextLine();
        if (!nome.isEmpty()) cliente.setNome(nome);

        // Atualizando email do cliente
        System.out.println("email atual: " + cliente.getEmail());
        System.out.print("Digite o novo email: ");
        String email = scan.nextLine();
        if (!email.isEmpty()) cliente.setEmail(email);

        // Atualizando telefone do cliente
        System.out.println("telefone atual: " + cliente.getTelefone());
        System.out.print("Digite o novo telefone: ");
        String telefone = scan.nextLine();
        if (!telefone.isEmpty()) cliente.setTelefone(telefone);

        System.out.println("Informações atualizadas com sucesso!");
        cliente = getClientByID(id);
        System.out.println(cliente);
    }

    public void getClient() {
        System.out.println("\n##### BUSCA DE CLIENTE #####");
        System.out.print("Digite o ID do cliente: ");
        int id = Integer.parseInt(scan.nextLine());

        Cliente cliente = getClientByID(id);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Cliente encontrado: ");
        System.out.println(cliente);
    }

    public void deleteClientByID() {
        System.out.println("\n##### DELETAR CLIENTE #####");
        System.out.print("Digite o ID do cliente: ");
        int id = Integer.parseInt(scan.nextLine());
        Cliente cliente = getClientByID(id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        clientes.remove(cliente);
        System.out.println("Cliente removido com sucesso!");

    }

    private Cliente getClientByID(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }


}
