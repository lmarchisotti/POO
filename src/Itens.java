import java.util.Random;

public class Itens {
	
	private int ouro = 0;
	private int diamond = 0;
	private int pot = 0;
	private int machadoFerro = 0;
	private int machadoBronze = 0;
	private int machadoOuro = 0;
	private int chave = 0;
	
	public int getMachadoFerro() {
		return machadoFerro;
	}
	
	public void setRandomMachadoFerro(int min, int max){
		Random randx = new Random();
		int randomMachadoFerro = randx.nextInt((max-min)+1) + min;
		this.machadoFerro = randomMachadoFerro;
	}
	
	public int getMachadoBronze() {
		return machadoBronze;
	}
	
	public int setRandomMachadoBronze(int min, int max){
		Random randx = new Random();
		int randomMachadoBronze = randx.nextInt((max-min)+1) + min;
		this.machadoBronze = randomMachadoBronze;
		return randomMachadoBronze;
	}
	
	public int getMachadoOuro() {
		return machadoOuro;
	}
	
	public int setRandomMachadoOuro(int min, int max){
		Random randx = new Random();
		int randomMachadoOuro = randx.nextInt((max-min)+1) + min;
		this.machadoOuro = randomMachadoOuro;
		return randomMachadoOuro;
	}
	
	public void setMachadoFerro(int machadoFerro) {
		this.machadoFerro = machadoFerro;
	}
	
	public void setMachadoBronze(int machadoBronze) {
		this.machadoBronze = machadoBronze;
	}
	
	public void setMachadoOuro(int machadoOuro) {
		this.machadoOuro = machadoOuro;
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