package Algorithms;

import Styles.Style;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.AbstractGraph;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.Map;
import java.util.Vector;

public class RandomGenerator {
    // here's our vector with used nodes.
    // it helps when we are checking paths
    // in our graph
    private Vector<Integer> usedNodes = new Vector<>();

    public void Random() {
        AbstractGraph graph = new SingleGraph("Random Graph");
        Generator gen = new org.graphstream.algorithm.generator.RandomGenerator(3);
        Property prop = new Property();
        Style s = new Style();

        prop.setProp();
        graph.setAttribute("ui.stylesheet", s.getStyleSheet());
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < 6; i++) {
            gen.nextEvents();
        }
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }

        for (Edge edge : graph.getEachEdge()) {
            edge.setAttribute("ui.label", edge.getId());
        }

        gen.end();
        graph.display();
    }

    public boolean isNotEmpty(Integer id) {
        for (int i = 0; i < usedNodes.size(); i++) {
            if (id.equals(usedNodes.get(i))) {
                return false;
            }
        }
        return true;
    }

}
