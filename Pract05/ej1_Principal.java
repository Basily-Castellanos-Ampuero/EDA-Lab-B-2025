package Laboratorio.Pract05;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }
    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
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
public class ej1_Principal {
    public static void main(String[] args) {
        Pila pila = new Pila();
        for (int i = 1; i <= 10; i++) {
            pila.push(i);
        }
        pila.printStack();
    }
}
