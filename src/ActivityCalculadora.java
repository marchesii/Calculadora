import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ActivityCalculadora extends JFrame implements ActionListener {

	private JPanel painel;
	private JTextArea textview_output;
	private JButton button_zerar;
	private JButton button_multiplicar;
	private JButton button_dividir;
	private JButton button_somar;
	private JButton button_subtrair;
	private JButton button_calcular;
	private JButton button_ponto;
	private JButton button_limpar;
	private JButton button_potencia;
	private JButton _0;
	private JButton _1;
	private JButton _2;
	private JButton _3;
	private JButton _4;
	private JButton _5;
	private JButton _6;
	private JButton _7;
	private JButton _8;
	private JButton _9;
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private String tela;
	private int operacao;
	private Calculadora calculadora;

	public ActivityCalculadora() {
		super("Calculadora DSI");
		iniciaComponentes();
		inserirComponentes();
		configuraTela();
	}

	
	private void iniciaComponentes() {
		calculadora = Calculadora.getInstance();
		painel = new JPanel();
		textview_output = new JTextArea();
		button_zerar = new JButton("C");
		button_multiplicar = new JButton("*");
		button_dividir = new JButton("/");
		button_somar = new JButton("+");
		button_subtrair = new JButton("-");
		button_calcular = new JButton("=");
		button_ponto = new JButton(".");
		button_limpar = new JButton("CE");
		button_potencia = new JButton("^");
		_0 = new JButton("0");
		_1 = new JButton("1");
		_2 = new JButton("2");
		_3 = new JButton("3");
		_4 = new JButton("4");
		_5 = new JButton("5");
		_6 = new JButton("6");
		_7 = new JButton("7");
		_8 = new JButton("8");
		_9 = new JButton("9");
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		button_zerar.addActionListener(this);
		button_multiplicar.addActionListener(this);
		button_dividir.addActionListener(this);
		button_somar.addActionListener(this);
		button_subtrair.addActionListener(this);
		button_calcular.addActionListener(this);
		button_ponto.addActionListener(this);
		button_limpar.addActionListener(this);
		button_potencia.addActionListener(this);
		_0.addActionListener(this);
		_1.addActionListener(this);
		_2.addActionListener(this);
		_3.addActionListener(this);
		_4.addActionListener(this);
		_5.addActionListener(this);
		_6.addActionListener(this);
		_7.addActionListener(this);
		_8.addActionListener(this);
		_9.addActionListener(this);

		
		
	}
	private void configuraTela() {
		setResizable(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}


	private void inserirComponentes() {
		painel.setLayout(layout);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		textview_output.setLineWrap(true);
		textview_output.setEditable(false);
		textview_output.setFont(new Font("Arial Black", Font.PLAIN, 24));
		painel.add(textview_output, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		painel.add(button_potencia, constraints);
		constraints.gridx = 2;
		painel.add(button_dividir, constraints);
		constraints.gridx = 3;
		painel.add(button_limpar, constraints);
		constraints.gridx = 4;		
		painel.add(button_zerar, constraints);		
		constraints.gridx = 1;
		constraints.gridy = 2;
		painel.add(_7, constraints);
		constraints.gridx = 2;
		painel.add(_8, constraints);
		constraints.gridx = 3;
		painel.add(_9, constraints);
		constraints.gridx = 4;
		painel.add(button_multiplicar, constraints);
		constraints.gridx = 1;
		constraints.gridy = 3;
		painel.add(_4, constraints);
		constraints.gridx = 2;
		painel.add(_5, constraints);
		constraints.gridx = 3;
		painel.add(_6, constraints);
		constraints.gridx = 4;
		painel.add(button_subtrair, constraints);
		constraints.gridx = 1;
		constraints.gridy = 4;
		painel.add(_1, constraints);
		constraints.gridx = 2;
		painel.add(_2, constraints);
		constraints.gridx = 3;
		painel.add(_3, constraints);
		constraints.gridx = 4;
		painel.add(button_somar, constraints);
		constraints.gridx = 1;
		constraints.gridy = 5;
		painel.add(_0, constraints);
		constraints.gridx = 2;
		painel.add(button_ponto, constraints);
		constraints.gridx = 3;
		constraints.gridwidth = 2;
		painel.add(button_calcular, constraints);
		add(painel);
		
	}

	protected void atualizar(String numero) {
		 if(tela == null || tela.equals("0")){
	            tela = (numero);
	        } else {
	            tela = tela+numero;
	        }
	        textview_output.setText(tela);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source == button_zerar) {
			zerar();
		} else {
			if (source == button_multiplicar) {
				contar(Constantes.MULTIPLICACAO);
			} else {
				if (source == button_dividir) {
					contar(Constantes.DIVISAO);
				} else {
					if (source == button_somar) {
						contar(Constantes.ADICAO);
					} else {
						if (source == button_subtrair) {
							contar(Constantes.SUBTRACAO);
						} else {
							if (source == button_calcular) {
								contar(Constantes.RESULTADO);
							} else {
								if (source == button_ponto) {
									atualizar(".");
								} else {
									if (source == button_limpar) {
										limpar();
										textview_output.setText(String.format("%.2f", Float.parseFloat(tela)));
									} else {
										if (source == button_potencia) {
											contar(Constantes.POTENCIA);
										} else {
											if (source == _0) {
												atualizar("0");
											} else {
												if (source == _1) {
													atualizar("1");
												} else {
													if (source == _2) {
														atualizar("2");
													} else {
														if (source == _3) {
															atualizar("3");
														} else {
															if (source == _4) {
																atualizar("4");
															} else {
																if (source == _5) {
																	atualizar("5");
																} else {
																	if (source == _6) {
																		atualizar("6");
																	} else {
																		if (source == _7) {
																			atualizar("7");
																		} else {
																			if (source == _8) {
																				atualizar("8");
																			} else {
																				if (source == _9) {
																					atualizar("9");
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	private void limpar() {
		tela = "0";
	}

	private void contar(int constante) {
		 try{
	            if(tela == null || tela.equals(".")){
	                atualizar("0");
	            }
	            if(operacao != Constantes.NULO){
	                tela = String.valueOf(Calculadora.getInstance().calcular(operacao, Float.parseFloat(tela)));
	            } else {
	                tela = String.valueOf(Calculadora.getInstance().calcular(constante, Float.parseFloat(tela)));
	            }
	        } catch (NumberFormatException ex){
	            zerar();
	            JOptionPane.showMessageDialog(null, "Apenas um ponto por conta");
	        }

	        operacao = constante;
	        textview_output.setText(tela);
	        tela = "0";
	    }

	private void zerar() {
		Calculadora.getInstance().c();
        operacao = 0;
        limpar();
        textview_output.setText(String.format("%.2f", Calculadora.getInstance().calcular(Constantes.NULO, (Float.parseFloat(tela)))));
	}

}
