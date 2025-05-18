package Laboratorio.Pract02.Propuestos;

import java.util.Scanner;

public class ej5 {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de b: ");
        int b = scanner.nextInt();

        trianguloRecursivo3(1, b);
    }

    public static void trianguloRecursivo3(int actual, int maximo) {
        if (actual > maximo) return;

        for (int i = 0; i < maximo - actual; i++) {
            System.out.print(" ");
        }
        for (int j = 0; j < 2 * actual - 1; j++) {
            System.out.print("*");
        }
        System.out.println();

        trianguloRecursivo3(actual + 1, maximo);
    }
}
