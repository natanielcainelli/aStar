package jogo;

import java.awt.Color;
import java.util.*;

public class ChamadaDeMetodos {

	private Grafo[] grafo = null;
	private int VERTICE = 0;
	private int linha = 0;
	private int coluna = 0;

	public ChamadaDeMetodos(Grafo grafo[], int VERTICE, int linha, int coluna) {
		this.grafo = grafo;
		this.VERTICE = VERTICE;
		this.linha = linha;
		this.coluna = coluna;
	}

	public void inicializaGrafo() {
		int i = 0, j = 0, k = 0;

		for (i = 0; i < linha; i++) {
			for (j = 0; j < coluna; j++, k++) {
				grafo[k] = new Grafo(k, new LinkedList<Aresta>(), k, -1, i, j);
			}
		}
	}

	private void insAresta(float custo, int destino, int origem) {
		
		
		List<Aresta> aresta = grafo[origem].getAresta();
		int i = 0;
		
		//compara lista de arestas é vazia, se for ele insere na primeira posição
		if (aresta.isEmpty()) {
			aresta.add(new Aresta(destino, custo));
		} else {
			if (destino <= aresta.get(0).getVertice()) {
				//compara se o vertice que vai ser inserido é menor que o primeiro se for ele vai inserir no começo
				if (destino != aresta.get(0).getVertice()) {
					aresta.add(0, new Aresta(destino, custo));
				}
			} else if (destino >= aresta.get(aresta.size() - 1).getVertice()) {
				//compara se o vertice que vai ser inserido é maior que o ultimo se for ele vai inserir no fim
				if (destino != aresta.get(aresta.size() - 1).getVertice()) {
					aresta.add(new Aresta(destino, custo));
				}
			} else {
				//nunca vai entrar nesse caso é apenas para evitar o bug de inserção no meio e no método de inserção ordenada
				for (i = 0; i < aresta.size() && aresta.get(i).getVertice() <= destino; i++)
					;

				if (aresta.get(i - 1).getVertice() != destino) {
					aresta.add(i, new Aresta(destino, custo));
				}
			}
		}
	}

	public void insereAresta(float custo, int destino, int origem) {
		//cria aresta das 2 direções
		insAresta(custo, destino, origem);
		insAresta(custo, origem, destino);
	}

