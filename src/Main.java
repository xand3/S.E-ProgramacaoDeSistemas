import java.util.Random;
import java.util.Scanner;

/**
 * @author Alexandre Bastos
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // mensagem de bem vindas do jogo, e menu para iniciar o finalizar
        String msgBoasVindas = """
                Bem-vindo ao jogo de adivinhação de Números!
                Digite a opção desejada:
                                
                1 - Digite 1 Iniciar jogo.
                2 - Digite 2 Sair do jogo.
                """;

        boolean entradaValida = false;

        // loop para validar opção escolhida pelo usuario
        while (!entradaValida) {
            System.out.println(msgBoasVindas);

            try {
                int opcao = scanner.nextInt();
                if (opcao == 1) {
                    System.out.println("iniciar jogo");
                    entradaValida = true;
                } else if (opcao == 2) {
                    System.exit(0);
                    entradaValida = true;
                } else {
                    System.out.println("Por favor digite uma das opções listadas.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! por favor digite uma das opções.");
                scanner.nextLine();
            }
        }

        // Input para definir o Inicio do intervalo
        System.out.print("Por favor defina o inicio do intervalo:");
        int inicioDoIntervalo = scanner.nextInt();

        // Input para definir o Fim do intervalo
        System.out.print("Por favor defina o fim do intervalo:");
        int fimDoIntervalo = scanner.nextInt();

        System.out.println("O intervalo escolhido está entre: " + inicioDoIntervalo + " e " + fimDoIntervalo + ".");

        int numeroSelecionado = random.nextInt(fimDoIntervalo - inicioDoIntervalo + 1) + inicioDoIntervalo;
        int tentativas = 0;
        boolean acertou = false;

        while (!acertou) {
            System.out.println("Digite seu palpite: ");
            int palpite = scanner.nextInt();
            tentativas++;

            if (palpite > numeroSelecionado) {
                System.out.println("O palpite é maior que o número sorteado");
            } else if (palpite < numeroSelecionado) {
                System.out.println("O palpite é menor que o número sorteado");
            } else {
                System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas!");
                acertou = true;
            }
        }

    }
}