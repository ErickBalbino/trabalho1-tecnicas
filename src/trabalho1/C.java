package trabalho1;

public class C extends Planeta {
	private int direcaoX;
	private int direcaoY;
	private int passos;
	private int lado;

	public C() {
		super("C", 0, 0, 10, 0.1, 16);
		this.direcaoX = 1;
		this.direcaoY = 0;
		this.passos = 0;
		this.lado = 0;
	}

	public C(int x, int y) {
		super("C", x + 7, y, 10, 0.1, 16);
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

			if (passos >= 16) {
				passos = 0;
				direcaoX = 0;
				direcaoY = 1;
			}
		} else if (direcaoX == 0 && direcaoY == 1) {
			setY(getY() + velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 16) {
				passos = 0;
				direcaoX = -1;
				direcaoY = 0;
			}
		} else if (direcaoX == -1 && direcaoY == 0) {
			setX(getX() - velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 16) {
				passos = 0;
				direcaoX = 0;
				direcaoY = -1;
			}
		} else if (direcaoX == 0 && direcaoY == -1) {
			setY(getY() - velocidadeTranslacao * tempo);
			passos += velocidadeTranslacao * tempo;

			if (passos >= 16) {
				passos = 0;
				direcaoX = 1;
				direcaoY = 0;
			}
		}

		if (lado >= 16) {
			lado = 0;
			direcaoX = 1;
			direcaoY = 0;
			setX(getX() + 7);
		}

		lado++;

		setTempoTranslacao(getTempoTranslacao() + tempo);
		setTempoRotacao(getTempoRotacao().doubleValue() + tempo * getVelocidadeRotacao().doubleValue());
	}
}