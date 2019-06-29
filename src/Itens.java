import java.util.Random;

public class Itens {
	
	private int ouro = 0;
	private int diamond = 0;
	private int pot = 0;
	private int machado = 0;
	private int chave = 0;
	
	// Geracao aleatoria de machados
	public int setRandomMachado(int min, int max){
		Random randx = new Random();
		int randomMachado = randx.nextInt((max-min)+1) + min;
		this.machado = randomMachado;
		return randomMachado;
	}
	
	// Geracao aleatoria das pocoes
	public void setRandomPot(int min, int max){
		Random randx = new Random();
		int randomPot = randx.nextInt((max-min)+1) + min;
		this.pot = randomPot;
	}
	
	// Geracao aleatoria das chaves
	public void setRandomChave(int min, int max){
		Random randx = new Random();
		int randomChave = randx.nextInt((max-min)+1) + min;
		this.chave = randomChave;
	}
	
	// Geracao aleatoria dos diamantes
	public void setRandomDiamante(int min, int max){
		Random randx = new Random();
		int randomDiamante = randx.nextInt((max-min)+1) + min;
		this.diamond = randomDiamante;
	}
		
	// Geracao aleatoria de ouro
	public void setRandomOuro(int min, int max){
		Random randx = new Random();
		int randomOuro = randx.nextInt((max-min)+1) + min;
		this.ouro = randomOuro;
	}
	
	public int getMachado() {
		return machado;
	}
	
	public void setMachado(int machado) {
		this.machado = machado;
	}
	
	public int getPot() {
		return pot;
	}
	
	public void setPot(){
		this.pot++;
	}
	
	public int getChave() {
		return chave;
	}

	public void setChave(){
		this.chave++;
	}
	
	public int getOuro() {
		return ouro;
	}
	
	public int getDiamond() {
		return diamond;
	}
	
	
	
}