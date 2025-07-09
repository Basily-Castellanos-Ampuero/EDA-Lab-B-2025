public class ej6 {
    public static void main(String[] args) {
        // Árbol B+ de grado 4
        BPlusTree<Integer> tree = new BPlusTree<>(4);

        int[] inserciones = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};

        System.out.println("====== INSERCION PASO A PASO ======");
        for (int val : inserciones) {
            System.out.println("Insertando: " + val);
            tree.insert(val);
            System.out.println(tree);
            System.out.println("-----------------------------------");
        }

        int[] eliminaciones = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};

        System.out.println("====== ELIMINACION PASO A PASO ======");
        for (int val : eliminaciones) {
            System.out.println("Eliminando: " + val);
            tree.remove(val);
            System.out.println(tree);
            System.out.println("-----------------------------------");
        }

        System.out.println("====== ARBOL FINAL ======");
        System.out.println(tree);
    }
}
