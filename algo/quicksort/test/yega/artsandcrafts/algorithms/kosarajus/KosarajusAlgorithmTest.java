package yega.artsandcrafts.algorithms.kosarajus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.allOf;
import static yega.artsandcrafts.algorithms.common.SccAdjacencyListBuilderTestData.*;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;


public class KosarajusAlgorithmTest {

	KosarajusAlgorithm algo;
	
	@Before
	public void setUp() {
		algo = new KosarajusAlgorithm(TEST_LIST);
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDfsLoopAlgorithm() {
		
		algo.dfs(TEST_LIST, V1);
		
		assertThat(algo.getExplored(), hasItems(allOf(is(V1), is(V2), is(V3))));
	}
}
