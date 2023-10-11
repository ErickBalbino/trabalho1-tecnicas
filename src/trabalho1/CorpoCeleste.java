package trabalho1;

public abstract class CorpoCeleste {
	protected int x;
	protected int y;

	public CorpoCeleste(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void mover(int tempo);

	public abstract void rotacionar(int tempo);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
