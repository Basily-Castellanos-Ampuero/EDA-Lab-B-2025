package Laboratorio.Pract04.Propuestos;

import java.util.LinkedList;

public class ej4_ListaCircular {
    public static void main(String[] args) {
        // Crear una LinkedList con los elementos del 1 al 12
        LinkedList<Integer> lista = new LinkedList<>();

        for (int i = 1; i <= 12; i++) {
            lista.add(i);
        }
        // Imprimir recorrido circular (simulando 2 vueltas)
        System.out.println("Lista circular simulada (2 vueltas):");
        int vueltas = 2;
        int total = lista.size() * vueltas;

        for (int i = 0; i < total; i++) {
            // Usamos el operador modulo para simular el efecto circular
            int index = i % lista.size();
            System.out.print(lista.get(index) + " ");
        }
        System.out.println();
    }
}
