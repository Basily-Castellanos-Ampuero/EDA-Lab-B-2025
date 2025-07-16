package hashAbierto;

import java.util.LinkedList;

public class HashOpened<E> {
    private LinkedList<Register2<E>>[] table;

    @SuppressWarnings("unchecked")
    public HashOpened(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(Register2<E> reg) {
        int index = hash(reg.getKey());
        System.out.println("Intentando insertar clave " + reg.getKey() + " (valor: " + reg.getValue() + ") en posicion " + index);

        for (Register2<E> r : table[index]) {
            System.out.println("Recorriendo lista en posicion " + index + ": " + r);
            if (r.getKey() == reg.getKey() && !r.isDeleted()) {
                System.out.println("Clave duplicada: " + reg.getKey());
                return;
            }
        }

        table[index].add(reg);
        System.out.println("Insertado: " + reg + " en lista de la posicion " + index);
    }

    public void delete(int key) {
        int index = hash(key);
        for (Register2<E> r : table[index]) {
            if (r.getKey() == key && !r.isDeleted()) {
                r.delete();
                System.out.println("Eliminado logicamente: " + key + " en posicion " + index);
                return;
            }
        }
        System.out.println("Clave no encontrada: " + key);
    }

    public Register2<E> search(int key) {
        int index = hash(key);
        for (Register2<E> r : table[index]) {
            if (r.getKey() == key && !r.isDeleted()) {
                return r;
            }
        }
        return null;
    }

    public void showTable() {
        System.out.println("\nEstado de la tabla hash (abierto):");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("[VACIO]");
            } else {
                for (Register2<E> r : table[i]) {
                    System.out.print(r + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}

