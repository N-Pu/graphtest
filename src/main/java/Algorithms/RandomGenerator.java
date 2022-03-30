package Algorithms;

import Styles.Style;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.AbstractGraph;
import org.graphstream.graph.implementations.SingleGraph;

public class RandomGenerator {
    public void Random() {
        AbstractGraph graph = new SingleGraph("Random Graph");
        Generator gen = new org.graphstream.algorithm.generator.RandomGenerator(2);
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

        for ( Edge edge: graph.getEachEdge()){
            edge.setAttribute("ui.label", edge.getId());
        }

        gen.end();
        graph.display();
    }


}
