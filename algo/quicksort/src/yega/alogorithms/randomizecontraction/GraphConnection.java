package yega.alogorithms.randomizecontraction;

public class GraphConnection {

	private Vertex begin;
	private Vertex end;
	private Edge edge;
	
	public Vertex getBegin() {
		return begin;
	}
	public void setBegin(Vertex begin) {
		this.begin = begin;
	}
	public Vertex getEnd() {
		return end;
	}
	public void setEnd(Vertex end) {
		this.end = end;
	}
	public Edge getEdge() {
		return edge;
	}
	public void setEdge(Edge edge) {
		this.edge = edge;
	}
	
	
	public static class Builder {
		private GraphConnection connection;
		
		public Builder(Vertex v1, Vertex v2, Edge e) {
			connection = new GraphConnection();
			connection.begin = v1;
			connection.end = v2;
			connection.edge = e;
		}
		public GraphConnection build(){
			return connection;
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin == null) ? 0 : begin.hashCode());
		result = prime * result + ((edge == null) ? 0 : edge.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphConnection other = (GraphConnection) obj;
		if (begin == null) {
			if (other.begin != null)
				return false;
		} else if (!begin.equals(other.begin))
			return false;
		if (edge == null) {
			if (other.edge != null)
				return false;
		} else if (!edge.equals(other.edge))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GraphConnection [begin=" + begin + ", end=" + end + ", edge="
				+ edge + "]";
	}
	
		
}
