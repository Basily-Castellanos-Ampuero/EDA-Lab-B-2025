package Laboratorio.Pract05;

import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
    }
}

class Cola {
    private Nodo frente, fin;
    public Cola() {
        frente = fin = null;
    }
    public void encolar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (fin != null) {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        if (frente == null) {
            frente = nuevo;
        }
    }
    public int desencolar() {
        if (isEmpty()) throw new RuntimeException("Cola vacia");
        int valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return valor;
    }
    public void destroyQueue() {
        frente = fin = null;
    }
    public boolean isEmpty() {
        return frente == null;
    }
    public boolean isFull() {
        return false; 
    }
    public int front() {
        if (isEmpty()) throw new RuntimeException("Cola vacia");
        return frente.dato;
    }
    public int back() {
        if (isEmpty()) throw new RuntimeException("Cola vacia");
        return fin.dato;
    }
    public void printQueue() {
        Nodo actual = frente;
        System.out.print("Cola: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class ej4_Principal {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Encolar\n2. Desencolar\n3. Front\n4. Back\n5. Destroy\n6. isEmpty\n7. isFull\n8. Mostrar Cola\n0. Salir");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese valor: ");
                    int val = sc.nextInt();
                    cola.encolar(val);
                    break;
                case 2:
                    System.out.println("Desencolado: " + cola.desencolar());
                    break;
                case 3:
                    System.out.println("Front: " + cola.front());
                    break;
                case 4:
                    System.out.println("Back: " + cola.back());
                    break;
                case 5:
                    cola.destroyQueue();
                    System.out.println("Cola eliminada.");
                    break;
                case 6:
                    System.out.println(cola.isEmpty() ? "Cola vacia." : "Cola no vacia.");
                    break;
                case 7:
                    System.out.println(cola.isFull() ? "Cola llena." : "Cola no llena (dinamica).");
                    break;
                case 8:
                    cola.printQueue();
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}
