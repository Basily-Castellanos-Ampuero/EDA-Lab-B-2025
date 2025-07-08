package Laboratorio.Pract08.scr.Propuestos;

import Laboratorio.Pract08.scr.Resueltos.BTree;

public class ej1 {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(5); // Arbol B de orden 5

        // Inserciones
        int[] valores = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
        System.out.println("== INSERTANDO ELEMENTOS ==");
        for (int val : valores) {
            System.out.println("Insertando: " + val);
            btree.insert(val);
        }

        // Mostrar arbol
        System.out.println("\n== ESTRUCTURA DEL ARBOL B ==");
        System.out.println(btree);

        // Busquedas
        System.out.println("== BUSQUEDA DE ELEMENTOS ==");
        int[] busquedas = {25, 190, 999};
        for (int val : busquedas) {
            System.out.println("¿" + val + " esta en el arbol?: " + (btree.search(val) ? "Si" : "No"));
        }

        // Verificar si esta vacio
        System.out.println("\n¿El arbol esta vacio?: " + (btree.isEmpty() ? "Si" : "No"));

        // Obtener minimo y maximo
        System.out.println("Minimo: " + btree.min());
        System.out.println("Maximo: " + btree.max());

        // Eliminar un elemento (si se implementa)
        System.out.println("\n== ELIMINACION (no implementada en este ejemplo) ==");
        System.out.println("Eliminar 150: (funcion remove() no implementada)");
    }
}


