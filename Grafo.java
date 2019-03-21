package jogo;

import java.util.List;

public class Grafo {
	
	private int vertice;
	private List<Aresta> aresta;
	private Object nome;
	private float valor_heuristico;
	private int linha;
	private int coluna;

	public Grafo(int vertice, List<Aresta> aresta, Object nome, float valor_heuristico, int linha, int coluna) {
		this.vertice = vertice;
		this.aresta = aresta;
		this.nome = nome;
		this.valor_heuristico = valor_heuristico;
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getVertice() {
		return vertice;
	}

	public void setVertice(int vertice) {
		this.vertice = vertice;
	}
	public List<Aresta> getAresta() {
		return aresta;
	}

	public void setAresta(List<Aresta> aresta) {
		this.aresta = aresta;
	}

	public Object getNome() {
		return nome;
	}

	public void setNome(Object nome) {
		this.nome = nome;
	}

	public float getValor_heuristico() {
		return valor_heuristico;
	}

	public void setValor_heuristico(float valor_heuristico) {
		this.valor_heuristico = valor_heuristico;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getGrau() {
		return aresta.size();
	} 
	
}
