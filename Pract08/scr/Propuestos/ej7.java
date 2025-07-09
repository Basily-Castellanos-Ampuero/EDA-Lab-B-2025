import java.util.Scanner;

public class ej7 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el grado (orden) del arbol B+: ");
        int orden = sc.nextInt();

        BPlusTree<Integer> bpt = new BPlusTree<>(orden);

        int opcion;
        do {
            System.out.println("\n==== MENU ARBOL B+ ====");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar arbol");
            System.out.println("5. Minimo");
            System.out.println("6. Maximo");
            System.out.println("7. Predecesor");
            System.out.println("8. Sucesor");
            System.out.println("9. Vaciar arbol");
            System.out.println("10. Insertar datos de ejercicios 5 y 6");
            System.out.println("11. Eliminar datos de ejercicios 5 y 6");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    bpt.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Valor a eliminar: ");
                    bpt.remove(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Valor a buscar: ");
                    System.out.println("Existe? " + bpt.search(sc.nextInt()));
                    break;
                case 4:
                    System.out.println(bpt);
                    break;
                case 5:
                    System.out.println("Minimo: " + bpt.min());
                    break;
                case 6:
                    System.out.println("Maximo: " + bpt.max());
                    break;
                case 7:
                    System.out.print("Elemento: ");
                    System.out.println("Predecesor: " + bpt.predecesor(sc.nextInt()));
                    break;
                case 8:
                    System.out.print("Elemento: ");
                    System.out.println("Sucesor: " + bpt.sucesor(sc.nextInt()));
                    break;
                case 9:
                    bpt.destroy();
                    System.out.println("Arbol vaciado.");
                    break;
                case 10: {
                    int[] datos = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
                    for (int x : datos) {
                        System.out.println("Insertando: " + x);
                        bpt.insert(x);
                        System.out.println(bpt);
                    }
                    break;
                }
                case 11: {
                    int[] datos = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
                    for (int x : datos) {
                        System.out.println("Eliminando: " + x);
                        bpt.remove(x);
                        System.out.println(bpt);
                    }
                    break;
                }
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
