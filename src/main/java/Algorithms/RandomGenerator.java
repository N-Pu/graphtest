package Algorithms;

import Styles.Style;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.AbstractGraph;
import org.graphstream.graph.implementations.SingleGraph;
import scala.util.parsing.combinator.testing.Str;

import java.util.Map;
import java.util.Vector;

public class RandomGenerator {
    // here's our vector with used nodes.
    // it helps when we are checking paths
    // in our graph
    private Vector<String> usedNodes = new Vector<>();
    private AbstractGraph graph = new SingleGraph("Random Graph");
    private Generator gen = new org.graphstream.algorithm.generator.RandomGenerator(3);
    private Property prop = new Property();
    private Style s = new Style();

    public void Random() {

        prop.setProp();
        graph.setAttribute("ui.stylesheet", s.getStyleSheet());
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < 6; i++) {
            gen.nextEvents();
        }
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
//            System.out.println(node.getEachEdge());
//            System.out.println(node.getNeighborNodeIterator());
        }

        for (Edge edge : graph.getEachEdge()) {
            edge.setAttribute("ui.label", edge.getId());
        }

        gen.end();
        graph.display();
    }

    // checker for empty node in graph
    public boolean isNotEmpty(String id) {
        for (int i = 0; i < usedNodes.size(); i++) {
            if (id.equals(usedNodes.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void pathSearcher() {
        int i = 0;
        for (Node node : graph) {
            Object getEE = node.getEachEnteringEdge();

            if (isNotEmpty(node.getId())) {
                usedNodes.set(i, node.getId());
                s.getStyleEdge();
                node.getNeighborNodeIterator();


            }
            i++;

        }


    }
}