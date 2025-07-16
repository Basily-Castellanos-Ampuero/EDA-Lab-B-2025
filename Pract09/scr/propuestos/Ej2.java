import hashAbierto.*;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashOpened<String> tabla = new HashOpened<>(8);

        int opcion;
        do {
            System.out.println("\n===== MENU HASH ABIERTO =====");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Mostrar tabla");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Clave (entero): ");
                    int key = sc.nextInt();
                    System.out.print("Valor (texto): ");
                    sc.nextLine(); // limpiar buffer
                    String val = sc.nextLine();
                    tabla.insert(new Register2<>(key, val));
                    break;

                case 2:
                    System.out.print("Clave a buscar: ");
                    int buscar = sc.nextInt();
                    Register2<String> encontrado = tabla.search(buscar);
                    if (encontrado != null)
                        System.out.println("Encontrado: " + encontrado);
                    else
                        System.out.println("No encontrado.");
                    break;

                case 3:
                    System.out.print("Clave a eliminar: ");
                    int eliminar = sc.nextInt();
                    tabla.delete(eliminar);
                    break;

                case 4:
                    tabla.showTable();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
