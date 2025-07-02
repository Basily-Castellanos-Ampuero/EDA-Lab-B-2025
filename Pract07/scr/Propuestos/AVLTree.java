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
    //METODOS DEL EJERCICIO 2

    public boolean search(T key) {
    return search(root, key);
    }

    private boolean search(Node<T> node, T key) {
        if (node == null) return false;
        if (key.compareTo(node.data) == 0) return true;
        if (key.compareTo(node.data) < 0)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    public T min() {
        if (root == null) return null;
        Node<T> current = root;
        while (current.left != null)
            current = current.left;
        return current.data;
    }

    public T max() {
        if (root == null) return null;
        Node<T> current = root;
        while (current.right != null)
            current = current.right;
        return current.data;
    }
    public T predecesor(T key) {
        Node<T> current = root;
        Node<T> pred = null;
        while (current != null) {
            if (key.compareTo(current.data) > 0) {
                pred = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return (pred != null) ? pred.data : null;
    }

    public T sucesor(T key) {
        Node<T> current = root;
        Node<T> succ = null;

        while (current != null) {
            if (key.compareTo(current.data) < 0) {
                succ = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return (succ != null) ? succ.data : null;
    }

    public Node<T> balancearIzquierda(Node<T> node) {
        System.out.println("Balanceo a la izquierda llamado manualmente en: " + node.data);
        return rotateLeft(node);
    }

    public Node<T> balancearDerecha(Node<T> node) {
        System.out.println("Balanceo a la derecha llamado manualmente en: " + node.data);
        return rotateRight(node);
    }

    public Node<T> rotacionSimpleIzquierda(Node<T> node) {
        System.out.println("Rotación simple izquierda en: " + node.data);
        return rotateLeft(node);
    }

    public Node<T> rotacionSimpleDerecha(Node<T> node) {
        System.out.println("Rotación simple derecha en: " + node.data);
        return rotateRight(node);
    }

   
}
