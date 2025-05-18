package Laboratorio.Pract02.Propuestos;

import java.util.Scanner;

public class ej6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de b: ");
        int b = scanner.nextInt();

        cuadradoRecursivo(b, 1);
    }

    public static void cuadradoRecursivo(int b, int fila) {
        if (fila > b) return;

        imprimirFila(b, fila, 1);
        System.out.println();

        cuadradoRecursivo(b, fila + 1);
    }

    public static void imprimirFila(int b, int fila, int col) {
        if (col > b) return;

        if (fila == 1 || fila == b || col == 1 || col == b) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }

        imprimirFila(b, fila, col + 1);
    }
}
