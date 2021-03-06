package yega.alogorithms.randomizecontraction;

public final class Vertex {

	String id;
	
	public String getId() {
		return id;
	}

	public static class Builder{
		private Vertex vertex;
		
		public Builder(){
			vertex = new Vertex();
		}
		
		public Vertex build() {
			return vertex;
		}
		
		public Builder id(String id) {
			vertex.id = id;
			return this;
		}
	}
	
	@Override
	public String toString() {
		return "Vertex [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Vertex other = (Vertex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
