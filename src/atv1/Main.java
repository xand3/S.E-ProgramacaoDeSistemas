package atv1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Alexandre Bastos
 */

public class Main {
    public static void jogoDeAdvinhacao(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        String welcomeMessage = """
                [***********************************************************]
                [********BEM-VINDO AO JOGO DE ADIVINHAÇÃO DE NÚMEROS!*******]
                [***********************************************************]
                """;
        System.out.println(welcomeMessage);

        while (playAgain) {
            System.out.println();
            int option = scanNumber(scanner, """
                    1 - Digite 1 para iniciar o jogo.
                    2 - Digite 2 para fechar o jogo.
                    """);
            if (option == 1) {
                System.out.println("Para Iniciar o jogo por favor escolha o intervalo númerico.");

                int initOfRange = scanNumber(scanner, "Por favor digite o valor inicial do intervalo: ");
                int endOfRange = scanNumber(scanner, "Por favor digite o valor final do intervalo: ");

                if (initOfRange >= endOfRange) {
                    System.out.println("Intervalo inválido! O valor final deve ser maior que o valor final.");
                    continue;
                }

                System.out.println("O intervalo escolhido está entre: " + initOfRange + " e " + endOfRange + ".");

                int selectedNumber = random.nextInt(endOfRange - initOfRange + 1) + initOfRange;
                int tries = 0;
                boolean hit = false;

                while (!hit) {
                    System.out.println("Digite sua tentativa (ou 'sair' para encerrar o jogo): ");
                    String userEntry = scanner.nextLine();

                    if (userEntry.equalsIgnoreCase("sair")) {
                        endGame();
                    }

                    try {
                        int userTry = Integer.parseInt(userEntry);
                        tries++;

                        if (!verifyTry(userTry, initOfRange, endOfRange)) {
                            System.out.println("Entrada inválida!, Por favor digite um número que dentro do intervalo");
                            System.out.println("Inicio do intervalo: " + initOfRange + "      Fim do intervalo: " + endOfRange + ".");
                        } else if (userTry == selectedNumber) {
                            System.out.println("Parabéns! Você acertou em " + tries + " tentativas!");
                            hit = true;
                        } else if (userTry < selectedNumber) {
                            System.out.println("O número sorteado é maior! Tente novamente.");
                        } else {
                            System.out.println("O número sorteado é menor! Tente novamente.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida! Por favor, digite um número.");
                    }

                }

            } else {
                endGame();
            }
            playAgain = false;
        }
    }

    // Função para verificar se a tentativa do usuario esta dentro do intervalo definido pelo usuario
    private static boolean verifyTry(int userTry, int initOfRange, int endOfRange) {
        return userTry >= initOfRange && userTry <= endOfRange;
    }

    // Função para receber uma entrada númerica do usuario
    private static int scanNumber(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            String entry = scanner.nextLine();

            // Tratamento de exceção para possivel entrada errada do usuario
            try {
                return Integer.parseInt(entry);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, por favor informe um número válido.");
            }
        }
    }

    // Função para finalizar o jogo
    private static void endGame() {
        System.out.println("""
                [************ Obrigado por jogar! até a próxima. ***********]
                """);
        System.exit(0);
    }
}