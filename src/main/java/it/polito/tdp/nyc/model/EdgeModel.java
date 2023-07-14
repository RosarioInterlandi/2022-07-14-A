package it.polito.tdp.nyc.model;

import java.util.Objects;

public class EdgeModel implements Comparable<EdgeModel>{
	private Vertice v1;
	private Vertice v2;
	private Double peso;
	public EdgeModel(Vertice v1, Vertice v2, double peso) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;
	}
	public Vertice getV1() {
		return v1;
	}
	public Vertice getV2() {
		return v2;
	}
	public double getPeso() {
		return peso;
	}
	@Override
	public int hashCode() {
		return Objects.hash(v1, v2);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EdgeModel other = (EdgeModel) obj;
		return Objects.equals(v1, other.v1) && Objects.equals(v2, other.v2);
	}
	@Override
	public int compareTo(EdgeModel o) {
		// TODO Auto-generated method stub
		return - this.peso.compareTo(o.peso);
	}
	@Override
	public String toString() {
		return "EdgeModel [v1=" + v1 + ", v2=" + v2 + ", peso=" + peso + "]";
	}
	
	
}
