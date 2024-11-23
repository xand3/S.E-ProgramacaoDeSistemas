package MAPAS;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Campo[][] tabuleiro = new Campo[3][3];
        boolean jogando = true;
        char simboloAtual = 'X';
        int jogadas = 0;
        Scanner scanner = new Scanner(System.in);

        iniciarJogo(tabuleiro);

        while (jogando) {
            desenhaTabuleiro(tabuleiro);

            if (verificaVitoria(tabuleiro, simboloAtual == 'X' ? 'O' : 'X')) {
                System.out.printf("Jogador %c venceu!\n", (simboloAtual == 'X' ? 'O' : 'X'));
                jogando = false;
                continue;
            }

            // Condição para verificar se o jogo chegou ao maximo de jogadas possiveis
            if (jogadas == 9) {
                System.out.println("Empate!");
                jogando = false;
                continue;
            }

            try {
                int[] jogada = jogar(scanner, simboloAtual);

                // Verifica se a posição está dentro do tabuleiro
                if (jogada[0] < 0 || jogada[0] > 2 || jogada[1] < 0 || jogada[1] > 2) {
                    System.out.println("Posição inválida! Digite números entre 0 e 2.");
                    continue;
                }

                if (verificarJogada(tabuleiro, jogada, simboloAtual)) {
                    jogadas++;
                    simboloAtual = (simboloAtual == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Posição já ocupada! Tente novamente.");
                }
            } catch (Exception error) {
                System.out.println("Erro: Digite apenas números!");
                scanner.nextLine();
            }
        }

        // Desenha o estado final do tabuleiro
        desenhaTabuleiro(tabuleiro);
        System.out.println("Fim de Jogo, obrigado por jogar!");
        scanner.close();
    }

    // Função para desenhar tabuleiro atual com as jogadas dos jogadores
    public static void desenhaTabuleiro(Campo[][] tabuleiro) {
        System.out.println("\n     0   1   2");
        System.out.printf("0    %c | %c | %c\n", tabuleiro[0][0].getSimbolo(), tabuleiro[0][1].getSimbolo(), tabuleiro[0][2].getSimbolo());
        System.out.println("    -----------");
        System.out.printf("1    %c | %c | %c\n", tabuleiro[1][0].getSimbolo(), tabuleiro[1][1].getSimbolo(), tabuleiro[1][2].getSimbolo());
        System.out.println("    -----------");
        System.out.printf("2    %c | %c | %c\n", tabuleiro[2][0].getSimbolo(), tabuleiro[2][1].getSimbolo(), tabuleiro[2][2].getSimbolo());
        System.out.println();
    }

    // Função para capturar as jogadas dos jogadores em um array [linha, coluna]
    public static int[] jogar(Scanner scanner, char simboloAtual) {
        int[] p = new int[2];
        System.out.printf("Jogador %c, sua vez!\n", simboloAtual);
        System.out.print("Digite a linha (0-2): ");
        p[0] = scanner.nextInt();
        System.out.print("Digite a coluna (0-2): ");
        p[1] = scanner.nextInt();
        return p;
    }

    //Função que verifica se é possivel jogar na celula indicada pelo jogador e se for possivel grava a jogada
    public static boolean verificarJogada(Campo[][] tabuleiro, int[] p, char simboloAtual) {
        if (tabuleiro[p[0]][p[1]].getSimbolo() == ' ') {
            tabuleiro[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }
        return false;
    }

    //Função para Iniciar um tabuleiro vazio
    public static void iniciarJogo(Campo[][] tabuleiro) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                tabuleiro[l][c] = new Campo();
            }
        }
    }

    // Função para percorrer a matriz do tabuleiro e verificar se algum dos jogadores venceu
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