package hashAbierto;

public class TestHashOpened {
    public static void main(String[] args) {
        HashOpened<String> tabla = new HashOpened<>(8); // tamaño de tabla = 8

        // Insertar elementos
        tabla.insert(new Register2<>(5, "Pepe"));
        tabla.insert(new Register2<>(21, "Jesús"));
        tabla.insert(new Register2<>(19, "Juan"));
        tabla.insert(new Register2<>(16, "María"));
        tabla.insert(new Register2<>(21, "DUPLICADO")); // clave duplicada

        // Mostrar tabla
        tabla.showTable();

        // Buscar elementos
        System.out.println("\nBúsqueda:");
        int[] buscar = {5, 21};
        for (int clave : buscar) {
            Register2<String> encontrado = tabla.search(clave);
            System.out.println((encontrado != null) ? "Encontrado: " + encontrado : "No encontrado: " + clave);
        }

        // Eliminar elementos
        System.out.println("\nEliminación:");
        tabla.delete(21);  // eliminar Jesús
        tabla.delete(100); // no existe

        // Mostrar tabla final
        tabla.showTable();
    }
}
