package modelo;

public abstract class Cadastro {

	// Atributos

	protected int numSala;
	protected String nomeFilme;
	protected String horaFilme;

	// Construtor

	public Cadastro() {
		super();
	}

	// Get and Set

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getHoraFilme() {
		return horaFilme;
	}

	public void setHoraFilme(String horaFilme) {
		this.horaFilme = horaFilme;
	}
}
