package trabalho1;

import java.util.ArrayList;

abstract class Planeta {
	private String nome;
	private int x;
	private int y;
	private int velocidadeTranslacao;
	private Number velocidadeRotacao;
	private int tempoTranslacao;
	private Number tempoRotacao;
	private int tamOrbita;

	public Planeta(String nome, int x, int y, int velocidadeTranslacao, Number velocidadeRotacao, int tamOrbita) {
		this.nome = nome;
		this.x = 0;
		this.y = 0;
		this.velocidadeTranslacao = velocidadeTranslacao;
		this.velocidadeRotacao = velocidadeRotacao;
		this.tempoTranslacao = 0;
		this.tempoRotacao = 0;
		this.tamOrbita = tamOrbita * 4;
	}

	public abstract void mover(int tempo);

	public void colidirComBug() {
		if (this.velocidadeTranslacao > 0) {
			this.velocidadeTranslacao--;
		}
	}

	public void acelerarComDesenvolvedor() {
		if (this.velocidadeTranslacao > 0) {
			this.velocidadeTranslacao++;
		}
	}

	public String getNome() {
		return nome;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelocidadeTranslacao() {
		return velocidadeTranslacao;
	}

	public int getTempoTranslacao() {
		return tempoTranslacao;
	}

	public void setTempoTranslacao(int tempoTranslacao) {
		this.tempoTranslacao = tempoTranslacao;
	}

	public Number getTempoRotacao() {
		return tempoRotacao;
	}

	public void setTempoRotacao(Number tempoRotacao) {
		this.tempoRotacao = tempoRotacao;
	}

	public Number getVelocidadeRotacao() {
		return velocidadeRotacao;
	}

	public int getTamOrbita() {
		return tamOrbita;
	}

	// funções para o relatorio final
	public int getColisoesBugs(ArrayList<Bug> bugs) {
		int colisoes = 0;
		for (Bug bug : bugs) {
			if (bug.getX() == getX() && bug.getY() == getY()) {
				colisoes++;
			}
		}
		return colisoes;
	}

	public int getColisoesDesenvolvedores(ArrayList<Desenvolvedor> desenvolvedores) {
		int colisoes = 0;
		for (Desenvolvedor desenvolvedor : desenvolvedores) {
			if (desenvolvedor.getX() == getX() && desenvolvedor.getY() == getY()) {
				colisoes++;
			}
		}
		return colisoes;
	}

	public boolean isExplodido() {
		return (getVelocidadeTranslacao() == 0);
	}

	public String getResumo() {
		String resumo = "";

		if (this instanceof Java) {
			resumo = "Planeta Java: Este é o planeta principal do sistema JavaLar. É conhecido por sua robustez, segurança e alto desempenho.";
		} else if (this instanceof Python) {
			resumo = "Planeta Python: Um planeta versátil que se destaca na simplicidade e legibilidade. É amplamente utilizado para desenvolvimento web e científico.";
		} else if (this instanceof Javascript) {
			resumo = "Planeta JavaScript: Um planeta dinâmico e popular que impulsiona a interatividade na web. Amplamente usado para desenvolvimento front-end.";
		} else if (this instanceof RubyOnRails) {
			resumo = "Planeta Ruby on Rails: Conhecido por sua elegância, este planeta é popular para desenvolvimento web e aplicações de inicialização.";
		} else if (this instanceof PHP) {
			resumo = "Planeta PHP: Um planeta que há muito tempo é usado para desenvolvimento web. Apesar das críticas, ainda é amplamente utilizado.";
		} else if (this instanceof CSharp) {
			resumo = "Planeta C#: Um planeta robusto da família Microsoft, conhecido por desenvolvimento Windows e aplicações empresariais.";
		} else if (this instanceof CPlusPlus) {
			resumo = "Planeta C++: Um planeta de baixo nível, poderoso e complexo usado em sistemas e jogos de alto desempenho.";
		} else if (this instanceof C) {
			resumo = "Planeta C: O planeta mais antigo e fundamental, utilizado na base de muitas outras linguagens de programação.";
		}

		return resumo;
	}
}
