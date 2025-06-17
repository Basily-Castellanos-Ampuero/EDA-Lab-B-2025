package scr;

import java.util.Scanner;

public class TestPalabraBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST<Integer> bst = new BST<>();

        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        for (char c : palabra.toCharArray()) {
            bst.insert((int) c);
        }
        System.out.println("Recorrido InOrder (valores ASCII):");
        bst.inOrder();
        System.out.println("Recorrido PreOrder:");
        bst.preOrder();
        System.out.println("Recorrido PostOrder:");
        bst.postOrder();
    }
}


