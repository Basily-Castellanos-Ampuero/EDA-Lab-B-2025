package Laboratorio.Pract03.Propuestos.Listas;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new List<>();

        System.out.println("La lista está vacia?: " + lista.isEmpty());

        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");
        lista.add(1, "Insertado en indice 1");

        lista.printList();

        System.out.println("Elemento en indice 2: " + lista.get(2));

        lista.remove("Dos");
        lista.printList();

        lista.remove(1);
        lista.printList();

        System.out.println("Contiene 'Tres'?: " + lista.contains("Tres"));
        System.out.println("Indice de 'Tres': " + lista.indexOf("Tres"));

        lista.clear();
        System.out.println("Lista despues de limpiar:");
        lista.printList();
    }
}

