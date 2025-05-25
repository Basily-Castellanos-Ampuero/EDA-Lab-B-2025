package Laboratorio.Pract03.Propuestos.Listas;

public class Node<T> {
    T data;
    Node<T> nextNode;
    public Node(T data) {
        this.data = data;
        this.nextNode = null;
    }
    public T getData() {
        return data;
    }
    public Node<T> getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}

