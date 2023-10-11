package trabalho1;

public class PHP extends Planeta {
	private int direcaoX;
	private int direcaoY;
	private int passos;
	private int lado;

	public PHP() {
		super("PHP", 0, 0, 2, 60, 10);
		this.direcaoX = 1;
		this.direcaoY = 0;
		this.passos = 0;
		this.lado = 0;
	}

	public PHP(int x, int y) {
		super("PHP", x + 4, y, 2, 60, 10);
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

			if (passos >= 10) {
				passos = 0;
				direcaoX = 0;
				direcaoY = 1;
			}
		} else if (direcaoX == 0 && direcaoY == 1) {
			setY(getY() + velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 10) {
				passos = 0;
				direcaoX = -1;
				direcaoY = 0;
			}
		} else if (direcaoX == -1 && direcaoY == 0) {
			setX(getX() - velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 10) {
				passos = 0;
				direcaoX = 0;
				direcaoY = -1;
			}
		} else if (direcaoX == 0 && direcaoY == -1) {
			setY(getY() - velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 10) {
				passos = 0;
				direcaoX = 1;
				direcaoY = 0;
			}
		}

		if (lado >= 10) {
			lado = 0;
			direcaoX = 1;
			direcaoY = 0;
			setX(getX() + 4);
		}

		lado++;

		setTempoTranslacao(getTempoTranslacao() + tempo);
		setTempoRotacao(getTempoRotacao().intValue() + tempo * getVelocidadeRotacao().intValue());
	}
}