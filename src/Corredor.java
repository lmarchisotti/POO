import java.util.ArrayList;

public class Corredor extends Comodo{
	
	private String Id;
	
	public String getId(){
		return Id;
	}
	public void setId(String Id){
		this.Id = Id;
	}
	
	public static void viewCorredor(Corredor corredor){
		String portasCorredor = "";
		for(Portas p:corredor.getPortas()){			
			String str = String.valueOf(p.getNome());
			portasCorredor = portasCorredor.concat(str).concat(", ");
		}
		if(portasCorredor.length() == 0){
			portasCorredor = ", ";
		}
		String trollsCorredor = "";
		for(Trolls t : corredor.getTroll()){
			String str = String.valueOf(t.getNomeTroll());
			trollsCorredor = trollsCorredor.concat(str).concat(", ");
		}
		if(trollsCorredor.length() == 0){
			trollsCorredor = ", ";
		}
		System.out.println("portas do corredor: " + portasCorredor.substring(0,portasCorredor.length()-2));
		System.out.println("trolls do corredor: " + trollsCorredor.substring(0,trollsCorredor.length()-2));
	}
	
	public static Corredor getCorredorByIdentificador(ArrayList<Comodo> comodos, Integer identificador){		
		for(Comodo comodo : comodos){
			if(!comodo.getIsSala()){
				if(new Integer(((Corredor) comodo).getId()).equals(identificador)){					
					return (Corredor) comodo;
				}							
			}
		}
		return null;
	}
}