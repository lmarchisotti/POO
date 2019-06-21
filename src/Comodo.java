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

		int qtdeMaximaMachado = 1;
		int qtdeGeradaMachado = 0;
		
		JSONParser parser = new JSONParser();
		ArrayList<Comodo> comodos = new ArrayList<Comodo>();
		
		// Leitura do arquivo de configuracao do json
		Reader in = new InputStreamReader(Game.class.getResourceAsStream(caminhoarquivo));
		JSONObject json;
		
		try {
			// Gera as salas.
			json = (JSONObject) parser.parse(in);
			ArrayList<Integer> tamanhosGerados = new ArrayList<Integer>();
			
			JSONObject jsonSalas = (JSONObject) json.get("salas");
			JSONObject jsonCorredores = (JSONObject) json.get("corredores");
			
			for(int i = 1; i <= jsonSalas.size(); i++){
			
				JSONObject jsonSala = (JSONObject) jsonSalas.get(String.valueOf(i));
				Salas sala = new Salas();
				
				Integer idSala = new Integer((String) jsonSala.get("id"));
				sala.setSalasId(idSala.intValue());
				
				sala.setPortas(new ArrayList<Portas>());
				JSONObject jsonPortas = (JSONObject) jsonSala.get("portas");
				
				// Sorteia quantas posicoes tera a sala.
				sala.setTamanho(0);
				Integer tamanho = new Integer(random.nextInt(100/2)*2+2); // Gerando de 2 a 20 posicoes.
				
				while(tamanhosGerados.contains(tamanho)){
					tamanho = new Integer(random.nextInt(100/2)*2+2); // Gerando de 2 a 20 posicoes.
				}
				
				sala.setTamanho(tamanho);
				tamanhosGerados.add(tamanho);			
				sala.setPisos(new ArrayList<Pisos>());

				for(int x = 0; x < sala.getTamanho() / 2; x++){ // Percorre 10 posicoes relacionadas ao "x".
					for(int y = 0; y < sala.getTamanho() / 2; y++){ // Percorre 10 posicoes relacionadas ao "y".
						Pisos p = new Pisos();					
						p.setX(x);
						p.setY(y);
						p.setItens(new ArrayList<Itens>());
						Itens itens = new Itens();
						
						// Sorteia os objetos que nao precisam ser sorteados em todos os quadrados.
						if(x == 0 && y == 0){
							itens.setRandomPot(0, 1);
							
							itens.setRandomMachado(0,1);
							if(qtdeGeradaMachado < qtdeMaximaMachado){
								qtdeGeradaMachado += itens.setRandomMachado(0, 1);
							}
							itens.setRandomChave(0,1);
						}
						
						// Sorteia ouro e diamante.
						itens.setRandomOuro(0, 5);
						itens.setRandomDiamante(0, 5);

						// Adiciona os itens na lista de itens "p".
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
			
			System.out.println("teste:"+jsonCorredores.size());
			for(int i = 1; i <= jsonCorredores.size(); i++){
				
				JSONObject jsonCorredor = (JSONObject) jsonCorredores.get(String.valueOf(i));
				Corredor corredor = new Corredor();
				corredor.setId(jsonCorredor.get("id").toString());
				ArrayList<Portas> portas = new ArrayList<Portas>();
				JSONObject jsonPortas = (JSONObject) jsonCorredor.get("portas");
				for(int j=1;j<=jsonPortas.size();j++){
					//aqui devo procurar a porta correspondente que ja foi criada no momento da inicializacao das salas
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
			// 
			e.printStackTrace();
		} catch (ParseException e) {
			// 
			e.printStackTrace();
		}
		
		return comodos;
	}
	
	public void view(Jogador jogador, ArrayList<Trolls> troll){

		int somaOuro = 0;
		int somaDiamante = 0;
		int quantPot = 0;
		int quantKey = 0;
		int quantAxe = 0;
		if(jogador.getComodoAtual().getIsSala()){
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++){
				for(Itens item:((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()){
					somaOuro += item.getOuro();
					somaDiamante += item.getDiamond();
					quantPot += item.getPot();
					quantKey += item.getChave();
					quantAxe += item.getMachado();
				}
			}

			System.out.println("A quantidade de ouro: " + somaOuro);
			System.out.println("A quantidade de diamantes: " + somaDiamante);	
			System.out.println("A quantidade de potions: " + quantPot);
			System.out.println("A quantidade de chaves: " + quantKey);
			if(quantAxe> 0){
				System.out.println("Contem um machado.");
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