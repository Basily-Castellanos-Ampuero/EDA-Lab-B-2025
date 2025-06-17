package scr;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        System.out.println("InOrder:");
        bst.inOrder();
        System.out.println("PreOrder:");
        bst.preOrder();
        System.out.println("PostOrder:");
        bst.postOrder();

        System.out.println("Minimo: " + bst.min());
        System.out.println("Maximo: " + bst.max());

        System.out.println("Buscar 40: " + bst.search(40));
        System.out.println("Predecesor de 60: " + bst.predecessor(60));
        System.out.println("Sucesor de 60: " + bst.successor(60));

        bst.remove(70);
        System.out.println("InOrder despues de eliminar 70:");
        bst.inOrder();
        bst.destroy();
        System.out.println("Arbol vacio: " + bst.isEmpty());
    }
}

