
public class ej8 {
    public static void main(String[] args) {
        BPlusTree<Integer> tree = new BPlusTree<>(5); // Árbol B+ de grado 5

        int[] inserciones = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};

        System.out.println("====== INSERCION PASO A PASO ======");
        for (int val : inserciones) {
            System.out.println("Insertando: " + val);
            tree.insert(val);
            System.out.println(tree);
            System.out.println("-----------------------------------");
        }

        tree.visualizar();
    } 
}
