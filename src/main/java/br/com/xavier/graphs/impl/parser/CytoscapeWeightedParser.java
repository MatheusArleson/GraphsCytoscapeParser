package br.com.xavier.graphs.impl.parser;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.parser.AbstractCytoscapeParser;

public class CytoscapeWeightedParser<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> extends AbstractCytoscapeParser<N, E>{
	
	//XXX CONSTRUCTOR
	public CytoscapeWeightedParser() {}
	
	//XXX OVERRIDE METHODS
	
	@Override
	protected String generateAddEdgeStr(E edge, String htmlElementContainer, String graphWidgetVar, boolean isGraphDirected, boolean isGraphWeighted) {
		String sourceNodeLbl = edge.getSource().getLabel();
		String targetNodeLbl = edge.getTarget().getLabel();
		
		String edgeStr = "{ data: { source: '" + sourceNodeLbl + "', target: '" + targetNodeLbl + "' #WEIGHT# }, classes: '#EDGE_TYPE#' }";
		
		T edgeWeight = edge.getWeight();
		edgeStr = edgeStr.replace("#WEIGHT#", ", label: '" + edgeWeight.toString() + "'");
		
		String edgeType = isGraphDirected ? "directed" : "undirected";
		edgeStr = edgeStr.replace("#EDGE_TYPE#", edgeType);
		
		String addEdgeStr = graphWidgetVar + ".add(" + edgeStr + ");\n";
		
		return addEdgeStr;
	}
}
