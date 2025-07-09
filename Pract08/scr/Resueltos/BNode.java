package Laboratorio.Pract08.scr.Resueltos;

import java.util.ArrayList;

public class BNode<E> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    public BNode(int n) {
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n);
        this.count = 0;
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
            this.childs.add(null);
        }
    }

    public boolean nodeFull(int maxKeys) {
        return this.count == maxKeys;
    }

    public boolean nodeEmpty() {
        return this.count == 0;
    }

    // Devuelve true si la clave se encuentra, y posicion en pos0; 
    // si no se encuentra devuelve false y pos[0] indica dónde debe bajar.
    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < count && key.toString().compareTo(keys.get(i).toString()) > 0)
            i++;

        pos[0] = i;
        if (i < count && keys.get(i).equals(key)) return true;
        return false;
    }

    public String toString() {
        String s = "| ";
        for (int i = 0; i < count; i++) {
            s += keys.get(i) + " | ";
        }
        return s;
    }
}
