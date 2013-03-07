package yega.artsandcrafts.algorithms.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static yega.artsandcrafts.algorithms.common.SccAdjacencyListBuilderTestData.*;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.junit.Test;


public class SccAdjacencyListBuilderTest {

	
	@Test
	public void testLoadAdjancyList() throws IOException{
			SccAdjacencyListBuilder builder = new SccAdjacencyListBuilder();
			
			builder.load(IOUtils.toInputStream(TEST_GRAPH));
			
			assertThat(builder.build(), Matchers.is(TEST_LIST));
	}
}
