package Laboratorio.Pract01.Propuestos;

import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();
        int[] arreglo = new int[n];
        System.out.println("Ingrese los elementos:");

        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }
        ordenamientoPorInsercion(arreglo);

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void ordenamientoPorInsercion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int actual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > actual) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
        }
    }
}
