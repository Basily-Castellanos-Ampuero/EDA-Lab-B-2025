package Laboratorio.Pract02.Propuestos;

import java.util.Scanner;

public class ej2 {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }

        System.out.print("Ingrese la cantidad de posiciones a rotar (d): ");
        int d = scanner.nextInt();

        rotarIzquierdaArray(arreglo, d);
    }

    public static void rotarIzquierdaArray(int[] arreglo, int d) {
        int n = arreglo.length;
        d = d % n;

        int[] resultado = new int[n];

        for (int i = 0; i < n; i++) {
            resultado[i] = arreglo[(i + d) % n];
        }

        System.out.println("Arreglo rotado a la izquierda desde la posicion " + d + ":");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
