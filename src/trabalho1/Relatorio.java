package trabalho1;

import java.util.ArrayList;

public class Relatorio {
	public static void gerarRelatorio(ArrayList<Planeta> planetas, ArrayList<Bug> bugs,
			ArrayList<Desenvolvedor> desenvolvedores, int instante) {
		System.out.println("---------- Relatório Final ----------");

		// Número de bugs e desenvolvedores que cada planeta colidiu
		for (Planeta planeta : planetas) {
			int colisoesBugs = planeta.getColisoesBugs(bugs);
			int colisoesDesenvolvedores = planeta.getColisoesDesenvolvedores(desenvolvedores);
			System.out.println(planeta.getNome() + ": " + colisoesBugs + " bugs e " + colisoesDesenvolvedores
					+ " desenvolvedores");
		}

		System.out.println("---------------------------------------");

		// Nome, velocidade de rotação e velocidade média de translação de cada planeta
		for (Planeta planeta : planetas) {
			System.out.println(planeta.getNome() + ":");
			System.out.println("  - Velocidade de rotação: " + planeta.getVelocidadeRotacao() + " horas por dia");
		}

		System.out.println("---------------------------------------");

		// Se algum planeta explodiu
		for (Planeta planeta : planetas) {
			if (planeta.isExplodido()) {
				System.out.println(planeta.getNome() + " explodiu ao longo da execução do sistema");
			}
		}

		System.out.println("---------------------------------------");

		// Quantos instantes foram solicitados pelo usuário
		System.out.println("d) Quantos instantes foram solicitados pelo usuário: " + (instante - 1));

		System.out.println("---------------------------------------");

		// Quantos dias (em horas) se passaram em cada planeta e anos JavaLar
		for (Planeta planeta : planetas) {
			int diasPlaneta = planeta.getTempoRotacao().intValue() / 24;
			int anosJavaLar = (planeta.getX() + planeta.getY()) / (planeta.getTamOrbita() * 4);
			System.out.println(planeta.getNome() + ": " + diasPlaneta + " dias (" + anosJavaLar + " anos JavaLar)");
		}

		System.out.println("---------------------------------------");

		// Pequeno resumo sobre cada linguagem-planetinha
		for (Planeta planeta : planetas) {
			String resumo = planeta.getResumo();
			System.out.println(planeta.getNome() + ": " + resumo);
		}
	}
}
