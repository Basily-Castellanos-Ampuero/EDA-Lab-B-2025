import java.util.ArrayList;

public class BPlusNode<E extends Comparable<E>> {
    boolean isLeaf;
    ArrayList<E> keys;
    ArrayList<BPlusNode<E>> children;
    BPlusNode<E> next; // para hojas
    int maxKeys;

    public BPlusNode(boolean isLeaf, int maxKeys) {
        this.isLeaf = isLeaf;
        this.maxKeys = maxKeys;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
        this.next = null;
    }

    public boolean isFull() {
        return keys.size() >= maxKeys;
    }
}

