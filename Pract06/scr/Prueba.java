package scr;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Prueba {
    public static void main(String[] args) { //clase unicamente para probar la UI funcione
        System.setProperty("org.graphstream.ui", "swing"); 

        Graph g = new SingleGraph("Test");
        g.addNode("Ahhhh").setAttribute("ui.label", "Nodo A");
        g.display();  
    }
}
