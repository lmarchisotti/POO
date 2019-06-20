public class Jogador {
	private Comodo comodoAtual;	// Localizacao atual
	private int ouro;			// bag de ouro
    private int diamante;		// bag de diamante
    private int bagAxe; 		// bag de machados
        
    
    // Getters e Setters da localizacao atual, ouro, diamante, chaves, poçoes
    public Comodo getComodoAtual() {
		return comodoAtual;
	}
    public void setComodoAtual(Comodo comodoAtual) {
		this.comodoAtual = comodoAtual;
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