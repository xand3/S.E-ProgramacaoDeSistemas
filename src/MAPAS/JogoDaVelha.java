package MAPAS;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            executarJogo(scanner);
            jogarNovamente = perguntarNovoJogo(scanner);
        }

        System.out.println("Obrigado por jogar! Até a próxima!");
        scanner.close();
    }

    // Função que contém a lógica do jogo
    public static void executarJogo(Scanner scanner) {
        Campo[][] tabuleiro = new Campo[3][3];
        boolean jogando = true;
        char simboloAtual = 'X';
        int jogadas = 0;

        iniciarJogo(tabuleiro);
        System.out.println("\n=== NOVO JOGO DO DA VELHA ===\n");

        while (jogando) {
            desenhaTabuleiro(tabuleiro);

            // Verificar Se houve vitoria
            if (jogadas > 4 && verificaVitoria(tabuleiro, simboloAtual == 'X' ? 'O' : 'X')) {
                char vencedor = (simboloAtual == 'X' ? 'O' : 'X');
                System.out.println("╔════════════════════════════════════╗");
                System.out.printf ("║     PARABÉNS! Jogador %c VENCEU!     ║\n", vencedor);
                System.out.println("╚════════════════════════════════════╝");
                jogando = false;
                continue;
            }

            if (jogadas == 9) {
                System.out.println("╔════════════════════════════════════╗");
                System.out.println("║           JOGO EMPATADO!           ║");
                System.out.println("║    Todas as posições preenchidas   ║");
                System.out.println("╚════════════════════════════════════╝");
                jogando = false;
                continue;
            }

            // Tratamento para tentar efetuar a jogada, ou exibir uma mensagem de erro no console
            try {
                int[] jogada = jogar(scanner, simboloAtual);

                if (jogada[0] < 0 || jogada[0] > 2 || jogada[1] < 0 || jogada[1] > 2) {
                    System.out.println("\n Posição inválida! Digite números entre 0 e 2.");
                    continue;
                }

                if (verificarJogada(tabuleiro, jogada, simboloAtual)) {
                    jogadas++;
                    simboloAtual = (simboloAtual == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("\n Posição já ocupada! Tente novamente.");
                }
            } catch (Exception error) {
                System.out.println("\n️ Erro: Digite apenas números!");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }

        // Exibe o estado final do tabuleiro
        desenhaTabuleiro(tabuleiro);
    }

    // Função para perguntar aos jogadores se eles desejam jogar novamente ou sai do jogo
    public static boolean perguntarNovoJogo(Scanner scanner) {
        while (true) {
            System.out.println("\nDeseja jogar novamente?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Digite sua escolha: ");

            try {
                int escolha = scanner.nextInt();
                if (escolha == 1) return true;
                if (escolha == 2) return false;
                System.out.println("\n Opção inválida! Digite 1 para Sim ou 2 para Não.");
            } catch (Exception e) {
                System.out.println("\n Entrada inválida! Digite um número.");
                scanner.nextLine();
            }
        }
    }

    // Função que desenha o tabuleiro com as jogadas dos jogadores
    public static void desenhaTabuleiro(Campo[][] tabuleiro) {
        System.out.println("\n     0   1   2");
        System.out.printf("0    %c | %c | %c\n", tabuleiro[0][0].getSimbolo(), tabuleiro[0][1].getSimbolo(), tabuleiro[0][2].getSimbolo());
        System.out.println("    -----------");
        System.out.printf("1    %c | %c | %c\n", tabuleiro[1][0].getSimbolo(), tabuleiro[1][1].getSimbolo(), tabuleiro[1][2].getSimbolo());
        System.out.println("    -----------");
        System.out.printf("2    %c | %c | %c\n", tabuleiro[2][0].getSimbolo(), tabuleiro[2][1].getSimbolo(), tabuleiro[2][2].getSimbolo());
        System.out.println();
    }

    // Função para registrar a coordenada da jogada de um determinado jogador
    public static int[] jogar(Scanner scanner, char simboloAtual) {
        int[] p = new int[2];
        System.out.printf("🎮 Jogador %c, sua vez!\n", simboloAtual);
        System.out.print("Digite a linha (0-2): ");
        p[0] = scanner.nextInt();
        System.out.print("Digite a coluna (0-2): ");
        p[1] = scanner.nextInt();
        return p;
    }

    // Função para verificar se a coordenada escolhida esta vazia, se estiver vazia continua a jogada
    public static boolean verificarJogada(Campo[][] tabuleiro, int[] p, char simboloAtual) {
        if (tabuleiro[p[0]][p[1]].getSimbolo() == ' ') {
            tabuleiro[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }
        return false;
    }

    // Função para iniciar um novo tabuleiro vazio
    public static void iniciarJogo(Campo[][] tabuleiro) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                tabuleiro[l][c] = new Campo();
            }
        }
    }

    //Função para verificar se algum dos jogadores venceu
    public static boolean verificaVitoria(Campo[][] tabuleiro, char simboloAtual) {
        // Verificar linhas do tabuleiro
        for (int l = 0; l < 3; l++) {
            if (tabuleiro[l][0].getSimbolo() == simboloAtual &&
                    tabuleiro[l][1].getSimbolo() == simboloAtual &&
                    tabuleiro[l][2].getSimbolo() == simboloAtual) {
                return true;
            }
        }

        // Verificar colunas do tabuleiro
        for (int c = 0; c < 3; c++) {
            if (tabuleiro[0][c].getSimbolo() == simboloAtual &&
                    tabuleiro[1][c].getSimbolo() == simboloAtual &&
                    tabuleiro[2][c].getSimbolo() == simboloAtual) {
                return true;
            }
        }

        // Verificar diagonais do tabuleiro
        if (tabuleiro[0][0].getSimbolo() == simboloAtual &&
                tabuleiro[1][1].getSimbolo() == simboloAtual &&
                tabuleiro[2][2].getSimbolo() == simboloAtual) {
            return true;
        }

        if (tabuleiro[0][2].getSimbolo() == simboloAtual &&
                tabuleiro[1][1].getSimbolo() == simboloAtual &&
                tabuleiro[2][0].getSimbolo() == simboloAtual) {
            return true;
        }

        return false;
    }
}