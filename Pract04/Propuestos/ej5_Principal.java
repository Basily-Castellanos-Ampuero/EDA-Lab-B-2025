package Laboratorio.Pract04.Propuestos;

import java.util.Scanner;

// Clase Nodo simple
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Lista enlazada simple con métodos solicitados
class ListaEnlazada {
    Nodo cabeza;

    public void insert(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void printList() {
        Nodo actual = cabeza;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void deleteByKey(int key) {
        Nodo actual = cabeza, anterior = null;
        if (actual != null && actual.dato == key) {
            cabeza = actual.siguiente;
            return;
        }
        while (actual != null && actual.dato != key) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual != null) {
            anterior.siguiente = actual.siguiente;
        }
    }

    public void deleteAtPosition(int index) {
        if (index < 0 || cabeza == null) return;
        Nodo actual = cabeza;
        if (index == 0) {
            cabeza = actual.siguiente;
            return;
        }
        for (int i = 0; actual != null && i < index - 1; i++) {
            actual = actual.siguiente;
        }
        if (actual == null || actual.siguiente == null) return;
        actual.siguiente = actual.siguiente.siguiente;
    }

    public int size() {
        int count = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    public void removeFirst() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        }
    }

    public void removeLast() {
        if (cabeza == null || cabeza.siguiente == null) {
            cabeza = null;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = null;
    }

    public void addFirst(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void addLast(int dato) {
        insert(dato);
    }
}

// Clase principal con nombre ej5_Principal
public class ej5_Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        for (int i = 1; i <= 10; i++) {
            lista.insert(i);
        }

        int opcion;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Insertar al inicio");
            System.out.println("3. Insertar al final");
            System.out.println("4. Eliminar por valor");
            System.out.println("5. Eliminar por posicion");
            System.out.println("6. Eliminar primero");
            System.out.println("7. Eliminar ultimo");
            System.out.println("8. Mostrar tamanio");
            System.out.println("9. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    lista.printList();
                    break;
                case 2:
                    System.out.print("Ingrese numero: ");
                    lista.addFirst(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Ingrese numero: ");
                    lista.addLast(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Ingrese valor a eliminar: ");
                    lista.deleteByKey(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Ingrese posicion a eliminar: ");
                    lista.deleteAtPosition(sc.nextInt());
                    break;
                case 6:
                    lista.removeFirst();
                    System.out.println("Primer nodo eliminado.");
                    break;
                case 7:
                    lista.removeLast();
                    System.out.println("Ultimo nodo eliminado.");
                    break;
                case 8:
                    System.out.println("Tamanio: " + lista.size());
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 9);

        sc.close();
    }
}
