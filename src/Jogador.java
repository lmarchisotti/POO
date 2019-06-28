public class Jogador {
	
	private Comodo comodoAtual;	// Localizacao atual
	Mochila mochila = new Mochila();

    public Comodo getComodoAtual() {
		return comodoAtual;
	}
    
    public void setComodoAtual(Comodo comodoAtual) {
		this.comodoAtual = comodoAtual;
	}
    
    public Mochila getMochila() {
		return mochila;
	}
    
    public void setMochila(Mochila mochila) {
		this.mochila = mochila;
	}

}