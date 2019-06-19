import java.util.ArrayList;

public class Pisos {
	
	private int x;
	private int y;
	
	private ArrayList<Itens> itens = new ArrayList<Itens>();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList<Itens> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Itens> itens) {
		this.itens = itens;
	}
	
}