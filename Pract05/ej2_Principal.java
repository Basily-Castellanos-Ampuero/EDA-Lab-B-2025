package Laboratorio.Pract05;

import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
    }
}

class Pila {
    private Nodo cima;

    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pila vacia");
        int valor = cima.dato;
        cima = cima.siguiente;
        return valor;
    }
    public int top() {
        if (isEmpty()) throw new RuntimeException("Pila vacia");
        return cima.dato;
    }
    public void destroyStack() {
        cima = null;
    }
    public boolean isEmpty() {
        return cima == null;
    }
    public boolean isFull() {
        return false; // Pila dinamica
    }
    public void printStack() {
        Nodo actual = cima;
        System.out.print("Pila: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class ej2_Principal {
    public static void main(String[] args) {
        Pila pila = new Pila();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Push\n2. Pop\n3. Top\n4. Destroy\n5. isEmpty\n6. isFull\n7. Mostrar Pila\n0. Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese valor: ");
                    int val = sc.nextInt();
                    pila.push(val);
                    break;
                case 2:
                    System.out.println("Pop: " + pila.pop());
                    break;
                case 3:
                    System.out.println("Top: " + pila.top());
                    break;
                case 4:
                    pila.destroyStack();
                    System.out.println("Pila eliminada.");
                    break;
                case 5:
                    System.out.println(pila.isEmpty() ? "Pila vacía." : "Pila no vacía.");
                    break;
                case 6:
                    System.out.println(pila.isFull() ? "Pila llena." : "Pila no llena (dinámica).");
                    break;
                case 7:
                    pila.printStack();
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}

