package Laboratorio.Pract08.scr.Propuestos;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    public BNode(int n) {
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1);
        this.count = 0;
        for (int i = 0; i < n - 1; i++) this.keys.add(null);
        for (int i = 0; i < n; i++) this.childs.add(null);
    }

    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E x, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count && x.compareTo(keys.get(pos[0])) > 0)
            pos[0]++;
        return (pos[0] < count && x.compareTo(keys.get(pos[0])) == 0);
    }

    @Override
    public String toString() {
        return keys.subList(0, count).toString();
    }
}

