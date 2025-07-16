public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed<String> tabla = new HashClosed<>(11);

        // Insertar elementos
        int[] claves = {100, 5, 14, 15, 22, 16, 17, 32, 13, 32, 100};
        for (int clave : claves) {
            tabla.insert(new Register<>(clave, "Valor" + clave));
        }

        // Mostrar tabla
        tabla.showTable();

        // Buscar elementos
        System.out.println("\nBúsqueda:");
        int[] buscar = {32, 200};
        for (int clave : buscar) {
            Register<String> encontrado = tabla.search(clave);
            System.out.println((encontrado != null) ? "Encontrado: " + encontrado : "No encontrado: " + clave);
        }

        // Eliminar elementos
        System.out.println("\nEliminacion:");
        tabla.delete(17);
        tabla.delete(100);

        // Mostrar tabla actualizada
        tabla.showTable();
    }
}
