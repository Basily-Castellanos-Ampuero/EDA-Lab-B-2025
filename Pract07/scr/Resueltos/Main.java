package Resueltos;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] values = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
        //Insercion
        System.out.println("== INSERCIÓN ==");
        for (int val : values) {
            System.out.println("Insertando: " + val);
            avl.insert(val);
        }

        avl.inOrder();
        avl.preOrder();
        avl.postOrder();

        avl.destroy();
        //Rotacion y balanceo
        System.out.println("== ROTACION SIMPLE A LA IZQUIERDA ==");
        System.out.println("Insertando: 10");
        avl.insert(10);
        avl.inOrder();

        System.out.println("Insertando: 20");
        avl.insert(20);
        avl.inOrder();

        System.out.println("Insertando: 30 (deberia activar rotación simple a la izquierda)");
        avl.insert(30);
        avl.inOrder();
        avl.preOrder();
        avl.postOrder();

        /*
         * inicialmente sería:
         *     10
         *       \
         *       20
         *         \
         *         30
         * El AVL detecta un desbalance Derecha-Derecha (balance = -2)
         * Rotación simple a la izquierda sobre 10, resultando en:
         *       20
         *      /  \
         *     10   30
         */

        System.out.println("\n== INSERTANDO MAS PARA OBSERVAR OTRO BALANCEO A LA IZQUIERDA ==");

        System.out.println("Insertando: 40");
        avl.insert(40);
        avl.inOrder();

        System.out.println("Insertando: 50 (deberia forzar otro balanceo a la izquierda)");
        avl.insert(50);
        avl.inOrder();
        avl.preOrder();
    }
}

    

