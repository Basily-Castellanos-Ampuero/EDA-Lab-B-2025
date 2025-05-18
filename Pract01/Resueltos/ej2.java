package Laboratorio.Pract01.Resueltos;

import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número N: ");
        int n = scanner.nextInt();
        int suma = 0, contador = 1;
        while (contador <= n) {
        suma += contador;
        contador++;
        }
        System.out.println("La suma de los primeros " + n + " números naturales es: "
        + suma);
        scanner.close();
    }
}
