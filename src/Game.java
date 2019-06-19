import java.util.ArrayList;
import java.util.Scanner;

import InterfaceGrafica.Janela;

public class Game extends Janela {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Janela janela = new Janela();
		ArrayList<Comodo> comodos = Comodo.startCenario("entradas/mapa1.json");
		Mapa map = new Mapa();
		map.setComodos(comodos);

		Move movimento = new Move();
		Jogador jogador = new Jogador();
		jogador.setComodoAtual(Salas.getSalaByIdentificador(comodos, 3));
		jogador.setBagAxe(0);
		jogador.setBagKey(0);
		jogador.setBagPot(0);
		
		ArrayList<Trolls> troll = new ArrayList<Trolls>();
		Trolls troll1 = new Trolls("TrolldaCaverna", map.getComodos().get(2), true); troll.add(troll1);
		Trolls troll2 = new Trolls("TrolldaCaverna", map.getComodos().get(4), true); troll.add(troll2);
		Trolls troll3 = new Trolls("TrolldaCaverna", map.getComodos().get(5), true); troll.add(troll3);
		Trolls troll4 = new Trolls("TrollGuerreiro", map.getComodos().get(8), true); troll.add(troll4);
		Trolls troll5 = new Trolls("TrollGuerreiro", map.getComodos().get(10), true); troll.add(troll5);
		Trolls troll6 = new Trolls("TrollGuerreiro", map.getComodos().get(14), true); troll.add(troll6);
			
