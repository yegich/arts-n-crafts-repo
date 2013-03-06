package yega.alogorithms.randomizecontraction;

import static java.lang.String.format;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.w3c.dom.CDATASection;

public class RandomizeContracionAlgorithm {

	private static Logger LOG = Logger.getLogger(RandomizeContracionAlgorithm.class);
	
	private List<GraphConnection> connections;
	private Set<Vertex> vertexSet;
	private Set<Set<Vertex>> checkDuplicatesSet;

	public RandomizeContracionAlgorithm() {
		connections = new LinkedList<GraphConnection>();
		vertexSet = new HashSet<Vertex>();
		checkDuplicatesSet = new HashSet<Set<Vertex>>();
	}
	
	public void connectVertices(Vertex beginVertex, Vertex endVertex, Edge edge) {
		Set<Vertex> check = new HashSet<Vertex>();
		check.add(beginVertex); check.add(endVertex);
		if(!checkDuplicatesSet.contains(check)) {
			checkDuplicatesSet.add(check);
			
			vertexSet.add(beginVertex);
			vertexSet.add(endVertex);
			connections.add(new GraphConnection.Builder(beginVertex, endVertex,edge).build());
			LOG.debug(String.format(
					"Edge [%s] connected two vertices [%s : %s]", edge,
					beginVertex, endVertex));
		}
	}
	

	public GraphConnection selectRandomConnection() {
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(connections.size());
		GraphConnection c = connections.get(index);
		LOG.debug(format("Selected connection is : [%s]", c));
		return c;
	}

	public void contractConnetion(GraphConnection connection) {
		Vertex superVertex = new Vertex.Builder().id(
				connection.getBegin().getId() + "_"
						+ connection.getEnd().getId()).build();
		
		Vertex begin = connection.getBegin();
		Vertex end = connection.getEnd();
		
		vertexSet.remove(begin);
		vertexSet.remove(end);
		vertexSet.add(superVertex);
		
		//connections.remove(connection);
		//LOG.debug(format("Removed directly connection : [%s]",connection));
		Iterator<GraphConnection> it = connections.iterator();
		while( it.hasNext()) {
			GraphConnection c = it.next();
//			LOG.debug(format("C1 [%s] == C2 [%s]", c, connection));
			if(c.getBegin().equals(begin) || c.getBegin().equals(end)) {
				c.setBegin(superVertex);
			} 
			
			if(c.getEnd().equals(begin) || c.getEnd().equals(end)) {
				c.setEnd(superVertex);
			}
			
			if(c.getBegin().equals(c.getEnd())) {
				it.remove();
				LOG.debug(format("Removed loop connection : [%s]",c));
			}
		}
		
		LOG.debug(String.format("Left Vertices size [%d]  [%s]",vertexSet.size(), vertexSet));
	}
	
	public Integer findMinCut2() {
		Integer mincut = null;
		while(true) {
			contractConnetion(selectRandomConnection());
			mincut = connections.size();
			
			if(vertexSet.size() == 2) {
				break;
			}
		}
		LOG.info(String.format("The mincut this time is [%d]",mincut));
		return mincut;
	}

}
