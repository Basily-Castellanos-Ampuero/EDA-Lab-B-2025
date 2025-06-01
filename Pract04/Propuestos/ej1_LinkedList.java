package Laboratorio.Pract04.Propuestos;

// Clase Nodo generica para lista doblemente enlazada
class Nodo<E> {
    E dato;
    Nodo<E> anterior;
    Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

// Clase LinkedList generica doblemente enlazada
public class ej1_LinkedList<E> {
    private Nodo<E> cabeza;
    private Nodo<E> cola;

    // Insertar al final
    public void insertar(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Imprimir lista hacia adelante
    public void imprimirAdelante() {
        Nodo<E> actual = cabeza;
        System.out.print("Lista hacia adelante: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Imprimir lista hacia atras
    public void imprimirAtras() {
        Nodo<E> actual = cola;
        System.out.print("Lista hacia atras: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    // Metodo principal para probar
    public static void main(String[] args) {
        ej1_LinkedList<Integer> lista = new ej1_LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            lista.insertar(i);
        }

        lista.imprimirAdelante();
        lista.imprimirAtras();
    }
}

