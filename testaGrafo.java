package jogo;

import java.util.LinkedList;
import java.util.List;

public class testaGrafo {

	public static void main(String[] args) {
		
		int vertices = 9;
		int indice =0;
		
		
		List<CaminhoHeurístico> caminho_reduzido = new LinkedList<CaminhoHeurístico>();
		CaminhoHeurístico[] caminho = new CaminhoHeurístico[vertices];
		Grafo[] grafo = new Grafo[vertices];
		ChamadaDeMetodos cm = new ChamadaDeMetodos(grafo, vertices, 0,0);
		
		int a = 0;
		int d = 1;
		int c = 2;
		int g = 3;
		int f = 4;
		int b = 5;
		int h = 6;
		int k = 7;
		int e = 8;
		
		
		
		
		inicializaGrafoTeste(vertices,grafo);
		cm.insereAresta(10, d, a);
		cm.insereAresta(10, h, a);
		cm.insereAresta(5, b, a);
		cm.insereAresta(5, e, a);
		cm.insereAresta(10, g, a);
		
		cm.insereAresta(15, g, f);
		cm.insereAresta(5, b, f);
		
		cm.insereAresta(10, a, g);
		cm.insereAresta(15, f, g);
		cm.insereAresta(10, d, g);
		cm.insereAresta(10, c, g);
		
		cm.insereAresta(5, a, b);  
		cm.insereAresta(5, f, b);
		cm.insereAresta(20, h, b);
		cm.insereAresta(10, k, b);
		
		cm.insereAresta(10, g, d);
		cm.insereAresta(10, a, d);
		cm.insereAresta(5, c, d);
		cm.insereAresta(10, e, d);
		
		cm.insereAresta(10, a, h);
		cm.insereAresta(20, k, h);
		cm.insereAresta(5, b, h);
		
		cm.insereAresta(5, g, c);
		cm.insereAresta(5, d, c);
		cm.insereAresta(10, e, c);
		
		cm.insereAresta(10, c, e);
		cm.insereAresta(5, d, e);
		cm.insereAresta(5, a, e);
		cm.insereAresta(10, k, e);
		
		cm.insereAresta(10, e, k);
		cm.insereAresta(20, h, k);
		cm.insereAresta(20, b, k);
		
		
		grafo[a].setValor_heuristico(10);
		grafo[b].setValor_heuristico(20);
		grafo[f].setValor_heuristico(10);
		grafo[g].setValor_heuristico(10);
		grafo[d].setValor_heuristico(5);
		grafo[h].setValor_heuristico(0);
		grafo[k].setValor_heuristico(0);
		grafo[e].setValor_heuristico(10);
		grafo[d].setValor_heuristico(5);
		grafo[c].setValor_heuristico(10);
		
		grafo[a].setNome("A");
		grafo[b].setNome("B");
		grafo[f].setNome("F");
		grafo[g].setNome("G");
		grafo[d].setNome("D");
		grafo[h].setNome("H");
		grafo[k].setNome("K");
		grafo[e].setNome("E");
		grafo[d].setNome("D");
		grafo[c].setNome("C");
		
		for (int i = 0; i<vertices;i++) {
			
			System.out.print(" VERTICE | " +grafo[i].getVertice() + " | NOME " + grafo[i].getNome()+ " | VALOR HEURISTICO "+ grafo[i].getValor_heuristico() + " --->");
			for (Aresta aresta : grafo[i].getAresta()) {
				
				System.out.print(" VERTICE | "+aresta.getVertice() + " | " +grafo[aresta.getVertice()].getNome() + " | CUSTO "+aresta.getCusto());
			}
			System.out.println();
		}
		
		
		indice = cm.aStar(h, d, caminho);

		System.out.println("\n\n\n\n");
		for(int i =0; i< caminho.length;i++) {
			System.out.println(" VERTICE | " + caminho[i].getVertice_atual() + " | PAI | " + caminho[i].getPai() + " | FUNÇÃO HEURÍSTICA | "+ caminho[i].getFuncao_heuristica());
		}
		
		System.out.println("\n\n\n\n");
		
		while(indice !=  -1) {
			caminho_reduzido.add(0,caminho[indice]); 
			indice = caminho[indice].getPai();
		}
		
		for(int i =0; i< caminho_reduzido.size();i++) {
			System.out.println(" VERTICE | " + caminho_reduzido.get(i).getVertice_atual() + " | PAI | " + caminho_reduzido.get(i).getPai() + " | FUNÇÃO HEURÍSTICA | "+ caminho_reduzido.get(i).getFuncao_heuristica());
		}
		
	}

	
	public static void inicializaGrafoTeste(int vertices, Grafo[] grafo) {

			for (int i = 0; i < vertices; i++) {
				grafo[i] = new Grafo(i, new LinkedList<Aresta>(), i, -1, 0, 0);
			}
	}
}
