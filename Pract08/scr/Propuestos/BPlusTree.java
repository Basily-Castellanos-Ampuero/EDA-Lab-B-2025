import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class BPlusTree<E extends Comparable<E>> {
    private BPlusNode<E> root;
    private int order;

    public BPlusTree(int order) {
        this.order = order;
        this.root = new BPlusNode<>(true, order - 1); // hojas: max claves = order - 1
    }

    public void insert(E key) {
        BPlusNode<E> node = root;
        if (node.isFull()) {
            // Dividir raíz
            BPlusNode<E> newRoot = new BPlusNode<>(false, order - 1);
            newRoot.children.add(root);
            splitChild(newRoot, 0, root);
            root = newRoot;
        }
        insertNonFull(root, key);
    }

    private void insertNonFull(BPlusNode<E> node, E key) {
        if (node.isLeaf) {
            int i = 0;
            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) i++;
            node.keys.add(i, key);
        } else {
            int i = 0;
            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) i++;
            BPlusNode<E> child = node.children.get(i);
            if (child.isFull()) {
                splitChild(node, i, child);
                if (key.compareTo(node.keys.get(i)) > 0) i++;
            }
            insertNonFull(node.children.get(i), key);
        }
    }

    private void splitChild(BPlusNode<E> parent, int index, BPlusNode<E> nodeToSplit) {
        int midIndex = order / 2;
        BPlusNode<E> newNode = new BPlusNode<>(nodeToSplit.isLeaf, order - 1);

        // Transferar claves y hijos
        newNode.keys.addAll(nodeToSplit.keys.subList(midIndex, nodeToSplit.keys.size()));
        nodeToSplit.keys.subList(midIndex, nodeToSplit.keys.size()).clear();

        if (!nodeToSplit.isLeaf) {
            newNode.children.addAll(nodeToSplit.children.subList(midIndex + 1, nodeToSplit.children.size()));
            nodeToSplit.children.subList(midIndex + 1, nodeToSplit.children.size()).clear();
        } else {
            newNode.next = nodeToSplit.next;
            nodeToSplit.next = newNode;
        }

        parent.children.add(index + 1, newNode);
        parent.keys.add(index, newNode.keys.get(0)); // en B+ se duplica clave
    }

    public void display() {
        BPlusNode<E> node = root;
        while (!node.isLeaf) {
            node = node.children.get(0);
        }

        System.out.print("Hojas (en orden):\n");
        while (node != null) {
            System.out.print(node.keys + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    public boolean search(E key) {
        BPlusNode<E> node = root;
        while (!node.isLeaf) {
            int i = 0;
            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) >= 0) i++;
            node = node.children.get(i);
        }

        for (E k : node.keys) {
            if (k.equals(key)) return true;
        }
        return false;
    }
    public void remove(E key) {
        if (root == null) return;
        removeRec(root, key);
        if (!root.isLeaf && root.keys.size() == 0) {
            root = root.children.get(0);
        }
    }

    private void removeRec(BPlusNode<E> node, E key) {
        if (node.isLeaf) {
            node.keys.remove(key);
            return;
        }
    
        int i = 0;
        while (i < node.keys.size() && key.compareTo(node.keys.get(i)) >= 0) i++;
    
        if (i >= node.children.size()) {
            i = node.children.size() - 1;
        }
    
        BPlusNode<E> child = node.children.get(i);
        removeRec(child, key);
    
        if (child.keys.size() < (order - 1) / 2) {
            rebalance(node, i);
        }
    }

private void rebalance(BPlusNode<E> parent, int index) {
    BPlusNode<E> node = parent.children.get(index);
    int minKeys = (order - 1) / 2;

    // Intentar tomar prestado del hermano izquierdo
    if (index > 0 && index - 1 < parent.children.size()) {
        BPlusNode<E> left = parent.children.get(index - 1);
        if (left.keys.size() > minKeys) {
            node.keys.add(0, left.keys.remove(left.keys.size() - 1));
            parent.keys.set(index - 1, node.keys.get(0));
            return;
        }
    }

    // Intentar tomar prestado del hermano derecho
    if (index < parent.children.size() - 1) {
        BPlusNode<E> right = parent.children.get(index + 1);
        if (right.keys.size() > minKeys) {
            node.keys.add(right.keys.remove(0));
            parent.keys.set(index, right.keys.get(0));
            return;
        }
    }

    // Fusionar con hermano izquierdo si posible
    if (index > 0 && index - 1 < parent.children.size()) {
        BPlusNode<E> left = parent.children.get(index - 1);
        left.keys.addAll(node.keys);
        if (node.isLeaf) left.next = node.next;

        parent.children.remove(index);
        if (index - 1 < parent.keys.size()) {
            parent.keys.remove(index - 1);
        } else if (!parent.keys.isEmpty()) {
            parent.keys.remove(parent.keys.size() - 1); // seguridad
        }
    }
    // Fusionar con hermano derecho
    else if (index < parent.children.size() - 1) {
        BPlusNode<E> right = parent.children.get(index + 1);
        node.keys.addAll(right.keys);
        if (node.isLeaf) node.next = right.next;

        if (index + 1 < parent.children.size()) {
            parent.children.remove(index + 1);
        }
        if (index < parent.keys.size()) {
            parent.keys.remove(index);
        }
    }
}

    public void destroy() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null || root.keys.isEmpty();
    }
    public E min() {
        if (isEmpty()) return null;
        BPlusNode<E> node = root;
        while (!node.isLeaf) node = node.children.get(0);
        return node.keys.get(0);
    }

    public E max() {
        if (isEmpty()) return null;
        BPlusNode<E> node = root;
        while (!node.isLeaf) node = node.children.get(node.children.size() - 1);
        return node.keys.get(node.keys.size() - 1);
    }
    public E predecesor(E key) {
        BPlusNode<E> node = root;
        E pred = null;
        while (!node.isLeaf) {
            int i = 0;
            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) >= 0) {
                pred = node.keys.get(i);
                i++;
            }
            node = node.children.get(i);
        }

        for (int i = 0; i < node.keys.size(); i++) {
            if (node.keys.get(i).compareTo(key) >= 0)
                return i == 0 && pred != null ? pred : node.keys.get(i - 1);
        }
        return node.keys.get(node.keys.size() - 1);
    }

    public E sucesor(E key) {
        BPlusNode<E> node = root;
        while (!node.isLeaf) {
            int i = 0;
            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) >= 0) i++;
            node = node.children.get(i);
        }

        for (int i = 0; i < node.keys.size(); i++) {
            if (node.keys.get(i).compareTo(key) > 0)
                return node.keys.get(i);
        }
        return node.next != null ? node.next.keys.get(0) : null;
    }
    @Override
    public String toString() {
        return writeTree(root, 0);
    }
    
    private String writeTree(BPlusNode<E> node, int level) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder("Nivel " + level + ": " + node.keys + "\n");
        if (!node.isLeaf) {
            for (BPlusNode<E> child : node.children) {
                sb.append(writeTree(child, level + 1));
            }
        }
        return sb.toString();
    }
    public void visualizar() {
        if (root == null) {
            System.out.println("Arbol vacio");
            return;
        }

        Graph graph = new SingleGraph("Arbol B+");
        graph.setStrict(false);
        graph.setAutoCreate(true);
        System.setProperty("org.graphstream.ui", "swing");

        // Estilo CSS
        graph.setAttribute("ui.stylesheet", """
            node {
                shape: box;
                fill-color: lightblue;
                stroke-color: black;
                size-mode: fit;
                text-size: 14px;
                text-alignment: center;
                padding: 5px;
            }
            edge {
                fill-color: gray;
            }
        """);

        graficarNodo(graph, root, "R");

        graph.display();
    }

    private void graficarNodo(Graph graph, BPlusNode<E> node, String id) {
        // Etiqueta del nodo: claves
        String label = node.keys.toString();
        graph.addNode(id).setAttribute("ui.label", label);

        if (!node.isLeaf) {
            for (int i = 0; i < node.children.size(); i++) {
                String childId = id + "_" + i;
                graficarNodo(graph, node.children.get(i), childId);
                graph.addEdge(id + "-" + childId, id, childId);
            }
        }
    }

}
