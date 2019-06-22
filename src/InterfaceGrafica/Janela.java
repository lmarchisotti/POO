package InterfaceGrafica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JLabel labelMochila = new JLabel("Mochila");
	JLabel labelSala = new JLabel("Sala");
	JLabel labelIdSala = new JLabel();
	
	// ==============================================================================
	// Atributos para construcao da janela.
	// ==============================================================================
	
	// ==============================================================================
	// Botoes
	JButton portaA = new JButton("A");
	JButton portaB = new JButton("B");
	JButton portaC = new JButton("C");
	
	// ==============================================================================
	// Icones
	ImageIcon quadro = new ImageIcon(getClass().getResource("moldura_jogo.png"));
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
	ImageIcon imgTroll = new ImageIcon(getClass().getResource("troll.png"));
	JLabel labelTroll = new JLabel(imgTroll);
	
	ImageIcon imgMachado = new ImageIcon(getClass().getResource("axe.png"));
	JLabel labelMachado = new JLabel(imgMachado);
	
	// ==============================================================================
	// Atributos para construcao da mochila.
	ImageIcon quadro2 = new ImageIcon(getClass().getResource("moldura_mochila.png"));
	JLabel labelFrame2 = new JLabel(quadro2);
	
	JLabel labelMachadoJogador = new JLabel(imgMachado);
	JLabel labelTextoMachado= new JLabel("Possui 0.");
	
	JLabel labelPocaoJogador = new JLabel(imgPocao);
	JLabel labelTextoPotion = new JLabel("Possui 0.");
	
	JLabel labelKeyJogador = new JLabel(imgKey);
	JLabel labelTextoKey = new JLabel("Possui 0.");
	
	JLabel labelGoldJogador = new JLabel(imgGold);
	JLabel labelTextoGold = new JLabel("Possui 0.");
	
	JLabel labelDiamondJogador = new JLabel(imgDiamond);
	JLabel labelTextoDiamond = new JLabel("Possui 0.");
	
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
	
	public void setLabelMac(Janela janela, boolean val){
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
	
	public void setIdSala(Janela janela, Integer idSala) {
		janela.labelIdSala.setVisible(true);
		janela.labelIdSala.setText(idSala.toString());
	}
	
	// ==============================================================================
	// Metodos para visualizacao dos itens da mochila
	public void setLabelPotionJogador(Janela janela, boolean val, int quant){
		janela.labelPocaoJogador.setVisible(val);
		janela.labelTextoPotion.setVisible(val);
		janela.labelTextoPotion.setText("Possui " + quant + ".");
	}
	
	public void setLabelKeyJogador(Janela janela, boolean val, int quant){
		janela.labelKeyJogador.setVisible(val);
		janela.labelTextoKey.setVisible(val);
		janela.labelTextoKey.setText("Possui " + quant + ".");
	}
		
	public void setLabelMachadoJogador(Janela janela, boolean val, int quant){
		janela.labelMachadoJogador.setVisible(val);
		janela.labelTextoMachado.setVisible(val);
		janela.labelTextoMachado.setText("Possui " + quant + ".");
	}
	
	public void setLabelGoldJogador(Janela janela, boolean val, int quant){
		janela.labelGoldJogador.setVisible(val);
		janela.labelTextoGold.setVisible(val);
		if(quant > 0){
			janela.labelTextoGold.setText("Possui " + quant + ".");
		}else{
			janela.labelTextoGold.setVisible(val);
		}
	}
		
	public void setLabelDiamondJogador(Janela janela, boolean val, int quant){
		janela.labelDiamondJogador.setVisible(val);
		if(quant > 0){
			janela.labelTextoDiamond.setVisible(val);
			janela.labelTextoDiamond.setText("Possui " + quant + ".");
		}else{
			janela.labelTextoDiamond.setVisible(val);
		}
	}
	
	// ==============================================================================
	// Construtor da janela base
	public Janela(){
		setSize(815, 575);
		setVisible(true);
		setTitle("TP2 - POO");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// Portas	
		add(portaA);
		add(portaB);
		add(portaC);
		portaA.setBounds(355, 50, 55, 30);
		portaB.setBounds(705, 190, 55, 30);
		portaC.setBounds(355, 340, 55, 30);	

		// Titulos
		add(labelSala);
		add(labelMochila);
		add(labelIdSala);
		labelSala.setBounds(370, -105, 250, 250);
		labelMochila.setBounds(360, 300, 250, 250);
		labelIdSala.setBounds(380, -94, 250, 250);
		
		// ----------------------------------------------------
		// Mochila
				
		// Machados
		add(labelMachadoJogador);
		add(labelTextoMachado);
		labelMachadoJogador.setBounds(150, 435, 70, 70);
		labelTextoMachado.setBounds(160, 455, 240, 100);

		// Pocoes
		add(labelPocaoJogador);
		add(labelTextoPotion);
		labelPocaoJogador.setBounds(370, 435, 70, 70);
		labelTextoPotion.setBounds(380, 455, 240, 100);
				
		// Chaves
		add(labelKeyJogador);
		add(labelTextoKey);
		labelKeyJogador.setBounds(600, 435, 70, 70);
		labelTextoKey.setBounds(610, 455, 240, 100);
				
		// Ouro
		add(labelGoldJogador);
		add(labelTextoGold);
		labelGoldJogador.setBounds(260, 435, 70, 70);
		labelTextoGold.setBounds(270, 455, 240, 100);
				
		// Diamante
		add(labelDiamondJogador);
		add(labelTextoDiamond);
		labelDiamondJogador.setBounds(495, 435, 70, 70);
		labelTextoDiamond.setBounds(505, 455, 240, 100);

		// ----------------------------------------------------
		// Sala
		
		// Pocao
		add(labelPotion);
		labelPotion.setBounds(55, 37, 50, 70);	
		
		// Machado
		add(labelMachado);
		labelMachado.setBounds(115, 37, 70, 70);
		
		// Chave 
		add(labelKey);
		labelKey.setBounds(55, 95, 70, 70);	
		
		// Ouro
		add(labelGold);
		add(contGold);
		labelGold.setBounds(55, 280, 70, 60);
		contGold.setBounds(78, 285, 120, 120);
		
		// Diamante
		add(labelDiamond);
		add(contDiamond);
		labelDiamond.setBounds(55, 200, 70, 60);
		contDiamond.setBounds(78, 207, 120, 120);
		
		// Troll
		add(labelTroll);
		labelTroll.setBounds(320, 140, 140, 120);

		// ----------------------------------------------------
		// Molduras
		
		// Sala
		add(labelFrame1);
		labelFrame1.setBounds(5, -95, 800, 600);

		// Mochila
		add(labelFrame2);
		labelFrame2.setBounds(5, 335, 800, 280);
	}
}