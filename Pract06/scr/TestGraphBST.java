package scr;

public class TestGraphBST {
    public static void main(String[] args) {
        GraphBST<Integer> tree = new GraphBST<>();

        int[] valores = {50, 30, 70, 20, 40, 60, 80, 10};
        for (int v : valores) {
            tree.insert(v);
        }

        tree.displayTree(); 

        System.out.println("Recorrido InOrder:");
        tree.inOrder();   
    }
} 
