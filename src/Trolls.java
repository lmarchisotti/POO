public class Trolls {
	
	// Nome troll - Comodo atual - booleano se vivo ou morto
	String nomeTroll;
	private Comodo comodoAtual;
	private boolean vivo;

	// Para cada troll, o conjunto de inf nome-localizacao-vivo ou nao
	public Trolls(String nomeTroll, Comodo comodoAtual, boolean vivo){
		this.nomeTroll = nomeTroll;
		this.comodoAtual = comodoAtual;
		this.vivo = vivo;
	}
	
	public boolean trollVivo() {
		if(vivo == true)
			return vivo;
		return false;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public String getNomeTroll() {
		return nomeTroll;
	}

	public Comodo getComodoAtual() {
		return comodoAtual;
	}
	public void setComodoAtual(Comodo comodoAtual) {
		this.comodoAtual = comodoAtual;
	}
}