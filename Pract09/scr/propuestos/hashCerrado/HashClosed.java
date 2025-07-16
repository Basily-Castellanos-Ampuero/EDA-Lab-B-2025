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

    //mejorado
    public void insert(Register<E> reg) {
    int key = reg.getKey();
    int index = hash(key);
    boolean colision = false;

    System.out.println("Intentando insertar clave " + key + " (valor: " + reg.getValue() + ")");
    for (int i = 0; i < table.length; i++) {
        int probe = (index + i) % table.length;

        if (table[probe] != null && table[probe].getKey() == key && occupied[probe]) {
            System.out.println("Clave duplicada: " + key + " en posicion " + probe);
            return;
        }

        if (!occupied[probe]) {
            if (colision) {
                System.out.println("Insertado en posicion " + probe + " luego de resolver colision");
            } else {
                System.out.println("Insertado en posicion " + probe);
            }
            table[probe] = reg;
            occupied[probe] = true;
            return;
        } else {
            if (!colision) {
                System.out.println("Colision en posicion " + probe + ", buscando siguiente...");
                colision = true;
            } else {
                System.out.println("Probing en posicion " + probe + "...");
            }
        }
    }

    System.out.println("Tabla llena. No se pudo insertar: " + reg);
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
