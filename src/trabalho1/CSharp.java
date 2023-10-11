package trabalho1;

public class CSharp extends Planeta {
	private int direcaoX;
	private int direcaoY;
	private int passos;
	private int lado;

	public CSharp() {
		super("C#", 0, 0, 1, 4, 12);
		this.direcaoX = 1;
		this.direcaoY = 0;
		this.passos = 0;
		this.lado = 0;
	}

	public CSharp(int x, int y) {
		super("C#", x + 5, y, 1, 4, 12);
		this.direcaoX = 1;
		this.direcaoY = 0;
		this.passos = 0;
		this.lado = 0;
	}

	public void mover(int tempo) {
		int velocidadeTranslacao = getVelocidadeTranslacao();

		if (direcaoX == 1 && direcaoY == 0) {
			setX(getX() + velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 12) {
				passos = 0;
				direcaoX = 0;
				direcaoY = 1;
			}
		} else if (direcaoX == 0 && direcaoY == 1) {
			setY(getY() + velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 12) {
				passos = 0;
				direcaoX = -1;
				direcaoY = 0;
			}
		} else if (direcaoX == -1 && direcaoY == 0) {
			setX(getX() - velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 12) {
				passos = 0;
				direcaoX = 0;
				direcaoY = -1;
			}
		} else if (direcaoX == 0 && direcaoY == -1) {
			setY(getY() - velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 12) {
				passos = 0;
				direcaoX = 1;
				direcaoY = 0;
			}
		}

		if (lado >= 12) {
			lado = 0;
			direcaoX = 1;
			direcaoY = 0;
			setX(getX() + 5);
		}

		lado++;

		setTempoTranslacao(getTempoTranslacao() + tempo);
		setTempoRotacao(getTempoRotacao().intValue() + tempo * getVelocidadeRotacao().intValue());
	}
}
