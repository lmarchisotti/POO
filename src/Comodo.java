import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Comodo {

	private ArrayList<Portas> portas = new ArrayList<Portas>();	
	private ArrayList<Trolls> troll = new ArrayList<Trolls>();
	private boolean isSala;
	
	public boolean getIsSala() {
		return isSala;
	}

	public void setIsSala(boolean isSala) {
		this.isSala = isSala;
	}

	public ArrayList<Trolls> getTroll() {
		return troll;
	}

	public void setTroll(ArrayList<Trolls> troll) {
		this.troll = troll;
	}

	public ArrayList<Portas> getPortas() {
		return portas;
	}

	public void setPortas(ArrayList<Portas> portas) {
		this.portas = portas;
	}
	
	static Random random = new Random();
	
	public static ArrayList<Comodo> startCenario(String caminhoarquivo){

		int qtdeMaximaMachadoOuro = 1;
		int qtdeMaximaMachadoBronze = 3;
		int qtdeGeradaMachadoOuro = 0;
		int qtdeGeradaMachadoBronze = 0;
		JSONParser parser = new JSONParser();
		ArrayList<Comodo> comodos = new ArrayList<Comodo>();
		//Leio json
		Reader in = new InputStreamReader(Game.class.getResourceAsStream(caminhoarquivo));
		JSONObject json;
		try {
			//primeiro passo será gerar as salas
			json = (JSONObject) parser.parse(in);
			ArrayList<Integer> tamanhosGerados = new ArrayList<Integer>();
			
			JSONObject jsonSalas = (JSONObject) json.get("salas");
			JSONObject jsonCorredores = (JSONObject) json.get("corredores");
			
			for(int i=1;i<=jsonSalas.size();i++){
			
				JSONObject jsonSala = (JSONObject) jsonSalas.get(String.valueOf(i));
				Salas sala = new Salas();
				//pego id da sala
				Integer idSala = new Integer((String) jsonSala.get("id"));
				
				sala.setSalasId(idSala.intValue());
				sala.setPortas(new ArrayList<Portas>());
				JSONObject jsonPortas = (JSONObject) jsonSala.get("portas");
				
				//vou sortear o tamanho da sala
				sala.setTamanho(0);
				Integer tamanho = new Integer(random.nextInt(100/2)*2+2);//gerando de 2 a 20
				
				while(tamanhosGerados.contains(tamanho)){
					tamanho = new Integer(random.nextInt(100/2)*2+2);//gerando de 2 a 20
				}
				
				sala.setTamanho(tamanho);
				tamanhosGerados.add(tamanho);			
				sala.setPisos(new ArrayList<Pisos>());

				for(int x=0;x<sala.getTamanho()/2;x++){					
					for(int y=0;y<sala.getTamanho()/2;y++){
						Pisos p = new Pisos();					
						p.setX(x);
						p.setY(y);
						p.setItens(new ArrayList<Itens>());
						Itens itens = new Itens();
						if(x == 0 && y == 0){

							//faz aqui o sorteio dos objetos que nao precisam estar sendo sorteados em todos os quadrados							
							itens.setRandomPot(0, 1);
							
							itens.setRandomMachadoFerro(0,1);
							if(qtdeGeradaMachadoBronze < qtdeMaximaMachadoBronze){
								qtdeGeradaMachadoBronze += itens.setRandomMachadoBronze(0, 1);
							}
							if(qtdeGeradaMachadoOuro < qtdeMaximaMachadoOuro){
								qtdeGeradaMachadoOuro += itens.setRandomMachadoOuro(0, 1);
							}
							itens.setRandomChave(0,1);
						}
						//aqui sorteia ouro e diamante						
						itens.setRandomOuro(0, 5);
						itens.setRandomDiamante(0, 5);

						//Adiciono os itens na lista de itens da p
						p.getItens().add(itens);
						sala.getPisos().add(p);
					}
				}

				boolean colocouChave = false;
				for(int j=1;j<=jsonPortas.size();j++){
					JSONObject jsonPorta = (JSONObject) jsonPortas.get(String.valueOf(j));
					Portas porta = new Portas();
					porta.setEntrada(sala.getSalasId());
					String idPorta = (String) jsonPorta.get("identificador");
					porta.setNome(idPorta.charAt(0));
					//essa saida se refere ao corredor de saida da porta
					porta.setEntrada(sala.getSalasId());
					porta.setSaida(Integer.parseInt((String) jsonPorta.get("corredor")));
					
					porta.setSalaTrancada(random.nextBoolean());
					if(porta.getSalaTrancada() && !colocouChave){
						//coloco uma chave na sala
						colocouChave = true;
						//coloco uma chave na sala
						sala.getPisos().get(0).getItens().get(0).setChave();						
					}
					sala.getPortas().add(porta);					
				}	
				
				//adiciono sala na lista de salas do mapa
				sala.setIsSala(true);
				comodos.add(sala);
			}		
			for(int i=1;i<=jsonCorredores.size();i++){
				JSONObject jsonCorredor = (JSONObject) jsonCorredores.get(String.valueOf(i));
				Corredor corredor = new Corredor();
				corredor.setId(jsonCorredor.get("id").toString());
				ArrayList<Portas> portas = new ArrayList<Portas>();
				JSONObject jsonPortas = (JSONObject) jsonCorredor.get("portas");
				for(int j=1;j<=jsonPortas.size();j++){
					//aqui devo procurar a porta correspondente que ja foi criada no momento da inicialização das salas
					JSONObject jsonPorta = (JSONObject) jsonPortas.get(String.valueOf(j));
					String idPorta = jsonPorta.get("identificador").toString();
					Integer salaSaida = new Integer(jsonPorta.get("sala").toString());
					for(Comodo c : comodos){
						if(c.getIsSala()){
							Salas s = (Salas) c;
							if(s.getSalasId() == salaSaida){
								//achou a sala, agora tenho q achar a porta
								for(Portas p : s.getPortas()){
									if(p.getNome() == idPorta.charAt(0)){
										//achou
										portas.add(p);
										break;
									}
								}
							}
						}						
					}					
				}
				corredor.setPortas(portas);
				corredor.setIsSala(false);
				comodos.add(corredor);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comodos;
	}
	
	public void view(Jogador jogador, ArrayList<Trolls> troll){

		int somaOuro = 0;
		int somaDiamante = 0;
		int quantPot = 0;
		int quantKey = 0;
		int quantAxeFerro = 0;
		int quantAxeBronze = 0;
		int quantAxeOuro = 0;
		if(jogador.getComodoAtual().getIsSala()){
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++){
				for(Itens item:((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()){
					somaOuro += item.getOuro();
					somaDiamante += item.getDiamond();
					quantPot += item.getPot();
					quantKey += item.getChave();
					quantAxeFerro += item.getMachadoFerro();
					quantAxeBronze += item.getMachadoBronze();
					quantAxeOuro += item.getMachadoOuro();
				}			
			}

			System.out.println("A quantidade de ouro: " + somaOuro);
			System.out.println("A quantidade de diamantes: " + somaDiamante);	
			System.out.println("A quantidade de potions: " + quantPot);
			System.out.println("A quantidade de chaves: " + quantKey);
			if(quantAxeFerro> 0){
				System.out.println("Contém um machado de ferro.");
			}
			if(quantAxeBronze > 0){
				System.out.println("Contém um machado de bronze.");
			}
			if(quantAxeOuro > 0){
				System.out.println("Contém um machado de ouro.");
			}
		
			for (int i = 0; i < troll.size(); i++){
				if(troll.get(i).getComodoAtual().equals(jogador.getComodoAtual()) && troll.get(i).isVivo() == true){
					System.out.println("Troll na sala:" + troll.get(i).getNt());
				}
			}
		}else{
			Corredor.viewCorredor((Corredor)jogador.getComodoAtual());
		}
			
	}
}