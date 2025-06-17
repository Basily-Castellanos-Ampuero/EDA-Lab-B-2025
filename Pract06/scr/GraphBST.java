package scr;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GraphBST<T extends Comparable<T>> extends BST<T> {
    private Graph graph;

    public GraphBST() {
        graph = new SingleGraph("Arbol BST");
        graph.setAutoCreate(true); 
        graph.setStrict(false);     
    }
    public void displayTree() {
        System.setProperty("org.graphstream.ui", "swing"); 

        graph.clear();             
        buildGraph(getRoot());    
        graph.display();           
    }
    private void buildGraph(Node<T> node) {
        if (node == null) return;

        String nodeId = node.data.toString();

        if (graph.getNode(nodeId) == null) {
            graph.addNode(nodeId).setAttribute("ui.label", nodeId); 
        }

        if (node.left != null) {
            String leftId = node.left.data.toString();
            buildGraph(node.left); // Recorre hijo izquierdo
            if (graph.getEdge(nodeId + "-" + leftId) == null)
                graph.addEdge(nodeId + "-" + leftId, nodeId, leftId, true);
        }

        if (node.right != null) {
            String rightId = node.right.data.toString();
            buildGraph(node.right); // Recorre hijo derecho
            if (graph.getEdge(nodeId + "-" + rightId) == null)
                graph.addEdge(nodeId + "-" + rightId, nodeId, rightId, true);
        }
    }
}