	public void inicializaAresta() {
		// inicializa a aresta e define o custo
		insereAresta(10, 0 * linha + 0 + 1, 0);
		insereAresta(10, (0 + 1) * linha + 0, 0);
		insereAresta(14, (0 + 1) * linha + 1, 0);

		insereAresta(10, 0 * linha + (coluna - 2), 0 * linha + coluna - 1);
		insereAresta(14, (0 + 1) * linha + (coluna - 2), 0 * linha + coluna - 1);
		insereAresta(10, (0 + 1) * linha + (coluna - 1), 0 * linha + coluna - 1);

		insereAresta(10, (linha - 2) * linha + 0, (linha - 1) * linha + 0);
		insereAresta(14, (linha - 2) * linha + 1, (linha - 1) * linha + 0);
		insereAresta(10, (linha - 1) * linha + 1, (linha - 1) * linha + 0);

		insereAresta(14, (linha - 2) * linha + (coluna - 2), (linha - 1) * linha + coluna - 1);
		insereAresta(10, (linha - 2) * linha + (coluna - 1), (linha - 1) * linha + coluna - 1);
		insereAresta(10, (linha - 1) * linha + (coluna - 2), (linha - 1) * linha + coluna - 1);

		for (int i = 1; i < linha - 1; i++) {

			insereAresta(10, ((i - 1) * linha) + 0, (i * linha) + 0);
			insereAresta(14, ((i - 1) * linha) + 1, (i * linha) + 0);
			insereAresta(10, ((i) * linha) + 1, (i * linha) + 0);
			insereAresta(14, ((i + 1) * linha) + 1, (i * linha) + 0);
			insereAresta(10, ((i + 1) * linha) + 0, (i * linha) + 0);

			insereAresta(10, ((i - 1) * linha) + (coluna - 1), (i * linha) + coluna - 1);
			insereAresta(14, ((i - 1) * linha) + (coluna - 2), (i * linha) + coluna - 1);
			insereAresta(10, ((i) * linha) + (coluna - 2), (i * linha) + coluna - 1);
			insereAresta(14, ((i + 1) * linha) + (coluna - 2), (i * linha) + coluna - 1);
			insereAresta(10, ((i + 1) * linha) + (coluna - 1), (i * linha) + coluna - 1);

		}

		for (int i = 1; i < coluna - 1; i++) {

			insereAresta(10, (0 * linha) + (i - 1), (0 * linha) + i);
			insereAresta(14, (1 * linha) + (i - 1), (0 * linha) + i);
			insereAresta(10, (1 * linha) + (i), (0 * linha) + i);
			insereAresta(14, (1 * linha) + (i + 1), (0 * linha) + i);
			insereAresta(10, (0 * linha) + (i + 1), (0 * linha) + i);

			insereAresta(10, (linha - 1) * linha + (i - 1), (linha - 1) * linha + i);
			insereAresta(14, (linha - 2) * linha + (i - 1), (linha - 1) * linha + i);
			insereAresta(10, (linha - 2) * linha + (i + 0), (linha - 1) * linha + i);
			insereAresta(14, (linha - 2) * linha + (i + 1), (linha - 1) * linha + i);
			insereAresta(10, (linha - 1) * linha + (i + 1), (linha - 1) * linha + i);

		}

		for (int i = 1; i < linha - 1; i++) {
			for (int j = 1; j < coluna - 1; j++) {

				insereAresta(14, (i - 1) * linha + (j - 1), (i * linha) + j);
				insereAresta(10, (i) * linha + (j - 1), (i * linha) + j);
				insereAresta(14, (i + 1) * linha + (j - 1), (i * linha) + j);
				insereAresta(10, (i - 1) * linha + (j), (i * linha) + j);
				insereAresta(10, (i + 1) * linha + (j), (i * linha) + j);
				insereAresta(14, (i - 1) * linha + (j + 1), (i * linha) + j);
				insereAresta(10, (i) * linha + (j + 1), (i * linha) + j);
				insereAresta(14, (i + 1) * linha + (j + 1), (i * linha) + j);

			}
		}

	}

