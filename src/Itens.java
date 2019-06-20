import java.util.Random;

public class Itens {
	
	private int ouro = 0;
	private int diamond = 0;
	private int pot = 0;
	private int machado = 0;
	private int chave = 0;
	
	public int getMachado() {
		return machado;
	}
	
	public int setRandomMachado(int min, int max){
		Random randx = new Random();
		int randomMachado = randx.nextInt((max-min)+1) + min;
		this.machado = randomMachado;
		return randomMachado;
	}
	
	public void setMachadoFerro(int machadoFerro) {
		this.machado = machadoFerro;
	}
	
	public int getOuro() {
		return ouro;
	}
	
	public int getChave() {
		return chave;
	}
	
	public void setRandomChave(int min, int max){
		Random randx = new Random();
		int randomChave = randx.nextInt((max-min)+1) + min;
		this.chave = randomChave;
	}
	
	public int getDiamond() {
		return diamond;
	}
	
	public void setRandomDiamante(int min, int max){
		Random randx = new Random();
		int randomDiamante = randx.nextInt((max-min)+1) + min;
		this.diamond = randomDiamante;
	}
	
	public void setRandomOuro(int min, int max){
		Random randx = new Random();
		int randomOuro = randx.nextInt((max-min)+1) + min;
		this.ouro = randomOuro;
	}
	
	public int getPot() {
		return pot;
	}

	public void setRandomPot(int min, int max){
		Random randx = new Random();
		int randomPot = randx.nextInt((max-min)+1) + min;
		this.pot = randomPot;
	}
	
	public void setPot(){
		this.pot++;
	}
	
	public void setChave(){
		this.chave++;
	}
	
}