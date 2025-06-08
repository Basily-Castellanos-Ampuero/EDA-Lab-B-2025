package Laboratorio.Pract05;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
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
    public void mostrarCola() {
        Nodo actual = frente;
        System.out.print("Cola: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
public class ej3_Principal {
    public static void main(String[] args) {
        Cola cola = new Cola();
        for (int i = 1; i <= 10; i++) {
            cola.encolar(i);
        }
        cola.mostrarCola();
    }
}
