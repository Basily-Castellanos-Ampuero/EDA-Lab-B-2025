package Resueltos;

public class AVLTree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T key) {
        root = insert(root, key);
    }

    private Node<T> insert(Node<T> node, T key) {
        if (node == null)
            return new Node<>(key);

        if (key.compareTo(node.data) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.data) > 0)
            node.right = insert(node.right, key);
        else
            return node; // No duplicates

        node.height = 1 + Math.max(height(node.left), height(node.right));

        return balance(node, key);
    }

    private int height(Node<T> node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(Node<T> node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private Node<T> balance(Node<T> node, T key) {
        int balance = getBalance(node);

        // Izquierda Izquierda
        if (balance > 1 && key.compareTo(node.left.data) < 0)
            return rotateRight(node);

        // Derecha Derecha
        if (balance < -1 && key.compareTo(node.right.data) > 0)
            return rotateLeft(node);

        // Izquierda Derecha
        if (balance > 1 && key.compareTo(node.left.data) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Derecha Izquierda
        if (balance < -1 && key.compareTo(node.right.data) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Recorridos
    public void inOrder() {
        System.out.print("InOrder: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder() {
        System.out.print("PreOrder: ");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        System.out.print("PostOrder: ");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    public void destroy() {
    root = null;
    System.out.println("Árbol eliminado correctamente -metodo adicional-");
}
}

