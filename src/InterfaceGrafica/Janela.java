package InterfaceGrafica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JLabel labelMochila = new JLabel("Mochila");
	JLabel labelSala = new JLabel("Sala");
	
	// ==============================================================================
	// Atributos para construcao da janela da sala
	JButton portaA = new JButton("A");
	JButton portaB = new JButton("B");
	JButton portaC = new JButton("C");
	
	// ==============================================================================
	// Icones
	ImageIcon quadro = new ImageIcon(getClass().getResource("quadro.png"));
	JLabel labelFrame1 = new JLabel(quadro);
	
	ImageIcon imgPocao = new ImageIcon(getClass().getResource("potion.png"));
	JLabel labelPotion = new JLabel(imgPocao);
	
	ImageIcon imgKey = new ImageIcon(getClass().getResource("key.png"));
	JLabel labelKey = new JLabel(imgKey);
	
	ImageIcon imgGold = new ImageIcon(getClass().getResource("ouro.png"));
	JLabel labelGold = new JLabel(imgGold);
	
	JLabel contGold = new JLabel();
	ImageIcon imgDiamond = new ImageIcon(getClass().getResource("diamond.png"));
	JLabel labelDiamond = new JLabel(imgDiamond);
	
	JLabel contDiamond = new JLabel();
	ImageIcon imgTroll = new ImageIcon(getClass().getResource("troll_cac.png"));
	JLabel labelTroll = new JLabel(imgTroll);
	
	ImageIcon imgMachado = new ImageIcon(getClass().getResource("axe.png"));
	JLabel labelMachado = new JLabel(imgMachado);
	
	// ==============================================================================
	// Atributos para construcao da janela da mochila.
	ImageIcon quadro2 = new ImageIcon(getClass().getResource("quadro_jogador.png"));
	JLabel labelFrame2 = new JLabel(quadro2);
	
	JLabel labelMachadoJogador = new JLabel(imgMachado);
	JLabel labelTextoMachado= new JLabel("===>  Possui 0.");
	
	JLabel labelPocaoJogador = new JLabel(imgPocao);
	JLabel labelTextoPotion = new JLabel("===>  Possui 0.");
	
	JLabel labelKeyJogador = new JLabel(imgKey);
	JLabel labelTextoKey = new JLabel("===>  Possui 0.");
	
	JLabel labelGoldJogador = new JLabel(imgGold);
	JLabel labelTextoGold = new JLabel("===>  Possui 0.");
	
	JLabel labelDiamondJogador = new JLabel(imgDiamond);
	JLabel labelTextoDiamond = new JLabel("===>  Possui 0.");
	
	// ==============================================================================
	// Metodos para visualizacao dos itens da sala
	public void setPortaA(Janela janela, boolean val){
		janela.portaA.setVisible(val);
	}
	
	public void setPortaB(Janela janela, boolean val){
		janela.portaB.setVisible(val);
	}
	
	public void setPortaC(Janela janela, boolean val){
		janela.portaC.setVisible(val);
	}
	
	public void setLabelPotion(Janela janela, boolean val){
		janela.labelPotion.setVisible(val);
	}
	
	public void setLabelKey(Janela janela, boolean val){
		janela.labelKey.setVisible(val);
	}
	
	public void setLabelMacFerro(Janela janela, boolean val){
		janela.labelMachado.setVisible(val);
	}
	
	public void setLabelTroll(Janela janela, boolean val){
		janela.labelTroll.setVisible(val);
	}
	
	public void setLabelGold(Janela janela, boolean val, int quant){
		janela.labelGold.setVisible(val);
		janela.contGold.setVisible(val);
		if(quant > 0){
			janela.contGold.setText(Integer.toString(quant));
		}
	}
	
	public void setLabelDiamond(Janela janela, boolean val, int quant){
		janela.labelDiamond.setVisible(val);
		janela.contDiamond.setVisible(val);
		if(quant > 0){
			janela.contDiamond.setText(Integer.toString(quant));			
		}
	}
	
	// ==============================================================================
	// Metodos para visualizacao dos itens da mochila
	public void setLabelPotionJogador(Janela janela, boolean val, int quant){
		janela.labelPocaoJogador.setVisible(val);
		janela.labelTextoPotion.setVisible(val);
		janela.labelTextoPotion.setText("==> Possui " + quant + ".");
	}
	
	public void setLabelKeyJogador(Janela janela, boolean val, int quant){
		janela.labelKeyJogador.setVisible(val);
		janela.labelTextoKey.setVisible(val);
		janela.labelTextoKey.setText("==> Possui " + quant + ".");
	}
		
	public void setLabelMachadoJogador(Janela janela, boolean val, int quant){
		janela.labelMachadoJogador.setVisible(val);
		janela.labelTextoMachado.setVisible(val);
		janela.labelTextoMachado.setText("==> Possui " + quant + ".");
	}
	
	public void setLabelGoldJogador(Janela janela, boolean val, int quant){
		janela.labelGoldJogador.setVisible(val);
		janela.labelTextoGold.setVisible(val);
		if(quant > 0){
			janela.labelTextoGold.setText("==> Possui " + quant + ".");
		}else{
			janela.labelTextoGold.setVisible(val);
		}
	}
		
	public void setLabelDiamondJogador(Janela janela, boolean val, int quant){
		janela.labelDiamondJogador.setVisible(val);
		if(quant > 0){
			janela.labelTextoDiamond.setVisible(val);
			janela.labelTextoDiamond.setText("==> Possui " + quant + ".");
		}else{
			janela.labelTextoDiamond.setVisible(val);
		}
	}
	
	// ==============================================================================
	// Construtor da janela base
	public Janela(){
		setSize(905, 705);
		setVisible(true);
		setTitle("TP2 - POO");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// Titulos
		add(labelMochila);
		add(labelSala);
		labelMochila.setBounds(113, -70, 250, 250);
		labelSala.setBounds(585, -70, 250, 250);
		
		// Pocao 
		add(labelPotion);
		labelPotion.setBounds(830, 83, 50, 70);	
		
		// Chave 
		add(labelKey);
		labelKey.setBounds(308, 590, 70, 70);	
		
		// Ouro
		add(labelGold);
		add(contGold);
		labelGold.setBounds(820, 595, 70, 60);
		contGold.setBounds(842, 530, 120, 120);
		
		// Diamante
		add(labelDiamond);
		add(contDiamond);
		labelDiamond.setBounds(760, 595, 70, 60);
		contDiamond.setBounds(781, 530, 120, 120);
		
		// Troll
		add(labelTroll);
		labelTroll.setBounds(535, 335, 140, 120);
				
		// Machado
		add(labelMachado);
		labelMachado.setBounds(308, 83, 70, 70);		
		
		// Quadro sala 
		add(labelFrame1);
		labelFrame1.setBounds(298, 72, 600, 600);
		
		// Machados do jogador
		add(labelMachadoJogador);
		labelMachado.setBounds(15, 215, 70, 70);
		add(labelTextoMachado);
		labelTextoMachado.setBounds(100, 215, 240, 100);
		
		// Pocoes do jogador
		add(labelPocaoJogador);
		labelPocaoJogador.setBounds(10, 275, 70, 70);
		add(labelTextoPotion);
		labelTextoPotion.setBounds(100, 275, 240, 100);
		
		// Chaves do jogador
		add(labelKeyJogador);
		labelKeyJogador.setBounds(15, 345, 70, 70);
		add(labelTextoKey);
		labelTextoKey.setBounds(100, 345, 240, 100);
		
		// Ouro do jogador
		add(labelGoldJogador);
		labelGoldJogador.setBounds(15, 415, 70, 70);
		add(labelTextoGold);
		labelTextoGold.setBounds(100, 415, 240, 100);
		
		// Diamante do jogador
		add(labelDiamondJogador);
		labelDiamondJogador.setBounds(15, 485, 70, 70);
		add(labelTextoDiamond);
		labelTextoDiamond.setBounds(100, 485, 240, 100);
				
		// Quadro jogador
		add(labelFrame2);
		labelFrame2.setBounds(0, 72, 300, 600);
		
		// Portas	
		add(portaA);
		add(portaB);
		add(portaC);
		portaA.setBounds(580, 87, 55, 30);
		portaB.setBounds(833, 370, 55, 30);
		portaC.setBounds(580, 627, 55, 30);		
	}
}