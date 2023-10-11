package trabalho1;


public class Python extends Planeta {
    private int direcaoX;
    private int direcaoY;
    private int passos;
    private int lado;

    public Python() {
        super("Python", 0, 0, 4, 24, 4);
        this.direcaoX = 1;
        this.direcaoY = 0;
        this.passos = 0;
        this.lado = 0;
    }

    public Python(int x, int y) {
        super("Python", x + 1, y, 4, 24, 4);
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

            if (passos >= 4) {
                passos = 0;
                direcaoX = 0;
                direcaoY = 1;
            }
        } else if (direcaoX == 0 && direcaoY == 1) {
            setY(getY() + velocidadeTranslacao * tempo);
            passos += velocidadeTranslacao * tempo;

            if (passos >= 4) {
                passos = 0;
                direcaoX = -1;
                direcaoY = 0;
            }
        } else if (direcaoX == -1 && direcaoY == 0) {
            setX(getX() - velocidadeTranslacao * tempo);
            passos += velocidadeTranslacao * tempo;

            if (passos >= 4) {
                passos = 0;
                direcaoX = 0;
                direcaoY = -1;
            }
        } else if (direcaoX == 0 && direcaoY == -1) {
            setY(getY() - velocidadeTranslacao * tempo);
            passos += velocidadeTranslacao * tempo;

            if (passos >= 4) {
                passos = 0;
                direcaoX = 1;
                direcaoY = 0;
            }
        }

        if (lado >= 4) {
            lado = 0;
            direcaoX = 1;
            direcaoY = 0;
            setX(getX() + 1);
        }

        lado++;

        setTempoTranslacao(getTempoTranslacao() + tempo);
        setTempoRotacao(getTempoRotacao().intValue() + tempo * getVelocidadeRotacao().intValue());
    }
}