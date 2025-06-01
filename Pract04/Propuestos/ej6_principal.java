package Laboratorio.Pract04.Propuestos;

import java.util.Scanner;

// Clase Nodo para lista doblemente enlazada
class Nodo {
    int dato;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

// Lista doblemente enlazada con todos los métodos requeridos
class ListaDoble {
    Nodo cabeza;
    Nodo cola;

    // Insertar al final
    public void insert(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Imprimir de izquierda a derecha
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
        Nodo actual = cabeza;

        while (actual != null && actual.dato != key) {
            actual = actual.siguiente;
        }

        if (actual == null) return;

        if (actual == cabeza) {
            cabeza = actual.siguiente;
            if (cabeza != null) cabeza.anterior = null;
        } else if (actual == cola) {
            cola = actual.anterior;
            if (cola != null) cola.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
    }

    public void deleteAtPosition(int index) {
        if (index < 0) return;
        Nodo actual = cabeza;
        int contador = 0;

        while (actual != null && contador < index) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual == null) return;

        if (actual == cabeza) {
            cabeza = actual.siguiente;
            if (cabeza != null) cabeza.anterior = null;
        } else if (actual == cola) {
            cola = actual.anterior;
            if (cola != null) cola.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
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
        if (cabeza == null) return;
        cabeza = cabeza.siguiente;
        if (cabeza != null) cabeza.anterior = null;
        else cola = null;
    }

    public void removeLast() {
        if (cola == null) return;
        cola = cola.anterior;
        if (cola != null) cola.siguiente = null;
        else cabeza = null;
    }
    public void addFirst(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }
    public void addLast(int dato) {
        insert(dato);
    }
}

// Clase principal con menu y nombre ej6_Principal
public class ej6_principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();

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

