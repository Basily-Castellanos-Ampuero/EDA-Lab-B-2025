package Laboratorio.Pract08.scr.Propuestos;

public class ej1 {
     public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(5);

        int[] inserciones = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};

        System.out.println("=== INSERCION ===");
        for (int val : inserciones) btree.insert(val);

        System.out.println("=== ELIMINACION ===");
        for (int val : inserciones) btree.remove(val);

        System.out.println("=== ARBOL FINAL ===");
        System.out.println(btree);
    }
}


