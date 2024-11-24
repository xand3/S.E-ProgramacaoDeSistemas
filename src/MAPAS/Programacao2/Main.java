package MAPAS.Programacao2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClientController controller = new ClientController();

        while (true) {
            System.out.println("########### SISTEMA CRUD DE CLIENTES ###########");
            System.out.println("""
                    1. Cadastrar Cliente
                    2. Listar Clientes
                    3. Atualizar Cliente
                    4. Remover Cliente
                    5. Buscar Cliente
                    6. Sair""");
            System.out.print("Escolha uma das opções: ");

            int option;
            try {
                option = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException error) {
                System.out.println("Opção inválida! por favor tente novamente");
                continue;
            }

            try {
                switch (option) {
                    case 1:
                        controller.createClient();
                        break;
                    case 2:
                        controller.getClients();
                        break;
                    case 3:
                        controller.updateClientByID();
                        break;
                    case 4:
                        controller.deleteClientByID();
                        break;
                    case 5:
                        controller.getClient();
                        break;
                    case 6:
                        System.out.println("ENCERRANDO O SISTEMA (todas as informações serão perdidas)...");
                        return;
                    default:
                        System.out.println("Opção inválida! por favor tente novamente");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}