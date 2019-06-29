
import java.util.ArrayList;

public class Salas extends Comodo{
	
	private int salasId;
	private Integer tamanho;
	private ArrayList<Pisos> pisos;
	
	public ArrayList<Pisos> getPisos() {
		return pisos;
	}
	
	public void setPisos(ArrayList<Pisos> pisos) {
		this.pisos = pisos;
	}
	
	public int getSalasId() {
		return salasId;
	}

	public void setSalasId(int salasId) {
		this.salasId = salasId;
	}
	
	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
	public Integer getTamanho() {
		return tamanho;
	}
	
	// Criacao das salas.
	public static Salas getSalaByIdentificador(ArrayList<Comodo> comodos, Integer identificador){		
		for(Comodo comodo : comodos){
			if(comodo.getIsSala()){
				if(new Integer(((Salas) comodo).getSalasId()).equals(identificador)){
					return (Salas) comodo;	
				}				
			}
		}
		return null;
	}
}