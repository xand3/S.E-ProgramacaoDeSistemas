package MAPAS;

public class JogoDaVelha {
    private static char[][] tabuleiro = new char[3][3];


    private static void iniciarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

}