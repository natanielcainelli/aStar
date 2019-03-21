package jogo;

public class Aresta {

	private int vertice;
	private float custo;

	
	public Aresta(int vertice, float custo) {
		this.vertice = vertice;
		this.custo = custo;
	}
	public int getVertice() {
		return vertice;
	}
	public void setVertice(int vertice) {
		this.vertice = vertice;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
	
}
