package br.com.xavier.graphs.impl.parser;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.parser.AbstractCytoscapeParser;

public class CytoscapeUnweightedParser<N extends AbstractNode, E extends AbstractEdge<N>> extends AbstractCytoscapeParser<N, E>{
	
	//XXX CONSTRUCTOR
	public CytoscapeUnweightedParser() {}
	
	//XXX OVERRIDE METHODS
	
	@Override
	protected String generateAddEdgeStr(E edge, String htmlElementContainer, String graphWidgetVar, boolean isGraphDirected, boolean isGraphWeighted) {
		String sourceNodeLbl = edge.getSource().getLabel();
		String targetNodeLbl = edge.getTarget().getLabel();
		
		String edgeStr = "{ data: { source: '" + sourceNodeLbl + "', target: '" + targetNodeLbl + "' }, classes: '#EDGE_TYPE#' }";
		
		String edgeType = isGraphDirected ? "directed" : "undirected";
		edgeStr = edgeStr.replace("#EDGE_TYPE#", edgeType);
		
		String addEdgeStr = graphWidgetVar + "cy.add(" + edgeStr + ");\n";
		
		return addEdgeStr;
	}

}
