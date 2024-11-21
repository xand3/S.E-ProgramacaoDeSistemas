package Exercicios;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 2, 10, 6, 7);
        Collections.sort(lista);
        Collections.reverse(lista);
        System.out.println(lista);
    }
}
