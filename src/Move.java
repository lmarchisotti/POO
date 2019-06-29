import java.util.ArrayList;

public class Move {
	
	public int comeca(Salas sala) {
		int salaLocal = sala.getSalasId();
		return salaLocal;
	}

	public int moveTo(Mapa map, String door, Comodo comodo, Jogador jogador) {
		if ((comodo.getIsSala()) && ((Salas) comodo).getSalasId() == 3 && door.equals("C")) {
			System.out.println("FIM DE JOGO");
			viewBag(jogador);
		} else {
			
			// moveTo - percorre cada porta pra ver se alguma bate com a especificada.
			Portas porta = null;
			for (Portas p : comodo.getPortas()) {
				if (p.getNome() == door.charAt(0)) {
					porta = p;
					break;
				}
			}
			if (porta == null) {
				
				// Nao tem porta com identificador especificado.
				System.out.println("Nao existe porta para (" + door + ").");
				return 0;
				
			} else {
				
				// Verifica se o jogador esta num corredor ou na sala.
				if (jogador.getComodoAtual().getIsSala()) {
					
					// Esta numa sala, mandar pro corredor.
					if (porta.getSalaTrancada()) {
						if (jogador.getMochila().getBagKey() > 0) {
						
							if (door.equals("A")) {
								((Salas) jogador.getComodoAtual()).getPortas().get(0).setSalaTrancada(false);
								jogador.getMochila().setBagKey(jogador.getMochila().getBagKey() - 1);
							} else if (door.equals("B")) {
								((Salas) jogador.getComodoAtual()).getPortas().get(1).setSalaTrancada(false);
								jogador.getMochila().setBagKey(jogador.getMochila().getBagKey() - 1);
							} else if (door.equals("C")) {
								((Salas) jogador.getComodoAtual()).getPortas().get(2).setSalaTrancada(false);
								jogador.getMochila().setBagKey(jogador.getMochila().getBagKey() - 1);
							}
							
							System.out.println("Porta destrancada!");
							jogador.setComodoAtual(Corredor.getCorredorByIdentificador(map.getComodos(), porta.getSaida()));
						} else {
							System.out.println("Porta esta trancada e voce nao possui chave.");
							return 0;
						}
					} else {
						jogador.setComodoAtual(Corredor.getCorredorByIdentificador(map.getComodos(), porta.getSaida()));
					}

				} else {
					// Se esta em algum corredor, manda pra sala.
					jogador.setComodoAtual(Salas.getSalaByIdentificador(map.getComodos(), porta.getEntrada()));
				}
			}

		}
		return 1;
	}

