package yega.artsandcrafts.algorithms.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

import yega.alogorithms.randomizecontraction.Vertex;

public class SccAdjacencyListLoader {

	private AdjacencyList adjacencyList;
	private AdjacencyList reversAdjacencyList;
	
	public SccAdjacencyListLoader() {
		adjacencyList = new AdjacencyList();
		reversAdjacencyList = new AdjacencyList();
	}
	
	public SccAdjacencyListLoader load(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		while(true){
			String line = reader.readLine();
			if(StringUtils.isEmpty(line)) {
				break;
			}
			
			String[] vertices = line.split(" ");
			add(new Vertex.Builder().id(vertices[0].trim()).build(),
					new Vertex.Builder().id(vertices[1].trim()).build());
		}
		return this;
	}
	
	public SccAdjacencyListLoader add(Vertex lable, Vertex vertex) {
		adjacencyList.add(lable, vertex);
		reversAdjacencyList.add(vertex, lable);
		return this;
	}
	
	public AdjacencyList getGraph(){
		return adjacencyList;
	}
	
	public AdjacencyList getReversGraph(){
		return reversAdjacencyList;
	}
}
