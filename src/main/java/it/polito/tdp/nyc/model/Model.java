package it.polito.tdp.nyc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	private SimpleWeightedGraph<Vertice, DefaultWeightedEdge> grafo;
	private List<Vertice> allVertici;
	private NYCDao dao;

	public Model() {
		this.dao = new NYCDao();

	}

	public void BuildGraph(String borgo) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		this.allVertici = this.dao.getVertici(borgo);
		Graphs.addAllVertices(this.grafo, allVertici);

		for (Vertice n1 : allVertici) {
			for (Vertice n2 : allVertici) {
				
					if (n1.getNTACode().compareTo(n2.getNTACode()) < 0) {
						Set<String> unione = new HashSet<>(n1.getSSID());
						unione.addAll(n2.getSSID());
						Graphs.addEdge(this.grafo, n1, n2, unione.size());
						 
				}
			}
		}

		System.out.println(this.grafo.vertexSet().size() + "-" + this.grafo.edgeSet().size());
	}

	public List<String> allBorghi() {
		return this.dao.allBorough();
	}

	public List<EdgeModel> analisiArchi() {
		List<EdgeModel> result = new ArrayList<>();
		double peso_medio = 0.0;
		int counterArchiMaggiori = 0;
		for (DefaultWeightedEdge d : this.grafo.edgeSet()) {
			peso_medio += this.grafo.getEdgeWeight(d);
		}
		peso_medio = peso_medio / this.grafo.edgeSet().size();

		for (DefaultWeightedEdge d : this.grafo.edgeSet()) {
			if (this.grafo.getEdgeWeight(d) > peso_medio) {
				EdgeModel edge = new EdgeModel(this.grafo.getEdgeSource(d), this.grafo.getEdgeTarget(d),
						 this.grafo.getEdgeWeight(d));
				result.add(edge);
				counterArchiMaggiori++;
			}
		}
		System.out.println("\n" + counterArchiMaggiori + "-" + peso_medio);
		Collections.sort(result);
		return result;

	}
}
