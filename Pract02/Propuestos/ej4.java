package Laboratorio.Pract02.Propuestos;

import java.util.Scanner;

public class ej4 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de b: ");
        int b = scanner.nextInt();

        trianguloRecursivo2(1, b);
    }

    public static void trianguloRecursivo2(int actual, int maximo) {
        if (actual > maximo) return;

        for (int i = 0; i < maximo - actual; i++) {
            System.out.print(" ");
        }
        for (int j = 0; j < actual; j++) {
            System.out.print("*");
        }
        System.out.println();

        trianguloRecursivo2(actual + 1, maximo);
    }
}
