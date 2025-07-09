package Laboratorio.Pract08.scr.Resueltos;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(4); 

        int[] valores = {100, 200, 300, 400, 500};

        System.out.println("== INSERTANDO ELEMENTOS ==");
        for (int val : valores) {
            System.out.println("Insertando: " + val);
            btree.insert(val);
            System.out.println(btree);
        }

        // Prueba simple del funcionamiento
    }
}
