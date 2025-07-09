package Laboratorio.Pract08.scr.Propuestos;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int order;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int order) {
        this.order = order;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E cl) {
        System.out.println("Insertando: " + cl);
        up = false;
        E mediana = push(root, cl);
        if (up) {
            BNode<E> pnew = new BNode<>(order);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, root);
            pnew.childs.set(1, nDes);
            root = pnew;
        }
        System.out.println(this);
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean found = current.searchNode(cl, pos);
            if (found) {
                System.out.println("Clave duplicada: " + cl);
                up = false;
                return null;
            }
            E mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(order - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    putNode(current, mediana, nDes, pos[0]);
                    up = false;
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int mid = (order - 1) / 2;
        nDes = new BNode<>(order);

        for (int i = mid + 1; i < order - 1; i++) {
            nDes.keys.set(i - (mid + 1), current.keys.get(i));
            nDes.childs.set(i - mid, current.childs.get(i + 1));
        }

        nDes.count = (order - 2) - mid;
        current.count = mid;

        if (k <= mid) {
            putNode(current, cl, rd, k);
        } else {
            putNode(nDes, cl, rd, k - mid - 1);
        }

        E mediana = current.keys.get(mid);
        nDes.childs.set(0, current.childs.get(mid + 1));
        return mediana;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Árbol vacío";
        return writeTree(root, 0);
    }

    private String writeTree(BNode<E> node, int level) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder("Nivel " + level + ": " + node + "\n");
        for (int i = 0; i <= node.count; i++) {
            sb.append(writeTree(node.childs.get(i), level + 1));
        }
        return sb.toString();
    }
    //REMOVE MEJORADO

    public void remove(E x) {
        System.out.println("Eliminando: " + x);
        delete(root, x);
        if (root != null && root.count == 0) {
            root = root.childs.get(0); // Actualiza raíz si está vacía
        }
        System.out.println(this);
    }

    private boolean delete(BNode<E> current, E x) {
        if (current == null) return false;

        int[] pos = new int[1];
        boolean found = current.searchNode(x, pos);

        if (found) {
            if (isLeaf(current)) {
                removeFromLeaf(current, pos[0]);
            } else {
                BNode<E> succNode = current.childs.get(pos[0] + 1);
                while (!isLeaf(succNode)) succNode = succNode.childs.get(0);
                E succ = succNode.keys.get(0);
                current.keys.set(pos[0], succ);
                delete(current.childs.get(pos[0] + 1), succ);
            }
        } else {
            if (isLeaf(current)) {
                System.out.println("Clave no encontrada: " + x);
                return false;
            }
            boolean result = delete(current.childs.get(pos[0]), x);
            rebalance(current, pos[0]);
            return result;
        }
        rebalance(current, pos[0]);
        return true;
    }

    private void removeFromLeaf(BNode<E> node, int pos) {
        for (int i = pos; i < node.count - 1; i++) {
            node.keys.set(i, node.keys.get(i + 1));
        }
        node.keys.set(node.count - 1, null);
        node.count--;
    }

    private boolean isLeaf(BNode<E> node) {
        return node.childs.get(0) == null;
    }

    private void rebalance(BNode<E> parent, int idx) {
        BNode<E> child = parent.childs.get(idx);
        if (child == null) return; // Protección contra null
        int minKeys = (order - 1) / 2;

        if (child.count >= minKeys) return;

        // Intenta redistribuir desde hermano izquierdo
        if (idx > 0) {
            BNode<E> leftSibling = parent.childs.get(idx - 1);
            if (leftSibling.count > minKeys) {
                for (int i = child.count; i > 0; i--) {
                    child.keys.set(i, child.keys.get(i - 1));
                    child.childs.set(i + 1, child.childs.get(i));
                }
                child.childs.set(1, child.childs.get(0));
                child.keys.set(0, parent.keys.get(idx - 1));
                child.childs.set(0, leftSibling.childs.get(leftSibling.count));
                parent.keys.set(idx - 1, leftSibling.keys.get(leftSibling.count - 1));
                leftSibling.keys.set(leftSibling.count - 1, null);
                leftSibling.childs.set(leftSibling.count, null);
                leftSibling.count--;
                child.count++;
                return;
            }
        }

        // Intenta redistribuir desde hermano derecho
        if (idx < parent.count) {
            BNode<E> rightSibling = parent.childs.get(idx + 1);
            if (rightSibling.count > minKeys) {
                child.keys.set(child.count, parent.keys.get(idx));
                child.childs.set(child.count + 1, rightSibling.childs.get(0));
                parent.keys.set(idx, rightSibling.keys.get(0));
                for (int i = 0; i < rightSibling.count - 1; i++) {
                    rightSibling.keys.set(i, rightSibling.keys.get(i + 1));
                    rightSibling.childs.set(i, rightSibling.childs.get(i + 1));
                }
                rightSibling.childs.set(rightSibling.count - 1, rightSibling.childs.get(rightSibling.count));
                rightSibling.keys.set(rightSibling.count - 1, null);
                rightSibling.childs.set(rightSibling.count, null);
                rightSibling.count--;
                child.count++;
                return;
            }
        }

        // Fusión con hermano izquierdo
        if (idx > 0) {
            BNode<E> left = parent.childs.get(idx - 1);
            left.keys.set(left.count, parent.keys.get(idx - 1));
            for (int i = 0; i < child.count; i++) {
                left.keys.set(left.count + 1 + i, child.keys.get(i));
                left.childs.set(left.count + 1 + i, child.childs.get(i));
            }
            left.childs.set(left.count + 1 + child.count, child.childs.get(child.count));
            left.count += 1 + child.count;

            for (int i = idx - 1; i < parent.count - 1; i++) {
                parent.keys.set(i, parent.keys.get(i + 1));
                parent.childs.set(i + 1, parent.childs.get(i + 2));
            }
            parent.keys.set(parent.count - 1, null);
            parent.childs.set(parent.count, null);
            parent.count--;
        }
        // Fusión con hermano derecho
        else {
            BNode<E> right = parent.childs.get(idx + 1);
            child.keys.set(child.count, parent.keys.get(idx));
            for (int i = 0; i < right.count; i++) {
                child.keys.set(child.count + 1 + i, right.keys.get(i));
                child.childs.set(child.count + 1 + i, right.childs.get(i));
            }
            child.childs.set(child.count + 1 + right.count, right.childs.get(right.count));
            child.count += 1 + right.count;

            for (int i = idx; i < parent.count - 1; i++) {
                parent.keys.set(i, parent.keys.get(i + 1));
                parent.childs.set(i + 1, parent.childs.get(i + 2));
            }
            parent.keys.set(parent.count - 1, null);
            parent.childs.set(parent.count, null);
            parent.count--;
        }
    }

}

