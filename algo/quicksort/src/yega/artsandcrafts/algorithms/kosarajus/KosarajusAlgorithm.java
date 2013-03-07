package yega.artsandcrafts.algorithms.kosarajus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import yega.alogorithms.randomizecontraction.Vertex;
import yega.artsandcrafts.algorithms.common.AdjacencyList;

public class KosarajusAlgorithm {

	private AdjacencyList graph;
	private Set<Vertex> explored;
	
	public KosarajusAlgorithm(AdjacencyList adjacency) {
		this.graph = adjacency;
		explored = new HashSet<Vertex>();
	}
	
	void dfs(AdjacencyList adjacency, Vertex lable) {
		explored.add(lable);
		
		List<Vertex> labledVertices = graph.getVertices(lable);
		
		for(Vertex vertex : labledVertices) {
			if(!explored.contains(vertex)) {
				dfs(adjacency, vertex);
			}
		}
	}

	public Set<Vertex> getExplored() {
		return explored;
	}
}
