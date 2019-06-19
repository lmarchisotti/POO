package InterfaceGrafica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JLabel labelBag = new JLabel("Mochila");
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
	JLabel labelMachadoJogador = new JLabel(imgMachado);
	
	// ==============================================================================
	// Atributos para construcao da janela da mochila.
	ImageIcon frame2 = new ImageIcon(getClass().getResource("quadro_jogador.png"));
	JLabel labelFrame2 = new JLabel(frame2);
	
	JLabel labelMacFerroJogador = new JLabel(imgMachado);
	JLabel labelTextoMacFerro = new JLabel("===>  Possui 6.");
	
	JLabel labelPotionJogador = new JLabel(imgPocao);
	JLabel labelTextoPotion = new JLabel("===>  Possui 5.");
	
	JLabel labelKeyJogador = new JLabel(imgKey);
	JLabel labelTextoKey = new JLabel("===>  Possui 1.");
	
	JLabel labelGoldJogador = new JLabel(imgGold);
	JLabel labelTextoGold = new JLabel("===>  Possui 2.");
	
	JLabel labelDiamondJogador = new JLabel(imgDiamond);
	JLabel labelTextoDiamond = new JLabel("===>  Possui 3.");
	
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
		janela.labelMachadoJogador.setVisible(val);
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
		janela.labelPotionJogador.setVisible(val);
		janela.labelTextoPotion.setVisible(val);
		janela.labelTextoPotion.setText("==> Possui " + quant + ".");
	}
	
	public void setLabelKeyJogador(Janela janela, boolean val, int quant){
		janela.labelKeyJogador.setVisible(val);
		janela.labelTextoKey.setVisible(val);
		janela.labelTextoKey.setText("==> Possui " + quant + ".");
	}
		
	public void setLabelMacFerroJogador(Janela janela, boolean val, int quant){
		janela.labelMacFerroJogador.setVisible(val);
		janela.labelTextoMacFerro.setVisible(val);
		janela.labelTextoMacFerro.setText("==> Possui " + quant + ".");
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
		setSize(900, 700);
		setVisible(true);
		setTitle("TP2 - POO");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// Titulos
		add(labelBag);
		add(labelSala);
		labelBag.setBounds(113, -70, 250, 250);
		labelSala.setBounds(585, -70, 250, 250);
		
		// Pocao 
		add(labelPotion);
		labelPotion.setBounds(830, 83, 70, 70);	
		
		// Chave 
		add(labelKey);
		labelKey.setBounds(308, 590, 70, 70);	
		
		// Ouro
		add(labelGold);
		add(contGold);
		labelGold.setBounds(820, 595, 70, 70);
		contGold.setBounds(842, 530, 120, 120);
		
		// Diamante
		add(labelDiamond);
		add(contDiamond);
		labelDiamond.setBounds(760, 595, 70, 70);
		contDiamond.setBounds(781, 530, 120, 120);
		
		// Troll
		add(labelTroll);
		labelTroll.setBounds(535, 335, 140, 120);
				
		// Machado
		add(labelMachadoJogador);
		labelMachadoJogador.setBounds(308, 83, 70, 70);		
		
		// Quadro sala 
		add(labelFrame1);
		labelFrame1.setBounds(298, 72, 600, 600);
		
		// Machados do jogador
		add(labelMacFerroJogador);
		labelMachadoJogador.setBounds(15, 215, 70, 70);
		add(labelTextoMacFerro);
		labelMachadoJogador.setBounds(100, 202, 240, 100);
		
		// Pocoes do jogador
		add(labelPotionJogador);
		labelPotionJogador.setBounds(10, 405, 70, 70);
		add(labelTextoPotion);
		labelTextoPotion.setBounds(100, 392, 240, 100);
		
		// Chaves do jogador
		add(labelKeyJogador);
		labelKeyJogador.setBounds(15, 472, 70, 70);
		add(labelTextoKey);
		labelTextoKey.setBounds(100, 455, 240, 100);
		
		// Ouro do jogador
		add(labelGoldJogador);
		labelGoldJogador.setBounds(15, 530, 70, 70);
		add(labelTextoGold);
		labelTextoGold.setBounds(100, 515, 240, 100);
		
		// Diamante do jogador
		add(labelDiamondJogador);
		labelDiamondJogador.setBounds(15, 592, 70, 70);
		add(labelTextoDiamond);
		labelTextoDiamond.setBounds(100, 575, 240, 100);
				
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