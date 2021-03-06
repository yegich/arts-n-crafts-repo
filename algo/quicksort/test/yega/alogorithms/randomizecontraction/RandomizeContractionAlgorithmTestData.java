package yega.alogorithms.randomizecontraction;

import java.util.HashSet;
import java.util.Set;


public class RandomizeContractionAlgorithmTestData {
	
	static Vertex V1 = new Vertex.Builder().id("V1").build();
	static Vertex V2 = new Vertex.Builder().id("V2").build();
	static Vertex V3 = new Vertex.Builder().id("V3").build();
	static Vertex V4 = new Vertex.Builder().id("V4").build();
	
	static Edge E1 = new Edge.Builder().id("E1").build();
	static Edge E2 = new Edge.Builder().id("E2").build();
	static Edge E3 = new Edge.Builder().id("E3").build();
	static Edge E4 = new Edge.Builder().id("E4").build();
	static Edge E5 = new Edge.Builder().id("E5").build();
	
	static Set<Edge> STEP1 = new HashSet<Edge>();
	static Set<Edge> STEP2 = new HashSet<Edge>();
	
	static {
		STEP1.add(E1);STEP1.add(E3);STEP1.add(E4);STEP1.add(E5);
		STEP2.add(E4);STEP2.add(E5);
	}
	
	
	static Vertex BV1 = new Vertex.Builder().id("V1").build();
	static Vertex BV2 = new Vertex.Builder().id("V2").build();
	static Vertex BV3 = new Vertex.Builder().id("V3").build();
	static Vertex BV4 = new Vertex.Builder().id("V4").build();
}
