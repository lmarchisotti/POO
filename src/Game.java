
import java.util.ArrayList;
import java.util.Scanner;

import InterfaceGrafica.Janela;

public class Game extends Janela {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Janela janela = new Janela();
		ArrayList<Comodo> comodos = Comodo.startCenario("entradas/mapa1.json");
		Mapa map = new Mapa();
		map.setComodos(comodos);
		Jogador jogador = new Jogador();
		
		jogador.setComodoAtual(Salas.getSalaByIdentificador(comodos, 1)); // Define a sala inicial do game.
		
		// Seta a mochila do jogador para 0.
		jogador.getMochila().setBagAxe(0);
		jogador.getMochila().setBagKey(0);
		jogador.getMochila().setBagPot(0);
		
		// Adiciona trolls na lista de trolls e nas salas. (Posi��o das salas � iniciada em "0")
		ArrayList<Trolls> troll = new ArrayList<Trolls>();
		Trolls troll1 = new Trolls("TrolldaCaverna", map.getComodos().get(1), true);
		troll.add(troll1);
		Trolls troll2 = new Trolls("TrolldaCaverna", map.getComodos().get(2), true);
		troll.add(troll2);
		Trolls troll3 = new Trolls("TrolldaCaverna", map.getComodos().get(4), true);
		troll.add(troll3);
		Trolls troll4 = new Trolls("TrollGuerreiro", map.getComodos().get(11), true);
		troll.add(troll4);
		Trolls troll5 = new Trolls("TrollGuerreiro", map.getComodos().get(13), true);
		troll.add(troll5);
		Trolls troll6 = new Trolls("TrollGuerreiro", map.getComodos().get(18), true);
		troll.add(troll6);
		
		for(int i = 0; i < troll.size(); i++){
			System.out.println(troll.get(i).getComodoAtual());
		}
		
