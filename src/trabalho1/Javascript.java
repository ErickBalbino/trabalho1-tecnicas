package trabalho1;

public class Javascript extends Planeta {
    private int direcaoX;
    private int direcaoY;
    private int passos;
    private int lado;

    public Javascript() {
        super("Javascript", 0, 0, 3, 10, 6);
        this.direcaoX = 1;
        this.direcaoY = 0;
        this.passos = 0;
        this.lado = 0;
    }

    public Javascript(int x, int y) {
        super("Javascript", x + 2, y, 3, 10, 6);
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

            if (passos >= 6) {
                passos = 0;
                direcaoX = 0;
                direcaoY = 1;
            }
        } else if (direcaoX == 0 && direcaoY == 1) {
            setY(getY() + velocidadeTranslacao * tempo);
            passos += velocidadeTranslacao * tempo;

            if (passos >= 6) {
                passos = 0;
                direcaoX = -1;
                direcaoY = 0;
            }
        } else if (direcaoX == -1 && direcaoY == 0) {
            setX(getX() - velocidadeTranslacao * tempo);
            passos += velocidadeTranslacao * tempo;

            if (passos >= 6) {
                passos = 0;
                direcaoX = 0;
                direcaoY = -1;
            }
        } else if (direcaoX == 0 && direcaoY == -1) {
            setY(getY() - velocidadeTranslacao * tempo);
            passos += velocidadeTranslacao * tempo;

            if (passos >= 6) {
                passos = 0;
                direcaoX = 1;
                direcaoY = 0;
            }
        }

        if (lado >= 6) {
            lado = 0;
            direcaoX = 1;
            direcaoY = 0;
            setX(getX() + 2);
        }

        lado++;

        setTempoTranslacao(getTempoTranslacao() + tempo);
        setTempoRotacao(getTempoRotacao().intValue() + tempo * getVelocidadeRotacao().intValue());
    }
}
