package yega.artsandcrafts.algorithms.kosarajus;

import static java.lang.String.format;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.apache.log4j.Logger;

import yega.alogorithms.randomizecontraction.Vertex;
import yega.artsandcrafts.algorithms.common.AdjacencyList;

public class KosarajusAlgorithm {

	private static Logger LOG = Logger.getLogger(KosarajusAlgorithm.class);
	
	private AdjacencyList graph;
	private AdjacencyList reversGraph;
	private Set<Vertex> explored;
	private List<Vertex> finishignTime;
	private Vertex leader;
	private Map<Vertex,BigInteger> leaderCounters;
			
	public KosarajusAlgorithm(AdjacencyList adjacency, AdjacencyList reversAdjacency) {
		this.graph = adjacency;
		this.reversGraph = reversAdjacency;
		resetState();
	}
	
	public void run(){
		resetState();
		List<Vertex> order = createOrderUsingReversGraph();
		
		resetState();
		countSccUsingGraph(order);
	}
	
	List<Vertex> createOrderUsingReversGraph() {
		
		for(Vertex lable : reversGraph.getLables()){
			LOG.debug(format("Run dfs for lable [%s]", lable));
			
			if(isNotExplored(lable)) {
				LOG.debug(format("Vertex [%s] is not Explored and set as leader",lable));
				
				dfs(reversGraph, lable);
			} else {
				LOG.debug(format("Lable [%s] is alreadey explored", lable));
			}
		}
		
		
		return new LinkedList<Vertex>(finishignTime);
	}
	
	void countSccUsingGraph(List<Vertex> order) {

		for (Vertex lable : order) {
			LOG.debug(format("Run dfs for lable [%s]", lable));
			leader = lable;
			if (isNotExplored(lable)) {
				LOG.debug(format(
						"Vertex [%s] is not Explored and set as leader", lable));

				dfs(graph, lable);
			} else {
				LOG.debug(format("Lable [%s] is alreadey explored", lable));
			}
		}

	}
	
	private void resetState() {
		explored = new HashSet<Vertex>();
		finishignTime = new LinkedList<Vertex>();
		leaderCounters = new HashMap<Vertex, BigInteger>();
	}

	void dfs(AdjacencyList adjacency, Vertex lable) {
		explored.add(lable);
		LOG.debug(format("Lable [%s] set as explored", lable));
		
		incrementLeadersCounter();
		
		List<Vertex> labledVertices = adjacency.getVertices(lable);
		LOG.debug(format("Lable [%s] has vertices [%s]",lable,labledVertices));
		
		for(Vertex vertex : labledVertices) {
			if(isNotExplored(vertex)) {
				dfs(adjacency, vertex);
			}
		}
		finishignTime.add(0,lable);
	}
	
	private void incrementLeadersCounter() {
		if (leader == null) {
			return;
		}
		BigInteger count = BigInteger.ONE;
		if(leaderCounters.containsKey(leader)) {
			count = count.add(leaderCounters.get(leader));
		}
		leaderCounters.put(leader, count);
		LOG.debug(format("Leader [%s] has [%s] vertices",leader, count));
	}
	
	private boolean isExplored(Vertex vertex) {
		return explored.contains(vertex);
	}
	
	private boolean isNotExplored(Vertex vertex) {
		return !isExplored(vertex);
	}

	public Set<Vertex> getExplored() {
		return explored;
	}

	public List<Vertex> getFinishigTime() {
		return finishignTime;
	}

	public Map<Vertex, BigInteger> getLeaderCounters() {
		return leaderCounters;
	}
}