	public void pickUpGold(Mapa map, Jogador jogador) {
		int somaOuro = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					somaOuro += item.getOuro();
				}
			}
			
			if (somaOuro == 0) {
				System.out.println("Nao ha ouro na sala");
			} else {
				jogador.getMochila().setOuro(jogador.getMochila().getOuro() + somaOuro);
				System.out.println("Quantidade de ouro coletado na sala: " + somaOuro);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomOuro(0, 0);
					}
				}
			}
		} else {
			System.out.println("Voce esta em um corredor. Nao existe este item aqui.");
		}
	}

	public void pickUpDiamante(Mapa map, Jogador jogador) {
		int somaDiamante = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					somaDiamante += item.getDiamond();
				}
			}
			
			if (somaDiamante == 0) {
				System.out.println("Nao ha diamante nesta sala");
			} else {
				jogador.getMochila().setDiamond(jogador.getMochila().getDiamante() + somaDiamante);
				System.out.println("Quantidade de diamantes coletados na sala: " + somaDiamante);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomDiamante(0, 0);
					}
				}
			}
		} else {
			System.out.println("Voce esta em um corredor. Nao existe este item aqui.");
		}
	}

	public void pickUpPotion(Mapa map, Jogador jogador) {
		int quantChaves = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					quantChaves += item.getPot();
				}
			}
			if (quantChaves == 0) {
				System.out.println("Nao ha pocao nesta sala");
			} else {

				jogador.getMochila().setBagPot(jogador.getMochila().getBagPot() + quantChaves);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomPot(0, 0);
					}
				}

				System.out.println("Quantidade de itens na bag de potions: " + jogador.getMochila().getBagPot());
			}
		} else {
			System.out.println("Voce esta em um corredor. Nao existe este item aqui.");
		}

	}

	public void pickUpKey(Mapa map, Jogador jogador) {
		int quantChaves = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					quantChaves += item.getChave();
				}
			}
			if (quantChaves == 0) {
				System.out.println("Nao ha chave nesta sala");
			} else {

				jogador.getMochila().setBagKey(jogador.getMochila().getBagKey() + quantChaves);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomChave(0, 0);
					}
				}

				System.out.println("Quantidade de itens na bag de chaves: " + jogador.getMochila().getBagKey());
			}
		} else {
			System.out.println("Voce esta em um corredor. Nao existe este item aqui.");
		}
	}

	public void pickUpAxe(Mapa map, Jogador jogador) {
		int quantAxe = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					quantAxe += item.getMachado();
				}
			}
			if (quantAxe == 0) {
				System.out.println("Nao ha machado nesta sala");
			} else {
				jogador.getMochila().setBagAxe(jogador.getMochila().getBagAxe() + quantAxe);
				jogador.getMochila().setBagAxe(jogador.getMochila().getBagAxe() + quantAxe);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setMachado(0);
					}
				}
				System.out.println("Quantidade de itens na bag: " + jogador.getMochila().getBagAxe());
			}
		} else {
			System.out.println("Voce esta em um corredor. Nao existe este item aqui.");
		}
	}

	public void viewBag(Jogador jogador) {

		System.out.println("A quantidade de ouro coletado: " + jogador.getMochila().getOuro());
		System.out.println("A quantidade de diamantes coletado: " + jogador.getMochila().getDiamante());
		System.out.println("A quantidade de potions na bag: " + jogador.getMochila().getBagPot());
		System.out.println("A quantidade de chaves na bag: " + jogador.getMochila().getBagKey());
		System.out.println("A quantidade de machados na bag: " + jogador.getMochila().getBagAxe());
		if (jogador.getMochila().getBagAxe() >= 1) {
			System.out.println("Possui " + jogador.getMochila().getBagAxe() + " machado(s).");
		}
	}

	public void dropPotion(Mapa map, Jogador jogador) {
		if (jogador.getMochila().getBagPot() == 0) {
			System.out.println("Nao ha pocao na bag");
		} else {
			jogador.getMochila().setBagPot(jogador.getMochila().getBagPot() - 1);
			((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setPot();
			System.out.println("Quantidade de potions dropada na sala: "
					+ ((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getPot());
		}

	}

	public void dropKey(Mapa map, Jogador jogador) {
		if (jogador.getMochila().getBagKey() == 0) {
			System.out.println("Nao ha chaves na bag");
		} else {
			jogador.getMochila().setBagKey(jogador.getMochila().getBagKey() - 1);
			((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setChave();
			System.out.println("Quantidade de chaves dropada na sala: "
					+ ((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getChave());
		}

	}

	public void dropAxe(Mapa map, Jogador jogador) {
		if (jogador.getComodoAtual().getIsSala()) {
			if (jogador.getMochila().getBagAxe() == 0) {
				System.out.println("Nao ha machados na bag");
			} else {
				jogador.getMochila().setBagAxe(jogador.getMochila().getBagAxe() - 1);
				jogador.getMochila().setBagAxe(jogador.getMochila().getBagAxe() - 1);
				((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setRandomMachado(1, 1);
			}
		} else {
			System.out.println("Voce esta em um corredor. Nao existe este item aqui.");
		}
	}

	public void throwAxe(Mapa map, Jogador jogador, String NomeTroll) {
			jogador.getMochila().setBagAxe(jogador.getMochila().getBagAxe() - 1);
			jogador.getMochila().setBagAxe(jogador.getMochila().getBagAxe() - 1);
			System.out.println("Matou um troll: " + NomeTroll);
	}

	public void moveTroll(Mapa map, ArrayList<Trolls> trolls, Jogador jogador) {
		int quantAxe;
		for (int i = 0; i < trolls.size(); i++){
			quantAxe = 0;
	
			for (int j = 0; j < ((Salas) trolls.get(i).getComodoAtual()).getPisos().size(); j++) {
				for (Itens item : ((Salas) trolls.get(i).getComodoAtual()).getPisos().get(j).getItens()) {
					quantAxe += item.getMachado();
				}
			}
			
			if (quantAxe > 0 && trolls.get(i).getComodoAtual() == jogador.getComodoAtual()) {
				for (int j = 0; j < ((Salas) jogador.getComodoAtual()).getPisos().size(); j++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(j).getItens()) {
						item.setMachado(0);
					}
				}	
				if (jogador.getMochila().getBagPot() == 0) {
					jogador.getMochila().setOuro(0);
					jogador.getMochila().setDiamond(0);
					System.out.println("Troll te atacou e voce nao tinha pocao. Perdeu ouro e diamante!");
				} else {
					jogador.getMochila().setBagPot(jogador.getMochila().getBagPot() - 1);
					System.out.println("Troll te atacou e voce tinha pocao. Perdeu 1 pocao!");
				}
			}
		}
	}
	
}