package Exercicios;

import javax.swing.JOptionPane;

public class Vetor {
    public static void main(String[] args){
        int vetorA[] = new int[5];
        int i;
        for (i=0; i<5; i++){
            vetorA[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número"));
        }
        for (i=0; i<10; i++){
            System.out.println(vetorA[i]);
        }
    }
}
