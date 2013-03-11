package yega.artsandcrafts.algorithms.common;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;

import yega.alogorithms.randomizecontraction.Vertex;

public class SccAdjacencyListBuilderTestData {

	public static final Map<Vertex, BigInteger> TEST_LEADER_COTUNTERS = new HashMap<Vertex, BigInteger>();
	public static final List<BigInteger> TEST_RESULT = new LinkedList<BigInteger>();
	public static AdjacencyList TEST_ADJACENCY_LIST = new AdjacencyList();
	public static AdjacencyList TEST_REVERS_ADJACENCY_LIST = new AdjacencyList();
	
	public static Vertex V1 = new Vertex.Builder().id("V1").build();
	public static Vertex V2 = new Vertex.Builder().id("V2").build();
	public static Vertex V3 = new Vertex.Builder().id("V3").build();
	public static Vertex V4 = new Vertex.Builder().id("V4").build();
	
	public static String TEST_GRAPH = "V1 V2\nV2 V3\nV3 V1\nV3 V4";
	public static List<Vertex> TEST_FINISHING_TIME = new LinkedList<Vertex>();
	
	static {
		TEST_ADJACENCY_LIST.add(V1, V2);
		TEST_ADJACENCY_LIST.add(V2, V3);
		TEST_ADJACENCY_LIST.add(V3, V1);
		TEST_ADJACENCY_LIST.add(V3, V4);
		
		TEST_REVERS_ADJACENCY_LIST.add(V2, V1);
		TEST_REVERS_ADJACENCY_LIST.add(V3, V2);
		TEST_REVERS_ADJACENCY_LIST.add(V1, V3);
		TEST_REVERS_ADJACENCY_LIST.add(V4, V3);
		
		TEST_FINISHING_TIME.add(V4);
		TEST_FINISHING_TIME.add(V3);
		TEST_FINISHING_TIME.add(V2);
		TEST_FINISHING_TIME.add(V1);
		
		TEST_LEADER_COTUNTERS.put(V3, new BigInteger("3"));
		TEST_LEADER_COTUNTERS.put(V4, new BigInteger("1"));
		
		TEST_RESULT.add(new BigInteger("3"));
		TEST_RESULT.add(new BigInteger("1"));
		TEST_RESULT.add(new BigInteger("0"));
		TEST_RESULT.add(new BigInteger("0"));
		TEST_RESULT.add(new BigInteger("0"));
		
		
	}
}
