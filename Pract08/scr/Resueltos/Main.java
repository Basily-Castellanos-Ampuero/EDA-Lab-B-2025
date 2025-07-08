package Laboratorio.Pract08.scr.Resueltos;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(4); // Árbol B de orden 5

        int[] valores = {100, 200, 300, 400, 500};

        System.out.println("== INSERTANDO ELEMENTOS ==");
        for (int val : valores) {
            System.out.println("Insertando: " + val);
            btree.insert(val);
            System.out.println(btree);
        }

        // (Para una versión completa, se puede implementar y llamar a remove())
    }
}
