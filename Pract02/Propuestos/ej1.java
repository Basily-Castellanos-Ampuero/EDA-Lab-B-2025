package Laboratorio.Pract02.Propuestos;

import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }

        invertirArray(arreglo);
    }

    public static void invertirArray(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arreglo[i];
            arreglo[i] = arreglo[n - 1 - i];
            arreglo[n - 1 - i] = temp;
        }

        System.out.println("Arreglo invertido:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
