package Propuestos;

public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T key) {
        root = insert(root, key);
        System.out.println("Insertado: " + key);
    }

    public void remove(T key) {
        root = remove(root, key);
        System.out.println("Eliminado: " + key);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void destroy() {
        root = null;
    }

    // ------------------------- INSERT ---------------------------
    private Node<T> insert(Node<T> node, T key) {
        if (node == null)
            return new Node<>(key);

        if (key.compareTo(node.data) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.data) > 0)
            node.right = insert(node.right, key);
        else
            return node;

        updateHeight(node);
        return balance(node);
    }

    // ------------------------- REMOVE ---------------------------
    private Node<T> remove(Node<T> node, T key) {
        if (node == null) return null;

        if (key.compareTo(node.data) < 0)
            node.left = remove(node.left, key);
        else if (key.compareTo(node.data) > 0)
            node.right = remove(node.right, key);
        else {
            if (node.left == null || node.right == null)
                node = (node.left != null) ? node.left : node.right;
            else {
                Node<T> minLargerNode = getMin(node.right);
                node.data = minLargerNode.data;
                node.right = remove(node.right, minLargerNode.data);
            }
        }

        if (node == null) return null;
        updateHeight(node);
        return balance(node);
    }

    private Node<T> getMin(Node<T> node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // ---------------------- BALANCE & ROTATIONS ------------------------
    private Node<T> balance(Node<T> node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0) {
                System.out.println("Rotación doble Derecha (Izq-Der) en: " + node.data);
                node.left = rotateLeft(node.left);
            }
            System.out.println("Rotación simple a la derecha en: " + node.data);
            return rotateRight(node);
        }

        if (balance < -1) {
            if (getBalance(node.right) > 0) {
                System.out.println("Rotación doble Izquierda (Der-Izq) en: " + node.data);
                node.right = rotateRight(node.right);
            }
            System.out.println("Rotación simple a la izquierda en: " + node.data);
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // -------------------- RECORRIDOS ----------------------
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

   
}
