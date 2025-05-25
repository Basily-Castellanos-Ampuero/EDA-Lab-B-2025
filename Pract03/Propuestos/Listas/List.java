package Laboratorio.Pract03.Propuestos.Listas;

public class List<T> {
    private Node<T> root;
    private int size;

    public List() {
        root = null;
        size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> current = root;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
        }
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.nextNode = root;
            root = newNode;
        } else {
            Node<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.nextNode;
            }
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        return current.data;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> removed;
        if (index == 0) {
            removed = root;
            root = root.nextNode;
        } else {
            Node<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.nextNode;
            }
            removed = current.nextNode;
            current.nextNode = removed.nextNode;
        }
        size--;
        return removed.data;
    }

    public boolean remove(Object o) {
        if (root == null) return false;

        if (root.data.equals(o)) {
            root = root.nextNode;
            size--;
            return true;
        }

        Node<T> current = root;
        while (current.nextNode != null && !current.nextNode.data.equals(o)) {
            current = current.nextNode;
        }

        if (current.nextNode == null) return false;

        current.nextNode = current.nextNode.nextNode;
        size--;
        return true;
    }

    public boolean contains(Object o) {
        Node<T> current = root;
        while (current != null) {
            if (current.data.equals(o)) return true;
            current = current.nextNode;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int indexOf(Object o) {
        Node<T> current = root;
        int index = 0;
        while (current != null) {
            if (current.data.equals(o)) return index;
            current = current.nextNode;
            index++;
        }
        return -1;
    }

    public void printList() {
        Node<T> current = root;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.nextNode;
        }
        System.out.println("null");
    }
}
