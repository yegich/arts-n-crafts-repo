package yega.artsandcrafts.algorithms.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

import yega.alogorithms.randomizecontraction.Vertex;

public class SccAdjacencyListBuilder {

	private AdjacencyList adjacencyList;
	
	public SccAdjacencyListBuilder() {
		adjacencyList = new AdjacencyList();
	}
	
	public SccAdjacencyListBuilder load(InputStream inputStream) throws IOException {
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
	
	public SccAdjacencyListBuilder add(Vertex lable, Vertex vertex) {
		adjacencyList.add(lable, vertex);
		return this;
	}
	
	public AdjacencyList build(){
		return adjacencyList;
	}
}
