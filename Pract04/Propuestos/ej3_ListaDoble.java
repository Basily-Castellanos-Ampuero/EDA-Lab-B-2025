package Laboratorio.Pract04.Propuestos;

import java.util.LinkedList;

public class ej3_ListaDoble {
    public static void main(String[] args) {
        // Crear una lista doblemente enlazada de enteros
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }

        // Imprimir la lista
        System.out.println("Elementos de la lista: " + lista);
        // Recorrer hacia adelante
        System.out.print("Recorrido hacia adelante: ");
        for (Integer numero : lista) {
            System.out.print(numero + " ");
        }
        System.out.println();
        // Recorrer hacia atras usando un iterador inverso
        System.out.print("Recorrido hacia atras: ");
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();
    }
}

