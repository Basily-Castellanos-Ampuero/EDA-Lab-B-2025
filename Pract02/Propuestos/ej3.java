package Laboratorio.Pract02.Propuestos;

import java.util.Scanner;

public class ej3 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de b: ");
        int b = scanner.nextInt();

        trianguloRecursivo1(1, b);
    }

    public static void trianguloRecursivo1(int actual, int maximo) {
        if (actual > maximo) return;

        for (int i = 0; i < actual; i++) {
            System.out.print("*");
        }
        System.out.println();

        trianguloRecursivo1(actual + 1, maximo);
    }
}
