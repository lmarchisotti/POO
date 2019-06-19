public class Trolls {
	
	String nt;
	private Comodo comodoAtual;
	private boolean vivo;

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