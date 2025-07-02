package Propuestos;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;
    int height;

    public Node(T data) {
        this.data = data;
        this.height = 1;
    }
}

