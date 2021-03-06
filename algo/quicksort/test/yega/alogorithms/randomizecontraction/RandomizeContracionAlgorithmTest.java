package yega.alogorithms.randomizecontraction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static yega.alogorithms.randomizecontraction.RandomizeContractionAlgorithmTestData.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class RandomizeContracionAlgorithmTest {

	RandomizeContracionAlgorithm algo;
	
	@Before
	public void setUp() {
		algo = new RandomizeContracionAlgorithm();
	}
	
	@Test
	public void verifyThatEdgeConnectedWihtVertices() {
		algo.connectVertices(V1,V3,E1);
	}
	
//	@Test
//	public void verifyRandomChooseOfEdge() {
//		initAlgo();
//		
//		GraphConnection connection = algo.selectRandomConnection();
//		
//		Assert.assertThat(connection, anyOf(is(E1),is(E2),is(E3),is(E4),is(E5)));
//	}
//	
//	@Test
//	public void verifyThatEdgeProperlyContracted() {
//		initAlgo();
//		assertThat(algo.contractEdge(E2), CoreMatchers.is(STEP1));
//		assertThat(algo.contractEdge(E1), CoreMatchers.is(STEP2));
//	}
	
	@Test
	public void testFindMinCut() {
		initAlgo();
		
		Integer mincut = algo.findMinCut2();
		
		assertThat(mincut, CoreMatchers.anyOf(is(2), is(3)));
	}
	
	@Test
	public void verifyProgarmmingQuestion() throws IOException {
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					RandomizeContracionAlgorithmTest.class
							.getResourceAsStream("/kargerMinCut.txt")));
			List<String []> data = new ArrayList<String[]>();
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				String[] vertices = line.split("\t");
				data.add(vertices);
			}
			
			
			Integer minCut = Integer.MAX_VALUE;
			for(int c = 0; c<500; c++) {
			int e = 0;
			algo = new RandomizeContracionAlgorithm();
			for (String[] vertices : data){
				Vertex beginVertex = new Vertex.Builder().id("v" + vertices[0].trim())
						.build();
				for (int i = 1; i < vertices.length; i++, e++) {
					Integer.valueOf(vertices[i]);
					algo.connectVertices(beginVertex,
							new Vertex.Builder().id("v" + vertices[i].trim()).build(),
							new Edge.Builder().id("e" + e).build());
				}
			}
			
			Integer tempResult = algo.findMinCut2();
			if(tempResult < minCut ) {
				minCut = tempResult;
			}
			
			}
			System.out.println(String.format("Answer is [%d]!!!", minCut));
	}
	
	private void initAlgo() {
		algo.connectVertices(V1, V3, E1);
		algo.connectVertices(V1, V2, E2);
		algo.connectVertices(V2, V3, E3);
		algo.connectVertices(V3, V4, E4);
		algo.connectVertices(V2, V4, E5);
	}
	
}
