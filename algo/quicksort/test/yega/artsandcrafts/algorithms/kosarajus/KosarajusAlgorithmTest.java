package yega.artsandcrafts.algorithms.kosarajus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static yega.artsandcrafts.algorithms.common.SccAdjacencyListBuilderTestData.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import yega.artsandcrafts.algorithms.common.SccAdjacencyListBuilderTestData;
import yega.artsandcrafts.algorithms.common.SccAdjacencyListLoader;


public class KosarajusAlgorithmTest {

	KosarajusAlgorithm algo;
	
	@Before
	public void setUp() {
		algo = new KosarajusAlgorithm(TEST_ADJACENCY_LIST, TEST_REVERS_ADJACENCY_LIST);
	}
	
	@Test
	public void testDfsLoopAlgorithm() {
		algo.dfs(TEST_REVERS_ADJACENCY_LIST, V1);
		assertThat(algo.getExplored(), hasItems(V1,V2,V3));
	}
	
	@Test
	public void verifyThatFinishingTimeFilsProperly() {
		algo.createOrderUsingReversGraph();
		assertThat(algo.getFinishigTime(),is(TEST_FINISHING_TIME));
	}
	
	@Test
	public void verifyThatLeaderCouterWorksProperly() {
		algo.countSccUsingGraph(TEST_FINISHING_TIME);
		assertThat(algo.getLeaderCounters(),is(SccAdjacencyListBuilderTestData.TEST_LEADER_COTUNTERS));
	}
	
	@Test
	public void verifyThatTestGraphIsOk() throws IOException {
		SccAdjacencyListLoader loader = new SccAdjacencyListLoader();
		loader.load(KosarajusAlgorithmTest.class.getResourceAsStream("/scc_test.txt"));
		
		KosarajusAlgorithm a = new KosarajusAlgorithm(loader.getGraph(), loader.getReversGraph());
		
		a.run();
		//3,3,2,0,0
		System.out.println(a.getLeaderCounters());
	}
}
