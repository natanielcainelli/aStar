package jogo;

public class CaminhoHeurístico {
	
	private int pai;
	private int vertice_atual;
	private float funcao_heuristica;
	
	public CaminhoHeurístico(int pai, int vertice_atual, float funcao_heuristica) {
		this.pai = pai;
		this.vertice_atual = vertice_atual;
		this.funcao_heuristica = funcao_heuristica;
	}
	public int getPai() {
		return pai;
	}
	public void setPai(int pai) {
		this.pai = pai;
	}
	public int getVertice_atual() {
		return vertice_atual;
	}
	public void setVertice_atual(int vertice_atual) {
		this.vertice_atual = vertice_atual;
	}
	public float getFuncao_heuristica() {
		return funcao_heuristica;
	}
	public void setFuncao_heuristica(float funcao_heuristica) {
		this.funcao_heuristica = funcao_heuristica;
	}
	
}
