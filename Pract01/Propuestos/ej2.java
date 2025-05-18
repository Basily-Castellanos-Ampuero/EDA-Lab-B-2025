package Laboratorio.Pract01.Propuestos;

import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el limite inferior del rango: ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el limite superior del rango: ");
        int fin = scanner.nextInt();

        if (inicio > fin || fin < 2) {
            System.out.println("Rango invalido.");
            return;
        }

        boolean[] esPrimo = new boolean[fin + 1];
        for (int i = 2; i <= fin; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i * i <= fin; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= fin; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        System.out.println("Numeros primos en el rango:");
        for (int i = Math.max(2, inicio); i <= fin; i++) {
            if (esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
