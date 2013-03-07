package yega.artsandcrafts.algorithms.common;

import yega.alogorithms.randomizecontraction.Vertex;

public class SccAdjacencyListBuilderTestData {

	public static AdjacencyList TEST_LIST = new AdjacencyList();
	
	public static Vertex V1 = new Vertex.Builder().id("V1").build();
	public static Vertex V2 = new Vertex.Builder().id("V2").build();
	public static Vertex V3 = new Vertex.Builder().id("V3").build();
	
	public static String TEST_GRAPH = "V1 V2\nV1 V3";
	static {
		TEST_LIST.add(V1, V2);
		TEST_LIST.add(V1, V3);
	}
}
