import java.util.Scanner;

import hashAbierto.HashOpened;
import hashAbierto.Register2;

public class Ej4 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashOpened<String> tabla = new HashOpened<>(8); // tamaño de tabla

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
                    int clave = sc.nextInt();
                    System.out.print("Valor (texto): ");
                    sc.nextLine(); // limpiar buffer
                    String valor = sc.nextLine();
                    tabla.insert(new Register2<>(clave, valor));
                    break;

                case 2:
                    System.out.print("Clave a buscar: ");
                    int buscar = sc.nextInt();
                    Register2<String> resultado = tabla.search(buscar);
                    if (resultado != null)
                        System.out.println("Encontrado: " + resultado);
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
