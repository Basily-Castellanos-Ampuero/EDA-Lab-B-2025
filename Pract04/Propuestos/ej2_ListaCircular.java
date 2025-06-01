package Laboratorio.Pract04.Propuestos;

// Clase Nodo para lista circular
class Nodo<E> {
    E dato;
    Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Clase ListaCircular generica
public class ej2_ListaCircular<E> {
    private Nodo<E> cabeza;

    // Insertar al final
    public void insertar(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo<E> actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
    }

    // Imprimir elementos de la lista circular
    public void imprimir() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }
        Nodo<E> actual = cabeza;
        System.out.print("Lista circular: ");
        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }

    // Metodo principal para probar
    public static void main(String[] args) {
        ej2_ListaCircular<Integer> lista = new ej2_ListaCircular<>();

        for (int i = 1; i <= 12; i++) {
            lista.insertar(i);
        }

        lista.imprimir();
    }
}

