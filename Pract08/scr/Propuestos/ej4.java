
public class ej4 {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(4);

        int[] inserciones = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};

        System.out.println("=== INSERCION ===");
        for (int val : inserciones) btree.insert(val);

        btree.visualizar();
    }
}
