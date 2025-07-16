public class HashClosed<E> {
    private Register<E>[] table;
    private boolean[] occupied;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        table = new Register[capacity];
        occupied = new boolean[capacity];
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(Register<E> reg) {
        int key = reg.getKey();
        int index = hash(key);

        for (int i = 0; i < table.length; i++) {
            int probeIndex = (index + i) % table.length;
            if (table[probeIndex] == null || !occupied[probeIndex]) {
                table[probeIndex] = reg;
                occupied[probeIndex] = true;
                System.out.println("Insertado: " + reg);
                return;
            } else if (table[probeIndex].getKey() == key) {
                System.out.println("ERROR: Clave duplicada " + key);
                return;
            }
        }
        System.out.println("ERROR: Tabla llena. No se pudo insertar " + reg);
    }

    public Register<E> search(int key) {
        int index = hash(key);

        for (int i = 0; i < table.length; i++) {
            int probeIndex = (index + i) % table.length;
            if (!occupied[probeIndex]) continue;
            if (table[probeIndex] != null && table[probeIndex].getKey() == key) {
                return table[probeIndex];
            }
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);

        for (int i = 0; i < table.length; i++) {
            int probeIndex = (index + i) % table.length;
            if (!occupied[probeIndex]) continue;
            if (table[probeIndex] != null && table[probeIndex].getKey() == key) {
                table[probeIndex] = null;
                occupied[probeIndex] = false;
                System.out.println("Eliminado lógicamente: " + key);
                return;
            }
        }
        System.out.println("Clave no encontrada: " + key);
    }

    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Cerrado) ---");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (!occupied[i]) {
                System.out.println("[VACÍO]");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}
