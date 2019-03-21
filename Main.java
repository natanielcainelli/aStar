package jogo;

import java.awt.Color;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {

		int linha = 40, coluna = 40, size = 30, VERTICES = (linha * coluna);
		Integer[] formigas = new Integer[4];
		formigas[0] = 19 * linha + 20;
		formigas[1] = 21 * linha + 20;
		formigas[2] = 20 * linha + 19;
		formigas[3] = 20 * linha + 21;
		Integer[] comida_pos = null;
		int qtd_comida = 4;
		
		CaminhoHeurístico[] caminho = new CaminhoHeurístico[VERTICES];
		Grafo[] grafo = new Grafo[VERTICES];
		ChamadaDeMetodos cm = new ChamadaDeMetodos(grafo, VERTICES, linha, coluna);

		cm.inicializaGrafo();
		/* AQUI  MOSTRA OS VERTICES */
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				System.out.print(String.format("%4d", grafo[i * linha + j].getVertice()) + " ");
			}
			System.out.println();
		}

		cm.inicializaAresta();
		/* AQUI MOSTRA O CUSTO */
		for (Grafo g : grafo) {
			System.out.print("VERTICE " + g.getVertice() + " ");
			if (!g.getAresta().isEmpty()) {
				for (Aresta a : g.getAresta()) {
					System.out.print("|VERTICE " + a.getVertice() + " Custo " + a.getCusto() + "| ");
				}
			}

			System.out.println();
		}
		/* AQUI MOSTRA O GRAU*/
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				System.out.print(String.format("%2d", grafo[i * linha + j].getGrau()));
			}
			System.out.println();

		}

		System.out.println("\n\n\n\n");
		cm.inicializaMapa();
		comida_pos = cm.inicializaComida(qtd_comida);
		cm.geraValorHeuristico(comida_pos, qtd_comida);

		/* AQUI MOSTRA O VALOR HEURISTICO */
		System.out.println(" \n\n\n\n");
		DecimalFormat df = new DecimalFormat("#00.00"); 
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {

				System.out.print(" " + df.format(grafo[i * linha + j].getValor_heuristico()));
			}
			System.out.println();
		}
		System.out.println(" \n\n\n\n");
		
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				if (grafo[i * linha + j].getNome().equals(Color.RED)) {
					System.out.print("R ");
				} else if (grafo[i * linha + j].getNome().equals(Color.BLACK)) {
					System.out.print("B ");
				} else if (grafo[i * linha + j].getNome().equals(Color.GREEN)) {
					System.out.print("G ");
				} else if (grafo[i * linha + j].getNome().equals(Color.WHITE)) {
					System.out.print("W ");
				} else if (grafo[i * linha + j].getNome().equals(Color.ORANGE)) {
					System.out.print("O ");
				} else if (grafo[i * linha + j].getNome().equals(Color.LIGHT_GRAY)) {
					System.out.print("L ");
				} else if (grafo[i * linha + j].getNome().equals(Color.GRAY)) {
					System.out.print("C ");
				} else if (grafo[i * linha + j].getNome().equals(Color.PINK)) {
					System.out.print("P ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
			

			
		}
	}
}
