package yega.artsandcrafts.algorithms.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

import yega.alogorithms.randomizecontraction.Vertex;

public class AdjacencyList {

	private Map<Vertex, List<Vertex>> adjacency;

	public AdjacencyList() {
		adjacency = new HashMap<Vertex, List<Vertex>>();
	}
	
	public void add(Vertex lable, Vertex vertex) {
		List<Vertex> list = adjacency.get(lable);
		
		if(list == null) {
			list = new LinkedList<Vertex>();
		}
		
		list.add(vertex);
		
		adjacency.put(lable, list);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adjacency == null) ? 0 : adjacency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdjacencyList other = (AdjacencyList) obj;
		if (adjacency == null) {
			if (other.adjacency != null)
				return false;
		} else if (!adjacency.equals(other.adjacency))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdjacencyList [adjacency=" + adjacency + "]";
	}

	@SuppressWarnings("unchecked")
	public List<Vertex> getVertices(Vertex lable) {
		List<Vertex> vertices = adjacency.get(lable);
		if(vertices == null) {
			return ListUtils.EMPTY_LIST;
		}
		return vertices;
	}

	public Set<Vertex> vertices() {
		return adjacency.keySet();
	}

	public Set<Vertex> getLables() {
		return adjacency.keySet();
	}
	
}
