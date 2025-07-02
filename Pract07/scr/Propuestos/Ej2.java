package Propuestos;

import java.util.Scanner;

public class Ej2 {
   public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("nodos previamente insertados");
        for (int val : values) {
            tree.insert(val);
        }
        do {
            System.out.println("\n===== MENU AVL =====");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar InOrder");
            System.out.println("5. Mostrar PreOrder");
            System.out.println("6. Mostrar PostOrder");
            System.out.println("7. Mostrar los 3 de arriba");
            System.out.println("8. Mínimo");
            System.out.println("9. Máximo");
            System.out.println("10. Predecesor");
            System.out.println("11. Sucesor");
            System.out.println("12. Vaciar arbol");
            System.out.println("13. Esta vacio?");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Valor a insertar: ");
                    tree.insert(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Valor a eliminar: ");
                    tree.remove(sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Valor a buscar: ");
                    boolean found = tree.search(sc.nextInt());
                    System.out.println(found ? "Encontrado." : "No encontrado.");
                }
                case 4 -> tree.inOrder();
                case 5 -> tree.preOrder();
                case 6 -> tree.postOrder();
                case 7 -> {
                    tree.postOrder(); tree.preOrder(); tree.inOrder();
                }
                case 8 -> System.out.println("MInimo: " + tree.min());
                case 9 -> System.out.println("Maximo: " + tree.max());
                case 10 -> {
                    System.out.print("Elemento para predecesor: ");
                    System.out.println("Predecesor: " + tree.predecesor(sc.nextInt()));
                }
                case 11 -> {
                    System.out.print("Elemento para sucesor: ");
                    System.out.println("Sucesor: " + tree.sucesor(sc.nextInt()));
                }
                case 12 -> tree.destroy();
                case 13 -> System.out.println(tree.isEmpty() ? "Arbol vacío." : "Arbol no vacío.");
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción invalida.");
            }

        } while (op != 0);
    } 
}
