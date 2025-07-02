package Propuestos;

public class Ej1 {
     public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] values = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};

        System.out.println("=== INSERTANDO NODOS ===");
        for (int val : values) {
            avl.insert(val);
        }

        System.out.println("\n=== RECORRIDOS ===");
        avl.inOrder();
        avl.preOrder();
        avl.postOrder();

        System.out.println("\n=== ELIMINANDO NODOS ===");
        for (int val : values) {
            avl.remove(val);
            avl.inOrder();
            avl.preOrder();
        }

        System.out.println("\n¿Árbol vacío?: " + avl.isEmpty());
    }
}
