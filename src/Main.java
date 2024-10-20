import java.util.Random;
import java.util.Scanner;

/**
 * @author Alexandre Bastos
 * */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // mensagem de bem vindas do jogo, e menu para iniciar o finalizar
        String welcomeMessage = """
                Bem-vindo ao jogo de adivinhação de Números!
                Digite a opção desejada:
                
                1 - Digite 1 Iniciar jogo.
                2 - Digite 2 Sair do jogo.
                """;
        System.out.println(welcomeMessage);
        int option = scanner.nextInt();
        if(option == 1) {
            System.out.println("iniciar jogo");
        } else if(option == 2) {
            System.exit(0);;
        }

        // Input para definir o Inicio do intervalo
        System.out.print("Por favor defina o inicio do intervalo:");
        int start = scanner.nextInt();

        // Input para definir o Fim do intervalo
        System.out.print("Por favor defina o fim do intervalo:");
        int end = scanner.nextInt();

        System.out.println("O intervalo escolhido está entre: " + start + " e " + end + ".");

        int selectedNumber = random.nextInt(end - start + 1) + start;

        while (true) {
            System.out.println("Digite seu palpite: ");
            int guessNumber = scanner.nextInt();

            if(guessNumber > selectedNumber) {
                System.out.println("O palpite é maior que o número sorteado");
            } else if(guessNumber < selectedNumber) {
                System.out.println("O palpite é menor que o número sorteado");
            } else {
                System.out.println("parabéns");
                break;
            }
        }

    }
}