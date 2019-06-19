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
			// percorro cada porta pra ver se alguma bate com a especificada no
			// moveTo
			Portas porta = null;
			for (Portas p : comodo.getPortas()) {
				if (p.getNome() == door.charAt(0)) {
					porta = p;
					break;
				}
			}
			if (porta == null) {
				// nao tem porta com identificador especificado
				System.out.println("Não existe nenhuma porta com o identificador especificado. (" + door + ")");
				return 0;
			} else {
				// verificar se o jogador está num corredor ou na sala
				if (jogador.getComodoAtual().getIsSala()) {
					// esta numa sala, mandar esse bosta pro corredor
					if (porta.getSalaTrancada()) {
						if (jogador.getBagKey() > 0) {
						
							if (door.equals("A")) {
								((Salas) jogador.getComodoAtual()).getPortas().get(0).setSalaTrancada(false);
								jogador.setBagKey(jogador.getBagKey() - 1);
							} else if (door.equals("B")) {
								((Salas) jogador.getComodoAtual()).getPortas().get(1).setSalaTrancada(false);
								jogador.setBagKey(jogador.getBagKey() - 1);
							}
							
							System.out.println("Porta destrancada!");
							jogador.setComodoAtual(
									Corredor.getCorredorByIdentificador(map.getComodos(), porta.getSaida()));
						} else {
							System.out.println("Porta está trancada e você não possui chave.");
							return 0;
						}
					} else {
						jogador.setComodoAtual(Corredor.getCorredorByIdentificador(map.getComodos(), porta.getSaida()));
					}

				} else {
					// esta num corredor, manda ele pra sala
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
			// lembrar que aqui tem que percorrer todos os pisos da sala atual
			if (somaOuro == 0) {
				System.out.println("Nao ha ouro na sala");
			} else {
				jogador.setOuro(jogador.getOuro() + somaOuro);
				System.out.println("Quantidade de ouro coletado na sala: " + somaOuro);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomOuro(0, 0);
					}
				}
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
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
			// lembrar que aqui tem que percorrer todos os pisos da sala atual
			if (somaDiamante == 0) {
				System.out.println("N�o h� diamante nesta sala");
			} else {
				jogador.setDiamante(jogador.getDiamante() + somaDiamante);
				System.out.println("Quantidade de diamantes coletados na sala: " + somaDiamante);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomDiamante(0, 0);
					}
				}
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
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
				System.out.println("N�o h� pocao nesta sala");
			} else {

				jogador.setBagPot(jogador.getBagPot() + quantChaves);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomPot(0, 0);
					}
				}

				System.out.println("Quantidade de itens na bag de potions: " + jogador.getBagPot());
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
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

				jogador.setBagKey(jogador.getBagKey() + quantChaves);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setRandomChave(0, 0);
					}
				}

				System.out.println("Quantidade de itens na bag de chaves: " + jogador.getBagKey());
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
		}
	}

	public void pickUpAxeFerro(Mapa map, Jogador jogador) {
		int quantAxe = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					quantAxe += item.getMachadoFerro();
				}
			}
			if (quantAxe == 0) {
				System.out.println("Não há machado de ferro nesta sala");
			} else {
				jogador.setBagAxe(jogador.getBagAxe() + quantAxe);
				jogador.setBagAxeFerro(jogador.getBagAxeFerro() + quantAxe);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setMachadoFerro(0);
					}
				}
				System.out.println("Quantidade de itens na bag: " + jogador.getBagAxe());
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
		}
	}

	public void pickUpAxeBronze(Mapa map, Jogador jogador) {
		int quantAxe = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					quantAxe += item.getMachadoBronze();
				}
			}
			if (quantAxe == 0) {
				System.out.println("N�o h� machado de bronze nesta sala");
			} else {
				jogador.setBagAxe(jogador.getBagAxe() + quantAxe);
				jogador.setBagAxeBronze(jogador.getBagAxeBronze() + quantAxe);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setMachadoBronze(0);
					}
				}
				System.out.println("Quantidade de itens na bag: " + jogador.getBagAxe());
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
		}
	}

	public void pickUpAxeOuro(Mapa map, Jogador jogador) {
		int quantAxe = 0;
		if (jogador.getComodoAtual().getIsSala()) {
			for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
				for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
					quantAxe += item.getMachadoOuro();
				}
			}
			if (quantAxe == 0) {
				System.out.println("N�o h� machado de ouro nesta sala");
			} else {
				jogador.setBagAxe(jogador.getBagAxe() + quantAxe);
				jogador.setBagAxeOuro(jogador.getBagAxeOuro() + quantAxe);
				for (int i = 0; i < ((Salas) jogador.getComodoAtual()).getPisos().size(); i++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(i).getItens()) {
						item.setMachadoOuro(0);
					}
				}
				System.out.println("Quantidade de itens na bag: " + jogador.getBagAxe());
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
		}
	}

	public void viewBag(Jogador jogador) {

		System.out.println("A quantidade de ouro coletado: " + jogador.getOuro());
		System.out.println("A quantidade de diamantes coletado: " + jogador.getDiamante());
		System.out.println("A quantidade de potions na bag: " + jogador.getBagPot());
		System.out.println("A quantidade de chaves na bag: " + jogador.getBagKey());
		System.out.println("A quantidade de machados na bag: " + jogador.getBagAxe());
		if (jogador.getBagAxeFerro() >= 1) {
			System.out.println("Possui " + jogador.getBagAxeFerro() + " machado de ferro.");
		}
		if (jogador.getBagAxeBronze() >= 1) {
			System.out.println("Possui " + jogador.getBagAxeBronze() + " machado de bronze.");
		}
		if (jogador.getBagAxeOuro() >= 1) {
			System.out.println("Possui " + jogador.getBagAxeOuro() + " machado de ouro.");
		}
	}

	public void dropPotion(Mapa map, Jogador jogador) {
		if (jogador.getBagPot() == 0) {
			System.out.println("N�o h� pocao na bag");
		} else {
			jogador.setBagPot(jogador.getBagPot() - 1);
			((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setPot();
			System.out.println("Quantidade de potions dropada na sala: "
					+ ((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getPot());
		}

	}

	public void dropKey(Mapa map, Jogador jogador) {
		if (jogador.getBagKey() == 0) {
			System.out.println("N�o h� chaves na bag");
		} else {
			jogador.setBagKey(jogador.getBagKey() - 1);
			((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setChave();
			System.out.println("Quantidade de chaves dropada na sala: "
					+ ((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).getChave());
		}

	}

	public void dropAxeFerro(Mapa map, Jogador jogador) {
		if (jogador.getComodoAtual().getIsSala()) {
			if (jogador.getBagAxeFerro() == 0) {
				System.out.println("Não há machados de ferro na bag");
			} else {
				jogador.setBagAxe(jogador.getBagAxe() - 1);
				jogador.setBagAxeFerro(jogador.getBagAxeFerro() - 1);
				((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setRandomMachadoFerro(1, 1);
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
		}
	}

	public void dropAxeBronze(Mapa map, Jogador jogador) {
		if (jogador.getComodoAtual().getIsSala()) {
			if (jogador.getBagAxeBronze() == 0) {
				System.out.println("Não há machados de bronze na bag");
			} else {
				jogador.setBagAxe(jogador.getBagAxe() - 1);
				jogador.setBagAxeBronze(jogador.getBagAxeBronze() - 1);
				((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setRandomMachadoBronze(1, 1);
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
		}
	}

	public void dropAxeOuro(Mapa map, Jogador jogador) {
		if (jogador.getComodoAtual().getIsSala()) {
			if (jogador.getBagAxeOuro() == 0) {
				System.out.println("Não há machados de ouro na bag");
			} else {
				jogador.setBagAxe(jogador.getBagAxe() - 1);
				jogador.setBagAxeOuro(jogador.getBagAxeOuro() - 1);
				((Salas) jogador.getComodoAtual()).getPisos().get(0).getItens().get(0).setRandomMachadoOuro(1, 1);
			}
		} else {
			System.out.println("Você está em um corredor. Não existe este item aqui.");
		}

	}

	public void throwAxeFerro(Mapa map, Jogador jogador, String NomeTroll) {
			jogador.setBagAxeFerro(jogador.getBagAxeFerro() - 1);
			jogador.setBagAxe(jogador.getBagAxe() - 1);
			System.out.println("Matou um troll: " + NomeTroll);
	}

	public void throwAxeBronze(Mapa map, Jogador jogador, String NomeTroll) {
		jogador.setBagAxeBronze(jogador.getBagAxeBronze() - 1);
		jogador.setBagAxe(jogador.getBagAxe() - 1);
		System.out.println("Matou um troll: " + NomeTroll);
	}

	public void throwAxeOuro(Mapa map, Jogador jogador, String NomeTroll) {
		jogador.setBagAxeOuro(jogador.getBagAxeOuro() - 1);
		jogador.setBagAxe(jogador.getBagAxe() - 1);
		System.out.println("Matou um troll: " + NomeTroll);
	}

	public void moveTroll(Mapa map, ArrayList<Trolls> trolls, Jogador jogador) {
		int quantAxeFerro;
		int quantAxeBronze;
		int quantAxeOuro;
		for (int i = 0; i < trolls.size(); i++){
			quantAxeFerro = 0;
			quantAxeBronze = 0;
			quantAxeOuro = 0;
			
			for (int j = 0; j < ((Salas) trolls.get(i).getComodoAtual()).getPisos().size(); j++) {
				for (Itens item : ((Salas) trolls.get(i).getComodoAtual()).getPisos().get(j).getItens()) {
					quantAxeFerro += item.getMachadoFerro();
					quantAxeBronze += item.getMachadoBronze();
					quantAxeOuro += item.getMachadoOuro();
				}
			}
			// Machado Ferro
			if (quantAxeFerro > 0 && trolls.get(i).getComodoAtual() == jogador.getComodoAtual()) {
				for (int j = 0; j < ((Salas) jogador.getComodoAtual()).getPisos().size(); j++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(j).getItens()) {
						item.setMachadoFerro(0);
					}
				}	
				if (jogador.getBagPot() == 0) {
					jogador.setOuro(0);
					jogador.setDiamante(0);
					System.out.println("Voce nao tinha pocao, perdeu ouro e diamante");
				} else {
					jogador.setBagPot(jogador.getBagPot() - 1);
					System.out.println("Voce tinha pocao, perdeu 1 pocao");
				}
			}
			// Machado Bronze
			if (quantAxeBronze > 0 && trolls.get(i).getComodoAtual() == jogador.getComodoAtual()) {
				for (int j = 0; j < ((Salas) jogador.getComodoAtual()).getPisos().size(); j++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(j).getItens()) {
						item.setMachadoBronze(0);
					}
				}
				if (jogador.getBagPot() == 0) {
					jogador.setOuro(0);
					jogador.setDiamante(0);
					System.out.println("Voce nao tinha pocoes suficientes, perdeu ouro e diamante");
				} else {
					jogador.setBagPot(jogador.getBagPot() - 1);
					System.out.println("Voce tinha pocao, perdeu 1 pocao");
				}
			}
			// Machado Ouro
			if (quantAxeOuro > 0 && trolls.get(i).getComodoAtual() == jogador.getComodoAtual()) {
				for (int j = 0; j < ((Salas) jogador.getComodoAtual()).getPisos().size(); j++) {
					for (Itens item : ((Salas) jogador.getComodoAtual()).getPisos().get(j).getItens()) {
						item.setMachadoOuro(0);
					}
				}				
				System.out.println("Troll lancou machado de ouro! \nNao tem como se defender!");
				jogador.setOuro(0);
				jogador.setDiamante(0);
			}
		}
	}

	public void unlock(Mapa map, Jogador jogador, String door) {
		if (jogador.getBagKey() == 0) {
			System.out.println("Nao tem chave");
		} else {
			if (door.equals("A")) {
				((Salas) jogador.getComodoAtual()).getPortas().get(0).setSalaTrancada(false);
				jogador.setBagKey(jogador.getBagKey() - 1);
			} else if (door.equals("B")) {
				((Salas) jogador.getComodoAtual()).getPortas().get(1).setSalaTrancada(false);
				jogador.setBagKey(jogador.getBagKey() - 1);
			}
		}
	}
}