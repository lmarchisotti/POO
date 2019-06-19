public class Jogador {
	private Comodo comodoAtual;
	private int ouro;
    private int diamante;
    private int bagAxe; // bag de todos os machados
    private int bagAxeFerro; //bag dos machados de ferro
    private int bagAxeBronze; //bag dos machados de bronze
    private int bagAxeOuro; //bag dos machados de ouro
    private int lancaBronze;
    private int lancaOuro;
    
    public Comodo getComodoAtual() {
		return comodoAtual;
	}
    public void setComodoAtual(Comodo comodoAtual) {
		this.comodoAtual = comodoAtual;
	}
    
    public int getLancaBronze() {
		return lancaBronze;
	}

	public void setLancaBronze(int lancaBronze) {
		this.lancaBronze = lancaBronze;
	}

	public int getLancaOuro() {
		return lancaOuro;
	}

	public void setLancaOuro(int lancaOuro) {
		this.lancaOuro = lancaOuro;
	}

	public int getBagAxeFerro() {
		return bagAxeFerro;
	}

	public void setBagAxeFerro(int bagAxeFerro) {
		this.bagAxeFerro = bagAxeFerro;
	}

	public int getBagAxeBronze() {
		return bagAxeBronze;
	}

	public void setBagAxeBronze(int bagAxeBronze) {
		this.bagAxeBronze = bagAxeBronze;
	}

	public int getBagAxeOuro() {
		return bagAxeOuro;
	}

	public void setBagAxeOuro(int bagAxeOuro) {
		this.bagAxeOuro = bagAxeOuro;
	}

	private int bagKey;
    private int bagPot;
    
	public int getDiamante() {
		return diamante;
	}
	
	public void setDiamante(int diamante) {
		this.diamante = diamante;
	}
	
	public int getOuro() {
		return ouro;
	}
	
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}

	public int getBagAxe() {
		return bagAxe;
	}

	public void setBagAxe(int bagAxe) {
		this.bagAxe = bagAxe;
	}
	
	public int getBagKey() {
		return bagKey;
	}

	public void setBagKey(int bagKey) {
		this.bagKey = bagKey;
	}
	
	public int getBagPot() {
		return bagPot;
	}

	public void setBagPot(int bagPot) {
		this.bagPot = bagPot;
	}
}