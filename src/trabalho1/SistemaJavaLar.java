package trabalho1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SistemaJavaLar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Planeta> planetas = new ArrayList<>();
		ArrayList<Bug> bugs = new ArrayList<>();
		ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

		Java java = new Java();
		planetas.add(java);
		Python python = new Python();
		planetas.add(python);
		Javascript javascript = new Javascript();
		planetas.add(javascript);
		RubyOnRails rubyOnRails = new RubyOnRails();
		planetas.add(rubyOnRails);
		PHP php = new PHP();
		planetas.add(php);
		CSharp cSharp = new CSharp();
		planetas.add(cSharp);
		CPlusPlus cPlusPlus = new CPlusPlus();
		planetas.add(cPlusPlus);
		C c = new C();
		planetas.add(c);

		int instante = 1;
		int bugsInseridos = 0;
		int desenvolvedoresInseridos = 0;

		while (true) {
			System.out.println("----- Instante " + instante + " -----");
			System.out.println("1. Informar novo instante");
			System.out.println("2. Sair");

			int escolha = scanner.nextInt();

			if (escolha == 2) {
				Relatorio.gerarRelatorio(planetas, bugs, desenvolvedores, instante);
				break;
			}

			System.out.print("Informe a quantidade de tempo do instante: ");
			int tempoInstante = scanner.nextInt();

			System.out.print("Informe o número de bugs a serem inseridos: ");
			int bugsNovos = scanner.nextInt();

			System.out.print("Informe o número de desenvolvedores a serem inseridos: ");
			int desenvolvedoresNovos = scanner.nextInt();

			for (Planeta planeta : planetas) {
				planeta.mover(tempoInstante);
			}

			Random random = new Random();
			for (int i = 0; i < bugsNovos; i++) {
				int x = random.nextInt(10);
				int y = random.nextInt(10);
				Bug bug = new Bug(x, y);
				bugs.add(bug);
				bugsInseridos++;
			}

			for (int i = 0; i < desenvolvedoresNovos; i++) {
				int x = random.nextInt(10);
				int y = random.nextInt(10);
				Desenvolvedor desenvolvedor = new Desenvolvedor(x, y);
				desenvolvedores.add(desenvolvedor);
				desenvolvedoresInseridos++;
			}

			for (Planeta planeta : planetas) {
				int velocidadeTranslacao = planeta.getVelocidadeTranslacao();

				if (velocidadeTranslacao != 0) {
					int diasPlaneta = planeta.getTempoRotacao().intValue() / 24;
					int anosJavaLar = (planeta.getX() + planeta.getY()) / planeta.getTamOrbita() * 4;

					System.out.println(
							planeta.getNome() + ": " + diasPlaneta + " dias (" + anosJavaLar + " anos JavaLar)");
					System.out.println("Velocidade de translação de " + planeta.getNome() + ": "
							+ planeta.getVelocidadeTranslacao());
					System.out.println("-------------------------------------------");
				} else {
					System.out.println("Planeta " + planeta.getNome()
							+ "explodiu: velocidade de translação é zero! Saiu do sistema");

				}

			}

			// remover planetas com velocidade 0
			planetas.removeIf(planeta -> planeta.getVelocidadeTranslacao() == 0);

			// verificar colisões
			for (Planeta planeta : planetas) {
				for (Bug bug : bugs) {
					if (planeta.getX() == bug.getX() && planeta.getY() == bug.getY()) {
						bugs.remove(bug);
						planeta.colidirComBug();
						break;
					}
				}

				for (Desenvolvedor desenvolvedor : desenvolvedores) {
					if (planeta.getX() == desenvolvedor.getX() && planeta.getY() == desenvolvedor.getY()) {
						desenvolvedores.remove(desenvolvedor);
						planeta.acelerarComDesenvolvedor();
						break;
					}
				}
			}

			System.out.println("Posição dos planetas após o instante " + instante + ":");
			for (Planeta planeta : planetas) {
				System.out.println(planeta.getNome() + " - X: " + planeta.getX() + ", Y: " + planeta.getY());
				System.out.println("Tempo de rotação: " + planeta.getTempoRotacao() + " horas");
				System.out.println("---------------------------------");
			}

			System.out.println("Bugs inseridos até agora: " + bugsInseridos);
			System.out.println("Desenvolvedores inseridos até agora: " + desenvolvedoresInseridos);
			System.out.println("Número de planetas no norte: " + contarPlanetasNoNorte(planetas));
			System.out.println("Número de planetas no sul: " + contarPlanetasNoSul(planetas));

			if (verificarAlinhamento(planetas)) {
				System.out.println("Ocorrência de alinhamento dos planetas!");
			}

			instante++;
		}

		scanner.close();
	}

	public static int contarPlanetasNoNorte(ArrayList<Planeta> planetas) {
		int planetasNoNorte = 0;

		for (Planeta planeta : planetas) {
			if (planeta.getY() > 0) {
				planetasNoNorte++;
			}
		}

		return planetasNoNorte;
	}

	public static int contarPlanetasNoSul(ArrayList<Planeta> planetas) {
		int planetasNoSul = 0;

		for (Planeta planeta : planetas) {
			if (planeta.getY() < 0) {
				planetasNoSul++;
			}
		}

		return planetasNoSul;
	}

	public static boolean verificarAlinhamento(ArrayList<Planeta> planetas) {
		if (planetas.isEmpty()) {
			return false;
		}

		boolean alinhamentoVertical = true;
		boolean alinhamentoDiagonalPrincipal = true;
		boolean alinhamentoDiagonalSecundaria = true;

		for (Planeta planeta : planetas) {
			int posX = planeta.getX();
			int posY = planeta.getY();

			alinhamentoVertical &= (posX == planetas.get(0).getX());
			alinhamentoDiagonalPrincipal &= (posX == posY);
			alinhamentoDiagonalSecundaria &= (posX + posY == planetas.get(0).getX() + planetas.get(0).getY());
		}

		return alinhamentoVertical || alinhamentoDiagonalPrincipal || alinhamentoDiagonalSecundaria;
	}

}