	public void inicializaMapa() {

		/* AQUI GERA A GRAMA */

		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				grafo[(i * linha) + j].setNome(Color.GREEN);// grama
			}
		}

		/* AQUI GERA O FORMIGUEIRO */
		for (int i = 4; i < (linha - 8); i++) {
			for (int j = 7; j < (coluna - 7); j++) {
				grafo[(i * linha) + j].setNome(Color.WHITE);// formigueiro
			}
		}
		/* AQUI GERA A SALA DA RAINHA */
		for (int i = 17; i < (linha - 17); i++) {
			for (int j = 17; j < (coluna - 17); j++) {
				grafo[(i * linha) + j].setNome(Color.ORANGE); // sala da rainha
			}
		}
		/* AQUI COMEÇAM AS FORMIGAS E A RAINHA */
		grafo[(19 * linha) + 20].setNome(Color.BLACK); // formiga
		grafo[(21 * linha) + 20].setNome(Color.BLACK);// formiga
		grafo[(20 * linha) + 19].setNome(Color.BLACK);// formiga
		grafo[(20 * linha) + 21].setNome(Color.BLACK);// formiga
		grafo[(20 * linha) + 20].setNome(Color.PINK);// rainha

		/* AQUI COMEÇAM AS PEDRAS */
		grafo[(0 * linha) + 4].setNome(Color.GRAY);// pedra
		excluiVertice((0 * linha) + 4);

		grafo[(2 * linha) + 4].setNome(Color.GRAY);// pedra
		excluiVertice((2 * linha) + 4);

		grafo[(3 * linha) + 4].setNome(Color.GRAY);// pedra
		excluiVertice((3 * linha) + 4);

		grafo[(2 * linha) + 6].setNome(Color.GRAY);// pedra
		excluiVertice((2 * linha) + 6);

		grafo[(1 * linha) + 29].setNome(Color.GRAY);// pedra
		excluiVertice((1 * linha) + 29);

		grafo[(2 * linha) + 28].setNome(Color.GRAY);// pedra
		excluiVertice((2 * linha) + 28);

		grafo[(2 * linha) + 27].setNome(Color.GRAY);// pedra
		excluiVertice((2 * linha) + 27);

		grafo[(1 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((1 * linha) + 37);

		grafo[(1 * linha) + 38].setNome(Color.GRAY);// pedra
		excluiVertice((1 * linha) + 37);

		grafo[(2 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((1 * linha) + 37);

		grafo[(2 * linha) + 38].setNome(Color.GRAY);// pedra
		excluiVertice((1 * linha) + 37);

		grafo[(3 * linha) + 38].setNome(Color.GRAY);// pedra
		excluiVertice((1 * linha) + 37);

		grafo[(12 * linha) + 35].setNome(Color.GRAY);// pedra
		excluiVertice((12 * linha) + 35);

		grafo[(13 * linha) + 35].setNome(Color.GRAY);// pedra
		excluiVertice((13 * linha) + 35);

		grafo[(13 * linha) + 36].setNome(Color.GRAY);// pedra
		excluiVertice((13 * linha) + 36);

		grafo[(14 * linha) + 36].setNome(Color.GRAY);// pedra
		excluiVertice((14 * linha) + 36);

		grafo[(14 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((14 * linha) + 37);

		grafo[(15 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((15 * linha) + 37);

		grafo[(17 * linha) + 36].setNome(Color.GRAY);// pedra
		excluiVertice((17 * linha) + 36);

		grafo[(18 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((18 * linha) + 37);

		grafo[(18 * linha) + 39].setNome(Color.GRAY);// pedra
		excluiVertice((18 * linha) + 39);

		grafo[(20 * linha) + 34].setNome(Color.GRAY);// pedra
		excluiVertice((20 * linha) + 34);

		grafo[(24 * linha) + 34].setNome(Color.GRAY);// pedra
		excluiVertice((24 * linha) + 34);

		grafo[(23 * linha) + 36].setNome(Color.GRAY);// pedra
		excluiVertice((23 * linha) + 36);

		grafo[(24 * linha) + 35].setNome(Color.GRAY);// pedra
		excluiVertice((24 * linha) + 35);

		grafo[(25 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((25 * linha) + 37);

		grafo[(27 * linha) + 36].setNome(Color.GRAY);// pedra
		excluiVertice((27 * linha) + 36);

		grafo[(28 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((28 * linha) + 37);

		grafo[(35 * linha) + 36].setNome(Color.GRAY);// pedra
		excluiVertice((35 * linha) + 36);

		grafo[(37 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 37);

		grafo[(38 * linha) + 37].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 37);

		grafo[(37 * linha) + 33].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 33);

		grafo[(36 * linha) + 33].setNome(Color.GRAY);// pedra
		excluiVertice((36 * linha) + 33);

		grafo[(33 * linha) + 32].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 32);

		grafo[(33 * linha) + 30].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 30);

		grafo[(33 * linha) + 29].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 29);

		grafo[(34 * linha) + 28].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 28);

		grafo[(34 * linha) + 27].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 27);

		grafo[(34 * linha) + 26].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 26);

		grafo[(34 * linha) + 25].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 25);

		grafo[(37 * linha) + 30].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 30);

		grafo[(37 * linha) + 27].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 27);

		grafo[(39 * linha) + 28].setNome(Color.GRAY);// pedra
		excluiVertice((39 * linha) + 28);

		grafo[(37 * linha) + 25].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 25);

		grafo[(37 * linha) + 23].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 23);

		grafo[(34 * linha) + 21].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 21);

		grafo[(34 * linha) + 20].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 20);

		grafo[(34 * linha) + 19].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 19);

		grafo[(38 * linha) + 20].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 20);

		grafo[(38 * linha) + 19].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 19);

		grafo[(33 * linha) + 18].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 18);

		grafo[(36 * linha) + 16].setNome(Color.GRAY);// pedra
		excluiVertice((36 * linha) + 16);

		grafo[(37 * linha) + 16].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 16);

		grafo[(38 * linha) + 16].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 16);

		grafo[(36 * linha) + 15].setNome(Color.GRAY);// pedra
		excluiVertice((36 * linha) + 15);

		grafo[(35 * linha) + 15].setNome(Color.GRAY);// pedra
		excluiVertice((35 * linha) + 15);

		grafo[(34 * linha) + 15].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 15);

		grafo[(33 * linha) + 15].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 15);

		grafo[(33 * linha) + 14].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 14);

		grafo[(34 * linha) + 14].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 14);

		grafo[(33 * linha) + 12].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 12);

		grafo[(37 * linha) + 11].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 11);

		grafo[(33 * linha) + 10].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 10);

		grafo[(33 * linha) + 9].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 9);

		grafo[(34 * linha) + 9].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 9);

		grafo[(37 * linha) + 9].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 9);

		grafo[(37 * linha) + 8].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 8);

		grafo[(38 * linha) + 8].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 8);

		grafo[(33 * linha) + 8].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 8);

		grafo[(38 * linha) + 6].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 6);

		grafo[(38 * linha) + 5].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 5);

		grafo[(34 * linha) + 5].setNome(Color.GRAY);// pedra
		excluiVertice((34 * linha) + 5);

		grafo[(33 * linha) + 5].setNome(Color.GRAY);// pedra
		excluiVertice((33 * linha) + 5);

		grafo[(25 * linha) + 5].setNome(Color.GRAY);// pedra
		excluiVertice((25 * linha) + 5);

		grafo[(31 * linha) + 4].setNome(Color.GRAY);// pedra
		excluiVertice((31 * linha) + 4);

		grafo[(35 * linha) + 4].setNome(Color.GRAY);// pedra
		excluiVertice((35 * linha) + 4);

		grafo[(35 * linha) + 3].setNome(Color.GRAY);// pedra
		excluiVertice((35 * linha) + 3);

		grafo[(36 * linha) + 3].setNome(Color.GRAY);// pedra
		excluiVertice((36 * linha) + 3);

		grafo[(38 * linha) + 3].setNome(Color.GRAY);// pedra
		excluiVertice((38 * linha) + 3);

		grafo[(31 * linha) + 3].setNome(Color.GRAY);// pedra
		excluiVertice((31 * linha) + 3);

		grafo[(30 * linha) + 3].setNome(Color.GRAY);// pedra
		excluiVertice((30 * linha) + 3);

		grafo[(25 * linha) + 3].setNome(Color.GRAY);// pedra
		excluiVertice((25 * linha) + 3);

		grafo[(25 * linha) + 2].setNome(Color.GRAY);// pedra
		excluiVertice((25 * linha) + 2);

		grafo[(26 * linha) + 2].setNome(Color.GRAY);// pedra
		excluiVertice((26 * linha) + 2);

		grafo[(35 * linha) + 2].setNome(Color.GRAY);// pedra
		excluiVertice((35 * linha) + 2);

		grafo[(36 * linha) + 2].setNome(Color.GRAY);// pedra
		excluiVertice((36 * linha) + 2);

		grafo[(37 * linha) + 2].setNome(Color.GRAY);// pedra
		excluiVertice((37 * linha) + 2);

		for (int i = 27; i < (linha); i++) {
			for (int j = 34; j < (coluna - 4); j++) {
				grafo[(i * linha) + j].setNome(Color.GRAY);// pedra
				excluiVertice((i * linha) + j);
			}
		}

		for (int j = 12; j < (coluna - 22); j++) {
			grafo[(1 * linha) + j].setNome(Color.GRAY);// pedra
			excluiVertice((1 * linha) + j);
		}

		for (int j = 22; j < (coluna - 13); j++) {
			grafo[(1 * linha) + j].setNome(Color.GRAY);// pedra
			excluiVertice((1 * linha) + j);
		}

		for (int i = 4; i < (linha - 22); i++) {
			for (int j = 2; j < (coluna - 35); j++) {
				grafo[(i * linha) + j].setNome(Color.GRAY);// pedra
				excluiVertice((i * linha) + j);
			}
		}

		for (int i = 3; i < (linha - 28); i++) {
			for (int j = 34; j < (coluna - 2); j++) {
				grafo[(i * linha) + j].setNome(Color.GRAY);// pedra
				excluiVertice((i * linha) + j);
			}
		}

		/* PAREDES DOS TUNEIS DO FORMIGUEIRO */

		grafo[(6 * linha) + 8].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 8);

		grafo[(7 * linha) + 8].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((7 * linha) + 8);

		grafo[(16 * linha) + 8].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((16 * linha) + 8);

		grafo[(22 * linha) + 8].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((22 * linha) + 8);

		grafo[(27 * linha) + 8].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((27 * linha) + 8);

		grafo[(6 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 9);

		grafo[(7 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((7 * linha) + 9);

		grafo[(15 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((15 * linha) + 9);

		grafo[(16 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((16 * linha) + 9);

		grafo[(19 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 9);

		grafo[(20 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((20 * linha) + 9);

		grafo[(21 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((21 * linha) + 9);

		grafo[(26 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((26 * linha) + 9);

		grafo[(30 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 9);

		grafo[(31 * linha) + 9].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((31 * linha) + 9);

		grafo[(7 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((7 * linha) + 10);

		grafo[(8 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((8 * linha) + 10);

		grafo[(9 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((9 * linha) + 10);

		grafo[(14 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 10);

		grafo[(15 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((15 * linha) + 10);

		grafo[(18 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((18 * linha) + 10);

		grafo[(19 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 10);

		grafo[(20 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((20 * linha) + 10);

		grafo[(25 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((25 * linha) + 10);

		grafo[(29 * linha) + 10].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 10);

		grafo[(8 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((8 * linha) + 11);

		grafo[(9 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((9 * linha) + 11);

		grafo[(10 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 11);

		grafo[(11 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 11);

		grafo[(18 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((18 * linha) + 11);

		grafo[(19 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 11);

		grafo[(24 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 11);

		grafo[(30 * linha) + 11].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 11);

		grafo[(11 * linha) + 12].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 12);

		grafo[(19 * linha) + 12].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 12);

		grafo[(23 * linha) + 12].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((23 * linha) + 12);

		grafo[(27 * linha) + 12].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((27 * linha) + 12);

		grafo[(29 * linha) + 12].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 12);

		grafo[(30 * linha) + 12].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 12);

		grafo[(31 * linha) + 12].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((31 * linha) + 12);

		grafo[(4 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((4 * linha) + 13);

		grafo[(4 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((4 * linha) + 13);

		grafo[(5 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((5 * linha) + 13);

		grafo[(6 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 13);

		grafo[(19 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 13);

		grafo[(20 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((20 * linha) + 13);

		grafo[(22 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((22 * linha) + 13);

		grafo[(29 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 13);

		grafo[(30 * linha) + 13].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 13);

		grafo[(5 * linha) + 14].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((5 * linha) + 14);

		grafo[(6 * linha) + 14].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 14);

		grafo[(7 * linha) + 14].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((7 * linha) + 14);

		grafo[(8 * linha) + 14].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((8 * linha) + 14);

		grafo[(22 * linha) + 14].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((22 * linha) + 14);

		grafo[(30 * linha) + 14].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 14);

		grafo[(8 * linha) + 15].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((8 * linha) + 15);

		grafo[(9 * linha) + 15].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((9 * linha) + 15);

		grafo[(10 * linha) + 15].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 15);

		grafo[(11 * linha) + 15].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 15);

		grafo[(12 * linha) + 15].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((12 * linha) + 15);

		grafo[(29 * linha) + 15].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 15);

		grafo[(31 * linha) + 15].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((31 * linha) + 15);

		grafo[(8 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((8 * linha) + 16);

		grafo[(9 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((9 * linha) + 16);

		grafo[(10 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 16);

		grafo[(11 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 16);

		grafo[(12 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((12 * linha) + 16);

		grafo[(13 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((13 * linha) + 16);

		grafo[(14 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 16);

		grafo[(24 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 16);

		grafo[(25 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((25 * linha) + 16);

		grafo[(29 * linha) + 16].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 16);

		grafo[(14 * linha) + 17].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 17);

		grafo[(14 * linha) + 17].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 17);

		grafo[(22 * linha) + 17].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((22 * linha) + 17);

		grafo[(23 * linha) + 17].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((23 * linha) + 17);

		grafo[(24 * linha) + 17].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 17);

		grafo[(29 * linha) + 17].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 17);

		grafo[(30 * linha) + 17].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 17);

		grafo[(4 * linha) + 18].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((4 * linha) + 18);

		grafo[(5 * linha) + 18].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((5 * linha) + 18);

		grafo[(6 * linha) + 18].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 18);

		grafo[(7 * linha) + 18].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((7 * linha) + 18);

		grafo[(8 * linha) + 18].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((8 * linha) + 18);

		grafo[(9 * linha) + 18].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((9 * linha) + 18);

		grafo[(16 * linha) + 18].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((16 * linha) + 18);

		grafo[(9 * linha) + 19].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((9 * linha) + 19);

		grafo[(10 * linha) + 19].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 19);

		grafo[(12 * linha) + 19].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((12 * linha) + 19);

		grafo[(30 * linha) + 19].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 19);

		grafo[(11 * linha) + 20].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 20);

		grafo[(23 * linha) + 20].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((23 * linha) + 20);

		grafo[(29 * linha) + 20].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 20);

		grafo[(30 * linha) + 20].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 20);

		grafo[(31 * linha) + 20].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((31 * linha) + 20);

		grafo[(23 * linha) + 21].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((23 * linha) + 21);

		grafo[(24 * linha) + 21].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 21);

		grafo[(26 * linha) + 21].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((26 * linha) + 21);

		grafo[(29 * linha) + 21].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 21);

		grafo[(30 * linha) + 21].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 21);

		grafo[(14 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 22);

		grafo[(15 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((15 * linha) + 22);

		grafo[(24 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 22);

		grafo[(25 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((25 * linha) + 22);

		grafo[(26 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((26 * linha) + 22);

		grafo[(27 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((27 * linha) + 22);

		grafo[(29 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 22);

		grafo[(30 * linha) + 22].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 22);

		grafo[(12 * linha) + 23].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((12 * linha) + 23);

		grafo[(13 * linha) + 23].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((13 * linha) + 23);

		grafo[(14 * linha) + 23].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 23);

		grafo[(15 * linha) + 23].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((15 * linha) + 23);

		grafo[(10 * linha) + 24].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 24);

		grafo[(11 * linha) + 24].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 24);

		grafo[(12 * linha) + 24].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((12 * linha) + 24);

		grafo[(19 * linha) + 24].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 24);

		grafo[(20 * linha) + 24].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((20 * linha) + 24);

		grafo[(21 * linha) + 24].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((21 * linha) + 24);

		grafo[(22 * linha) + 24].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((22 * linha) + 24);

		grafo[(9 * linha) + 25].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((9 * linha) + 25);

		grafo[(10 * linha) + 25].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 25);

		grafo[(14 * linha) + 25].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 25);

		grafo[(15 * linha) + 25].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((15 * linha) + 25);

		grafo[(20 * linha) + 25].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((20 * linha) + 25);

		grafo[(21 * linha) + 25].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((21 * linha) + 25);

		grafo[(6 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 26);

		grafo[(7 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((7 * linha) + 26);

		grafo[(8 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((8 * linha) + 26);

		grafo[(10 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 26);

		grafo[(14 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 26);

		grafo[(15 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((15 * linha) + 26);

		grafo[(16 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((16 * linha) + 26);

		grafo[(21 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((21 * linha) + 26);

		grafo[(22 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((22 * linha) + 26);

		grafo[(23 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((23 * linha) + 26);

		grafo[(24 * linha) + 26].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 26);

		grafo[(5 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((5 * linha) + 27);

		grafo[(7 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((7 * linha) + 27);

		grafo[(10 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((10 * linha) + 27);

		grafo[(11 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 27);

		grafo[(16 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((16 * linha) + 27);

		grafo[(17 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((17 * linha) + 27);

		grafo[(23 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((23 * linha) + 27);

		grafo[(24 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 27);

		grafo[(25 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((25 * linha) + 27);

		grafo[(26 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((26 * linha) + 27);

		grafo[(28 * linha) + 27].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((28 * linha) + 27);

		grafo[(11 * linha) + 28].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((11 * linha) + 28);

		grafo[(14 * linha) + 28].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 28);

		grafo[(25 * linha) + 28].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((25 * linha) + 28);

		grafo[(26 * linha) + 28].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((26 * linha) + 28);

		grafo[(27 * linha) + 28].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((27 * linha) + 28);

		grafo[(28 * linha) + 28].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((28 * linha) + 28);

		grafo[(14 * linha) + 29].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((14 * linha) + 29);

		grafo[(15 * linha) + 29].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((15 * linha) + 29);

		grafo[(16 * linha) + 29].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((16 * linha) + 29);

		grafo[(17 * linha) + 29].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((17 * linha) + 29);

		grafo[(18 * linha) + 29].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((18 * linha) + 29);

		grafo[(19 * linha) + 29].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 29);

		grafo[(4 * linha) + 30].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((4 * linha) + 30);

		grafo[(5 * linha) + 30].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((5 * linha) + 30);

		grafo[(18 * linha) + 30].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((18 * linha) + 30);

		grafo[(19 * linha) + 30].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((19 * linha) + 30);

		grafo[(20 * linha) + 30].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((20 * linha) + 30);

		grafo[(25 * linha) + 30].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((25 * linha) + 30);

		grafo[(28 * linha) + 30].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((28 * linha) + 30);

		grafo[(4 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((4 * linha) + 31);

		grafo[(5 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((5 * linha) + 31);

		grafo[(6 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 31);

		grafo[(20 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((20 * linha) + 31);

		grafo[(21 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((21 * linha) + 31);

		grafo[(24 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((24 * linha) + 31);

		grafo[(25 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((25 * linha) + 31);

		grafo[(27 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((27 * linha) + 31);

		grafo[(30 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 31);

		grafo[(31 * linha) + 31].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((31 * linha) + 31);

		grafo[(6 * linha) + 32].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((6 * linha) + 32);

		grafo[(17 * linha) + 32].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((17 * linha) + 32);

		grafo[(29 * linha) + 32].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((29 * linha) + 32);

		grafo[(30 * linha) + 32].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((30 * linha) + 32);

		grafo[(31 * linha) + 32].setNome(Color.LIGHT_GRAY);// parede do formigueiro
		excluiVertice((31 * linha) + 32);
	}

	public Integer[] inicializaComida(int comida) {
		
		//gera a comida em alguma posição aleatória do mapa comparando se ela pode ser acessada ou não
		Integer[] lista_comida = new Integer[comida];
		for (int i = 0; i < comida;) {
			int l = new Random().nextInt(linha);
			int c = new Random().nextInt(coluna);

			if ((l < 5 || l > 32) && (c < 5 || c > 32)) {

				if (!grafo[(l * linha) + c].getNome().equals(Color.GRAY)
						&& !grafo[(l * linha) + c].getNome().equals(Color.LIGHT_GRAY)
						&& !grafo[(l * linha) + c].getNome().equals(Color.BLACK)) {

					grafo[((l * linha) + c)].setNome(Color.RED);
					lista_comida[i] = l * linha + c;
					i++;
				}
			}
		}
		return lista_comida;
	}

	private int menorDistancia(int qtd_comida, float[] distancia) {
		
		//calcula a menor distância
		int menor = 0;

		for (int i = 0; i < qtd_comida; i++) {

			if (distancia[i] < distancia[menor]) {

				menor = i;

			}

		}

		return menor;
	}

	public void geraValorHeuristico(Integer comidas[], int qtd_comida) {
		//calcula o valor heuristico
		for (int c = 0; c < VERTICE; c++) {

			for (int i = 0; i < linha; i++) {

				for (int j = 0; j < coluna; j++) {
					float[] distancia = new float[qtd_comida];
					for (int l = 0; l < qtd_comida; l++) {
						//algoritmo da distancia euclidiana
						distancia[l] = (float) Math.sqrt(Math.pow((grafo[comidas[l]].getColuna() - j), 2)
								+ Math.pow((grafo[comidas[l]].getLinha() - i), 2));

					}

					if (grafo[i * linha + j].getValor_heuristico() == -1) {
						grafo[i * linha + j].setValor_heuristico(distancia[menorDistancia(qtd_comida, distancia)]);
					} else {
						int pos = menorDistancia(qtd_comida, distancia);
						if (distancia[pos] < grafo[i * linha + j].getValor_heuristico()) {

							grafo[i * linha + j].setValor_heuristico(distancia[pos]);
						}
					}
				}
			}
		}

	}

	public void excluiAresta(int destino, List<Aresta> aresta) {
		//exclui aresta caso seja inacessivel no mapa
		int i = 0;

		for (i = 0; aresta.get(i).getVertice() != destino && i < aresta.size(); i++)
			;

		aresta.remove(i);

	}

	public void excluiVertice(int origem) {
		//exclui o vértice
		for (Aresta a : grafo[origem].getAresta()) {

			excluiAresta(origem, grafo[a.getVertice()].getAresta());

		}

		grafo[origem].getAresta().removeAll(grafo[origem].getAresta());

	}

	public void insereValorHeuristicoOrdenado(List<CaminhoHeurístico> aberta, int pai, Aresta aresta, float[] custo) {
		//insere o valor heuristico ordenada para a lista aberta para saber qual vai ser a proximo a ir pra lista fechada
		int i = 0;
		float c = custo[pai] + aresta.getCusto();
		float funcao_heuristica = c + grafo[aresta.getVertice()].getValor_heuristico();

		custo[aresta.getVertice()] += c;

		if (aberta.isEmpty()) {

			aberta.add(new CaminhoHeurístico(pai, aresta.getVertice(), funcao_heuristica));

		} else if (aberta.get(0).getFuncao_heuristica() > funcao_heuristica) {

			aberta.add(0, new CaminhoHeurístico(pai, aresta.getVertice(), funcao_heuristica));

		} else if (aberta.get(aberta.size() - 1).getFuncao_heuristica() < funcao_heuristica) {

			aberta.add(new CaminhoHeurístico(pai, aresta.getVertice(), funcao_heuristica));

		} else {

			for (i = 0; i < aberta.size() && aberta.get(i).getFuncao_heuristica() < funcao_heuristica; i++)
				;
			aberta.add(i, new CaminhoHeurístico(pai, aresta.getVertice(), funcao_heuristica));
		}

	}

	public int aStar(int pos_inicio, int pos_fim, CaminhoHeurístico[] caminho) {
		//aqui acontece o astar
		int pai = -1;
		List<CaminhoHeurístico> aberta = new LinkedList<CaminhoHeurístico>();
		List<CaminhoHeurístico> fechada = new LinkedList<CaminhoHeurístico>();
		Integer[] visitados = new Integer[VERTICE];
		float[] custo = new float[VERTICE];
		//insere o inicio na lista aberta (posição inicial)
		aberta.add(new CaminhoHeurístico(-1, pos_inicio, 0 + grafo[pos_inicio].getValor_heuristico()));
		//inicia os vertices
		for (int i = 0; i < VERTICE; i++) {
			visitados[i] = (-1);
			caminho[i] = new CaminhoHeurístico(-1, -1, -1);
			custo[i] = 0;
		}
		//aqui é o laço principal
		while (!aberta.isEmpty()) {
			
			if (visitados[aberta.get(0).getVertice_atual()] == -1) {
				pai = aberta.get(0).getVertice_atual();
				visitados[aberta.get(0).getVertice_atual()] = 1;
				fechada.add(aberta.get(0));

				caminho[aberta.get(0).getVertice_atual()] = aberta.get(0);

				if (aberta.get(0).getVertice_atual() == pos_fim) {

					return aberta.get(0).getVertice_atual();

				}
				aberta.remove(0);

				if (!grafo[pai].getAresta().isEmpty()) {

					for (Aresta aresta : grafo[pai].getAresta()) {

						insereValorHeuristicoOrdenado(aberta, pai, aresta, custo);
						
					}

				}

			} else {
				aberta.remove(0);
			}

		}
		return fechada.get(fechada.size() - 1).getVertice_atual();

	}
}
