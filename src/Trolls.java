public class Trolls {
	
	// Nome troll - Comodo atual - booleano se vivo ou morto
	String nt;
	private Comodo comodoAtual;
	private boolean vivo;

	// Para cada troll, o conjunto de inf nome-localizacao-vivo ou nao
	public Trolls(String nt, Comodo comodoAtual, boolean vivo){
		this.nt = nt;
		this.comodoAtual = comodoAtual;
		this.vivo = vivo;
	}
	
	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public String getNt() {
		return nt;
	}

	public Comodo getComodoAtual() {
		return comodoAtual;
	}
	public void setComodoAtual(Comodo comodoAtual) {
		this.comodoAtual = comodoAtual;
	}
}