		int x = 0;
		String ler;
		String[] palavra = new String[3];
		String[] palavra2 = new String[3];
		while (true) {
			x = 0;
			// Exibe as poções na interface gráfica
			if (jogador.getComodoAtual().getIsSala()) {
				if (((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getPot() > 0) {
					janela.setLabelPotion(janela, true);
				} else {
					janela.setLabelPotion(janela, false);
				}
			} else {
				janela.setLabelPotion(janela, false);
			}
			if (jogador.getBagPot() > 0) {
				janela.setLabelPotionJogador(janela, true, jogador.getBagPot());
			} else {
				janela.setLabelPotionJogador(janela, false, 0);
			}
			// Exibe as chaves na interface gráfica
			if (jogador.getComodoAtual().getIsSala()) {
				if (((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getChave() > 0) {
					janela.setLabelKey(janela, true);
				} else {
					janela.setLabelKey(janela, false);
				}
			} else {
				janela.setLabelKey(janela, false);
			}
			if (jogador.getBagKey() > 0) {
				janela.setLabelKeyJogador(janela, true, jogador.getBagKey());
			} else {
				janela.setLabelKeyJogador(janela, false, 0);
			}
			// Exibe o machado na interface grafica
			if (jogador.getComodoAtual().getIsSala()) {
				if (((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getMachadoFerro() > 0) {
					janela.setLabelMacFerro(janela, true);
				} else {
					janela.setLabelMacFerro(janela, false);
				}
			} else {
				janela.setLabelMacFerro(janela, false);
			}
			if (jogador.getBagAxeFerro() > 0) {
				janela.setLabelMacFerroJogador(janela, true, jogador.getBagAxeFerro());
			} else {
				janela.setLabelMacFerroJogador(janela, false, 0);
			}
			
			// Exibe as pecas de ouro na interface grafica
			int somaOuro = 0;
			int somaDiamante = 0;
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
			if (jogador.getOuro() > 0) {
				janela.setLabelGoldJogador(janela, true, jogador.getOuro());
			} else {
				janela.setLabelGoldJogador(janela, false, 0);
			}
			// Exibe as peças de diamante na interface gráfica
			if (somaDiamante > 0) {
				janela.setLabelDiamond(janela, true, somaDiamante);
			} else {
				janela.setLabelDiamond(janela, false, 0);
			}
			if (jogador.getDiamante() > 0) {
				janela.setLabelDiamondJogador(janela, true, jogador.getDiamante());
			} else {
				janela.setLabelDiamondJogador(janela, false, 0);
			}
			// Exibe o troll da sala
			janela.setLabelTroll(janela, false);
			for(int i = 0; i < troll.size(); i++){
				if ((troll.get(i).getComodoAtual() == jogador.getComodoAtual()) && troll.get(i).isVivo()){
					janela.setLabelTroll(janela, true);
				}
			}

			ler = scanner.nextLine();
			palavra = ler.split(" ");
			for (Trolls t : troll) {
				if (jogador.getComodoAtual().equals(t.getComodoAtual()) && t.isVivo() == true){
					x = 1;
				}
			}
			//System.out.println(ler.toString());
			if (palavra[0].equals("view")) {

				comodos.get(0).view(jogador, troll);
			}

			else if (palavra[0].equals("moveTo")) {
				ler = scanner.nextLine();
				palavra2 = ler.split(" ");
				if (palavra[1].equals("A") || palavra[1].equals("B") || palavra[1].equals("C")) {
					if (palavra2[0].equals("Exit")) {
						movimento.moveTo(map, palavra[1], jogador.getComodoAtual(), jogador);
						movimento.moveTroll(map, troll, jogador);
					}
				} else if (palavra[1].equals("Gold") || palavra[1].equals("Diamante") || palavra[1].equals("AxeFerro")
						|| palavra[1].equals("AxeBronze") || palavra[1].equals("AxeOuro") || palavra[1].equals("Pot")
						|| palavra[1].equals("Key")) {
					if (palavra2[0].equals("pickUp")) {

						if (palavra2[1].equals("Gold")) {
							if (x != 1) {
								movimento.pickUpGold(map, jogador);
							} else {
								System.out.println("Nao pode pegar ouro");
							}
						}

						if (palavra2[1].equals("Diamante")) {
							if (x != 1) {
								movimento.pickUpDiamante(map, jogador);
							} else {
								System.out.println("Nao pode pegar diamante");
							}
						}

						if (palavra2[1].equals("AxeFerro")) {
							if (jogador.getBagAxe() < 4) {
								movimento.pickUpAxeFerro(map, jogador);
							} else {
								System.out.println("Bag de machados cheia");
							}
						}

						if (palavra2[1].equals("AxeBronze")) {
							if (jogador.getBagAxe() < 4) {
								movimento.pickUpAxeBronze(map, jogador);
							} else {
								System.out.println("Bag de machados cheia");
							}
						}

						if (palavra2[1].equals("AxeOuro")) {
							if (jogador.getBagAxe() < 4) {
								movimento.pickUpAxeOuro(map, jogador);
							} else {
								System.out.println("Bag de machados cheia");
							}
						}

						if (palavra2[1].equals("Key")) {
							if (jogador.getBagKey() < 3) {
								movimento.pickUpKey(map, jogador);
							} else {
								System.out.println("Bag de chaves cheia");
							}
						}
						if (palavra2[1].equals("Pot")) {
							if (jogador.getBagPot() < 3) {
								movimento.pickUpPotion(map, jogador);
							} else {
								System.out.println("Bag de poçoes cheia");
							}
						}
					}
				}
			} else if (palavra[0].equals("drop")) {
				if (palavra[1].equals("Pot")) {
					movimento.dropPotion(map, jogador);
				} else if (palavra[1].equals("Key")) {
					movimento.dropKey(map, jogador);
				} else if (palavra[1].equals("AxeFerro")) {
					movimento.dropAxeFerro(map, jogador);
				} else if (palavra[1].equals("AxeBronze")) {
					movimento.dropAxeBronze(map, jogador);
				} else if (palavra[1].equals("AxeOuro")) {
					movimento.dropAxeOuro(map, jogador);
				}

			} else if (palavra[0].equals("viewBag")) {
				movimento.viewBag(jogador);
			} else if (palavra[0].equals("throwAxeFerro")) {
				if (palavra[1].equals("TrollGuerreiro") || palavra[1].equals("TrolldaCaverna")) {
					
					if (jogador.getBagAxeFerro() == 0) {
						System.out.println("Não há machados de ferro na bag");
					} else {
						movimento.throwAxeFerro(map, jogador, palavra[1]);
						for(int i = 0; i < troll.size(); i++){
							if (troll.get(i).getComodoAtual() == jogador.getComodoAtual()){
								troll.get(i).setVivo(false);
							}
						}
					}
				}
			} else if (palavra[0].equals("throwAxeBronze")) {
				if (palavra[1].equals("TrollGuerreiro") || palavra[1].equals("TrolldaCaverna")) {
					if (jogador.getBagAxeBronze() == 0) {
						System.out.println("Não há machados de bronze na bag");
					} else {
						movimento.throwAxeBronze(map, jogador, palavra[1]);
						for(int i = 0; i < troll.size(); i++){
							if (troll.get(i).getComodoAtual() == jogador.getComodoAtual()){
								troll.get(i).setVivo(false);
							}
						}
					}
				}
			} else if (palavra[0].equals("throwAxeOuro")) {
				if (palavra[1].equals("TrollGuerreiro") || palavra[1].equals("TrolldaCaverna")) {
					if (jogador.getBagAxeOuro() == 0) {
						System.out.println("Não há machados de bronze na bag");
					} else {
						movimento.throwAxeOuro(map, jogador, palavra[1]);
						for(int i = 0; i < troll.size(); i++){
							if (troll.get(i).getComodoAtual() == jogador.getComodoAtual()){
								troll.get(i).setVivo(false);
							}
						}
					}
				}
			} else if (palavra[0].equals("unlock")) {
				if (palavra[1].equals("A") || palavra[1].equals("B") || palavra[1].equals("C")) {
					movimento.unlock(map, jogador, palavra[1]);
				}
			} else {
				System.out.print("\nComando inválido\n");
			}
		}
	}
}