		while (true) {
			
			// Exibe todos os itens presente na interface.
			exibeItensInterface(jogador, janela, troll);

			// Comandos para jogar o game.
			comandos(jogador, comodos, troll, map);
		
		}
		
	}
	
	private static void exibeItensInterface(Jogador jogador, Janela janela, ArrayList<Trolls> troll) {
		
		int somaOuro = 0;
		int somaDiamante = 0;
		
		// Exibe a id da Sala.
		if (jogador.getComodoAtual() instanceof Salas) {
			Salas comodo = (Salas)jogador.getComodoAtual();
			janela.setIdSala(janela, comodo.getSalasId());
		} else {
			janela.setIdSala(janela, 0); // "0" mostra que esta no corredor.
		}
					
		// Exibe as pocoes na interface grafica
		if (jogador.getComodoAtual().getIsSala()) {
			if (((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getPot() > 0) {
				janela.setLabelPotion(janela, true);
			} else {
				janela.setLabelPotion(janela, false);
			}
		} else {
			janela.setLabelPotion(janela, false);
		}
		janela.setLabelPotionJogador(janela, true, jogador.getMochila().getBagPot());
					
		// Exibe as chaves na interface grafica
		if (jogador.getComodoAtual().getIsSala()) {
			if (((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getChave() > 0) {
				janela.setLabelKey(janela, true);
			} else {
				janela.setLabelKey(janela, false);
			}
		} else {
			janela.setLabelKey(janela, false);
		}
		janela.setLabelKeyJogador(janela, true, jogador.getMochila().getBagKey());
					
		// Exibe o machado na interface grafica
		if (jogador.getComodoAtual().getIsSala()) {
			if (((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getMachado() > 0) {
				janela.setLabelMac(janela, true);
			} else {
				janela.setLabelMac(janela, false);
			}
		} else {
			janela.setLabelMac(janela, false);
		}
		janela.setLabelMachadoJogador(janela, true, jogador.getMochila().getBagAxe());
		
		// Exibe as pecas de ouro na interface grafica
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					somaOuro += item.getOuro();
					somaDiamante += item.getDiamond();
				}
			}
			if (somaOuro > 0) {
				janela.setLabelGold(janela, true, somaOuro);
			} else {
				janela.setLabelGold(janela, false, 0);
			}
		} else {
			janela.setLabelGold(janela, false, 0);
		}
		janela.setLabelGoldJogador(janela, true, jogador.getMochila().getOuro());
					
		// Exibe as pecas de diamante na interface grafica
		if (somaDiamante > 0) {
			janela.setLabelDiamond(janela, true, somaDiamante);
		} else {
			janela.setLabelDiamond(janela, false, 0);
		}
		janela.setLabelDiamondJogador(janela, true, jogador.getMochila().getDiamante());
					
		// Exibe o troll da sala
		janela.setLabelTroll(janela, false);
		for(int i = 0; i < troll.size(); i++){
			if ((troll.get(i).getComodoAtual() == jogador.getComodoAtual()) && troll.get(i).trollVivo()){
				janela.setLabelTroll(janela, true);
			}
		}
		
	}
	
	private static void comandos(Jogador jogador, ArrayList<Comodo> comodos, ArrayList<Trolls> troll, Mapa map) {
		
		Scanner scanner = new Scanner(System.in);
		
		int x = 0;
		String ler;
		String[] palavra = new String[3];
		String[] palavra2 = new String[3];
		Move movimento = new Move();
		
		ler = scanner.nextLine();
		palavra = ler.split(" ");
		for (Trolls t : troll) {
			if (jogador.getComodoAtual().equals(t.getComodoAtual()) && t.trollVivo() == true){
				x = 1;
			}
		}
		
		if (palavra[0].equals("view")) {
			comodos.get(0).view(jogador, troll);
		} else if (palavra[0].equals("moveTo")) {
			if (palavra[1].equals("A") || palavra[1].equals("B") || palavra[1].equals("C")) {
				try {
					if (palavra[2].equals("door")) {
						movimento.moveTo(map, palavra[1], jogador.getComodoAtual(), jogador);
						movimento.moveTroll(map, troll, jogador);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Nao pode ir para a porta");
				}
			} else if (palavra[1].equals("gold") || palavra[1].equals("diamond") || palavra[1].equals("axe") || palavra[1].equals("pot") || palavra[1].equals("key")) {
				ler = scanner.nextLine();
				palavra2 = ler.split(" ");
				if (palavra2[0].equals("pickUp")) {

					if (palavra2[1].equals("gold")) {
						if (x != 1) {
							movimento.pickUpGold(map, jogador);
						} else {
							System.out.println("Nao pode pegar ouro");
						}
					}

					if (palavra2[1].equals("diamond")) {
						if (x != 1) {
							movimento.pickUpDiamante(map, jogador);
						} else {
							System.out.println("Nao pode pegar diamante");
						}
					}

					if (palavra2[1].equals("axe")) {
						if (jogador.getMochila().getBagAxe() < 4) {
							movimento.pickUpAxe(map, jogador);
						} else {
							System.out.println("Mochila de machados cheia");
						}
					}

					if (palavra2[1].equals("key")) {
						if (jogador.getMochila().getBagKey() < 3) {
							movimento.pickUpKey(map, jogador);
						} else {
							System.out.println("Mochila de chaves cheia");
						}
					}
								
					if (palavra2[1].equals("pot")) {
						if (jogador.getMochila().getBagPot() < 3) {
							movimento.pickUpPotion(map, jogador);
						} else {
							System.out.println("Mochila de pocoes cheia");
						}
					}
								
				}
			}
		} else if (palavra[0].equals("drop")) {
			if (palavra[1].equals("pot")) {
				movimento.dropPotion(map, jogador);
			} else {
				if (palavra[1].equals("key")) {
					movimento.dropKey(map, jogador);
				} else {
					if (palavra[1].equals("axe")) {
						movimento.dropAxe(map, jogador);
					}
				}
			}

		} else if (palavra[0].equals("viewBag")) {
			movimento.viewBag(jogador);
		} else if (palavra[0].equals("throwAxe")) {
			if (palavra[1].equals("TrollGuerreiro") || palavra[1].equals("TrolldaCaverna")) {

				if (jogador.getMochila().getBagAxe() == 0) {
					System.out.println("Nao ha machados na bag");
				} else {
					movimento.throwAxe(map, jogador, palavra[1]);
					for(int i = 0; i < troll.size(); i++){
						if (troll.get(i).getComodoAtual() == jogador.getComodoAtual()){
							troll.get(i).setVivo(false);
						}
					}
				}
			}
		} else {
			System.out.print("\nComando invalido\n");
		}
		
	}
	
}