package yega.artsandcrafts.algorithms.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static yega.artsandcrafts.algorithms.common.SccAdjacencyListBuilderTestData.*;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.junit.Test;


public class SccAdjacencyListLoaderTest {

	
	@Test
	public void testLoadAdjancyList() throws IOException{
			SccAdjacencyListLoader builder = new SccAdjacencyListLoader();
			
			builder.load(IOUtils.toInputStream(TEST_GRAPH));
			
			assertThat(builder.getGraph(), Matchers.is(TEST_ADJACENCY_LIST));
			assertThat(builder.getReversGraph(), Matchers.is(TEST_REVERS_ADJACENCY_LIST));
	}
}
