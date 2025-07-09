
import java.util.Scanner;

public class ej3 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el grado (orden) del arbol B: ");
        int orden = sc.nextInt();
        BTree<Integer> btree = new BTree<>(orden);

        int opcion;
        do {
            System.out.println("\n======= MENU ARBOL B =======");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar arbol");
            System.out.println("5. Minimo");
            System.out.println("6. Maximo");
            System.out.println("7. Predecesor");
            System.out.println("8. Sucesor");
            System.out.println("9. Vaciar arbol");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    btree.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Valor a eliminar: ");
                    btree.remove(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Valor a buscar: ");
                    System.out.println("Existe? " + btree.search(sc.nextInt()));
                    break;
                case 4:
                    System.out.println(btree);
                    break;
                case 5:
                    System.out.println("Minimo: " + btree.min());
                    break;
                case 6:
                    System.out.println("Maximo: " + btree.max());
                    break;
                case 7:
                    System.out.print("Elemento: ");
                    System.out.println("Predecesor: " + btree.predecesor(sc.nextInt()));
                    break;
                case 8:
                    System.out.print("Elemento: ");
                    System.out.println("Sucesor: " + btree.sucesor(sc.nextInt()));
                    break;
                case 9:
                    btree.destroy();
                    System.out.println("Arbol eliminado.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
        
        sc.close();
    }
}
