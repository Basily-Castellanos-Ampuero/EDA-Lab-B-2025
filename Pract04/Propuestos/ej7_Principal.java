package Laboratorio.Pract04.Propuestos;

import java.util.Scanner;

// Nodo para lista circular
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaCircular {
    Nodo cabeza = null;
    Nodo cola = null;

    // Insertar al final
    public void insert(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
    }

    // Insertar al inicio
    public void addFirst(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza;
        }
    }

    // Insertar al final (igual que insert)
    public void addLast(int dato) {
        insert(dato);
    }

    // Eliminar por valor
    public void deleteByKey(int key) {
        if (cabeza == null) return;

        Nodo actual = cabeza;
        Nodo anterior = cola;

        do {
            if (actual.dato == key) {
                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {
                    cola = anterior;
                    cola.siguiente = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    // Eliminar por posicion
    public void deleteAtPosition(int index) {
        if (cabeza == null || index < 0) return;

        Nodo actual = cabeza;
        Nodo anterior = cola;
        int contador = 0;

        do {
            if (contador == index) {
                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {
                    cola = anterior;
                    cola.siguiente = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
            contador++;
        } while (actual != cabeza);
    }

    // Eliminar primero
    public void removeFirst() {
        if (cabeza == null) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        }
    }

    // Eliminar ultimo
    public void removeLast() {
        if (cabeza == null) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != cola) {
                actual = actual.siguiente;
            }
            cola = actual;
            cola.siguiente = cabeza;
        }
    }

    // Imprimir lista
    public void printList() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }
        Nodo actual = cabeza;
        System.out.print("Lista circular: ");
        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }

    // Tamaño de la lista
    public int size() {
        if (cabeza == null) return 0;
        Nodo actual = cabeza;
        int contador = 0;
        do {
            contador++;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return contador;
    }
}

// Clase principal con menu
public class ej7_Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircular lista = new ListaCircular();

        for (int i = 1; i <= 12; i++) {
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
