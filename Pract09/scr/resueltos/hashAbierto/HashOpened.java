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

        for (Register2<E> r : table[index]) {
            if (r.getKey() == reg.getKey() && !r.isDeleted()) {
                System.out.println("ERROR: Clave duplicada " + reg.getKey());
                return;
            }
        }

        table[index].add(reg);
        System.out.println("Insertado: " + reg);
    }

    public void delete(int key) {
        int index = hash(key);
        for (Register2<E> r : table[index]) {
            if (r.getKey() == key && !r.isDeleted()) {
                r.delete();
                System.out.println("Eliminado logicamente: " + key);
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
        System.out.println("\n--- Estado de la Tabla Hash (Abierto) ---");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("[VACÍO]");
            } else {
                for (Register2<E> r : table[i]) {
                    System.out.print(r + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}
