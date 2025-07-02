package Propuestos;

public class Ej3 {
     public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int val : valores) {
            avl.insert(val);
        }

        avl.visualizarAVL();
    }
}
