package br.com.xavier.graphs.abstractions.parser;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.parser.AbstractGraphParser;

public abstract class AbstractCytoscapeParser<N extends AbstractNode, E extends AbstractEdge<N>> extends AbstractGraphParser<N,E>{

	//XXX CONSTRUCTOR
	public AbstractCytoscapeParser() {}

	@Override
	protected String createNewGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		StringBuffer sb = new StringBuffer();
		
		//destroy old graph
		sb.append(graphWidgetVar + ".destroy();\n");
		
		//call new one
		sb.append("initCy();\n");
		
		return sb.toString();
	}
	
	@Override
	protected String onDirectedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		return "";
	}
	
	@Override
	protected String onWeightedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		return "";
	}

	@Override
	protected String onLoopsAllowedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		return "";
	}

	@Override
	protected String onMultipleEdgesAllowedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		return "";
	}
	
	@Override
	protected String generateAddNodeStr(N node, String htmlElementContainer, String graphWidgetVar) {
		String nodeStr = "{ data: { id: '" + node.getLabel() + "' } }";
		return graphWidgetVar + ".add(" + nodeStr + ");\n";
	}
	
	@Override
	protected String generateHeader(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		return "";
	}
	
	@Override
	protected String generateFooter(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("redraw();\n"); 
		
		return sb.toString();
	}
}
