/*inicio 1/10 Inicio
 *		13:50	-	16:00	-	organizando UI cadastro do funcionario
 *		16:00	-	17:00	-	Salario, vale alimentacao, refeicao e transporte
 *		17:00	-	17:40	-	Filhos e data nascimento filho
 *		2/10
 *		13:20	-	15:40	-	Alteracao no UI da data para poder implementar ela depois para a data de nascimento dos filhos
 *		15:40 	-	17:40	-	Implemetando botao de adcionar filho e data nascimento filho
 *		3/10
 *		13:30	-	17:30	-	implementando novo aviso de dados invalidos ou incorretos 
 *		4/10
 *		16:00	-	17:00	-	ajustes finais e teste
 *		17:30	-	18:00	-	relatorio
 *		Fim
 *		
 */
package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.activation.DataHandler;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControladorAluno;
import controller.ControladorFuncionario;
import formatacao.ConferirCpf;
import formatacao.ConferirData;
import formatacao.JtextFieldSomenteNumeros;
import model.Funcionario;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Button;

public class CadastroFuncionario {

	
	private JFrame frame;
	private Funcionario funcionario;
	
	
	private MaskFormatter data = null;
	private	MaskFormatter telefone = null;
	
	

	
	private JLabel lblName;
	private JTextField txtName;
	
	private JLabel lblCodigo;
	private JTextField txtCodigo;

	private JLabel lblBirth;
	private JFormattedTextField txtData;

	
	private JLabel lblTelefone;
	private JFormattedTextField  txtTelefone;
	
	private JLabel lblCpf;
	private JTextField  txtCpf;
	
	private JLabel lblEMail;
	private JTextField txtEmail;
	
	private JLabel lblAddress;
	private JTextField txtAdress;
	
	private ButtonGroup sex ;
	private JRadioButton	sexInvisible;
	private JLabel lblSex;
	private JRadioButton radioButtonMale;
	private JRadioButton radioButtonFemale;
	
	
	private JTextField txtSalario;
	private JLabel lblSalario;
	
	
	private JLabel lblValeAlimentacao;
	private JTextField txtValorValeAlimentacao;
	private ButtonGroup valeAlimentacao;
	private JRadioButton alimentacaoInvisible;
	private JRadioButton alimentacaoSim;
	private JRadioButton alimentacaoNao;


	
	private JLabel lblValeRefeicao ;
	private JTextField txtValorValeRefeicao;
	private ButtonGroup valeRefeicao;
	private JRadioButton refeicaoSim;
	private JRadioButton refeicaoNao;
	private JRadioButton refeicaoInvisible;

	private JLabel lblValeTransporte;
	private JTextField txtValorValeTransporte;
	private	ButtonGroup valeTransporte;
	private JRadioButton transporteInvisible;
	private JRadioButton transporteSim;
	private JRadioButton transporteNao;
	
	private JLabel lblCargo;
	private JComboBox<String> boxCargo;
	
	private JLabel lblDisciplina;
	private JComboBox<String> boxDisciplina;
	
	private JLabel lblFilhoa;
	private JRadioButton filhoSim;
	private JRadioButton filhoNao;
	private	ButtonGroup filhos;
	private JRadioButton filhoInvisible;
	
	private Panel panelFilhos;
	private Button adicionarFilhoButton;
	private ArrayList<JTextField> filhoJTextField;
	private JTextField nomeFilho;
	private JTextField birthFilho;
	private JLabel lblNomeFilho;
	private JLabel lblDataDeNascimentoFilho;
	private int limitadorFilho;
	
	
	private JButton btnClear;
	private JButton btnSubmit;


	
	/**
	 * Launch the application.
	 */  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario window = new CadastroFuncionario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroFuncionario() {
		initialize();
	}

	
		
	
	public void adicionarInputNovoFilho() {
			limitadorFilho = filhoJTextField.size();
        
         
         
         	if (limitadorFilho%2 == 0 && limitadorFilho <= 24 ) {
        	nomeFilho = new JTextField();
        	nomeFilho.setBounds(30, limitadorFilho * 15 + 60, 250, 20);
        	nomeFilho.setColumns(10);
        	panelFilhos.add(nomeFilho);
        	filhoJTextField.add(nomeFilho);
        	
        	birthFilho = new JFormattedTextField(data);
        	birthFilho.setHorizontalAlignment(txtSalario.RIGHT);
        	birthFilho.setBounds(300, limitadorFilho * 15 + 60, 80, 20);
        	birthFilho.setColumns(10);
        	panelFilhos.add(birthFilho);
        	filhoJTextField.add(birthFilho);
        	
        	panelFilhos.setBounds(545, 20, 430, limitadorFilho * 13 + 150);
        	
        	System.out.println(limitadorFilho);

        	
        }	else if ( limitadorFilho > 24) {
        	JOptionPane.showMessageDialog(null, "Ta na hora de parar de ter filho");
        	
        }
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Acionador se possui vale alimentacao ou nao
		ActionListener switchAlimentacao = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				if(abstractButton == alimentacaoSim) {
					if(abstractButton.isSelected()) {
						txtValorValeAlimentacao.setVisible(true);
					}
				}else {
					txtValorValeAlimentacao.setVisible(false);
					txtValorValeAlimentacao.setText(null);
				}
		
					
			}
		};
		
		ActionListener switchRefeicao = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
			
				if(abstractButton == refeicaoSim) {
					if(abstractButton.isSelected()) {
						txtValorValeRefeicao.setVisible(true);
					}
				} else {
					txtValorValeRefeicao.setVisible(false);
					txtValorValeRefeicao.setText(null);
				}
			
					
			}
		};
		ActionListener switchTransporte = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
		
				if(abstractButton == transporteSim) {
					if(abstractButton.isSelected()) {
						txtValorValeTransporte.setVisible(true);
					}
				} else {
					txtValorValeTransporte.setVisible(false);
					txtValorValeTransporte.setText(null);
				}
					
			}
		};
		ActionListener switchProfessor = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(boxCargo.getSelectedItem().equals("Professor")) {
					lblDisciplina.setVisible(true);
					boxDisciplina.setVisible(true);
					lblFilhoa.setBounds(65, 380, 70, 14);
					
					filhoSim.setBounds(210, 380, 52, 23);
					
					filhoNao.setBounds(285, 380, 60, 23);
				}	else {
					lblDisciplina.setVisible(false);
					boxDisciplina.setVisible(false);
					boxDisciplina.setSelectedItem("Cursos disponíveis:");
					lblFilhoa.setBounds(65, 350, 70, 14);
					
					filhoSim.setBounds(210, 350, 52, 23);
					
					filhoNao.setBounds(285, 350, 60, 23);
				}
			}
		};
		
		ActionListener switchFilho = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();

				if(abstractButton == filhoSim) {
					if(abstractButton.isSelected()) {
						frame.setBounds(100, 100, 1000, 520);
						panelFilhos.setVisible(true);
						
						
					}
				} else {
					frame.setBounds(100, 100, 540, 520);
					panelFilhos.setVisible(false);
				}
				
			}
		};
		


		
	
		
		
		 try{
             data = new MaskFormatter("##/##/####");
             telefone = new MaskFormatter("(##)#########");
             data.setPlaceholderCharacter('_');
             data.install(txtData);
             telefone.install(txtTelefone);
            
      }
      catch(ParseException excp) {
             System.err.println("Erro na formatação: " + excp.getMessage());
             System.exit(-1);
      }
		
		
		// Frame do UI
		frame = new JFrame();
		frame.setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 540, 520);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		// Campo texto Nome
		lblName = new JLabel("Nome: ");
		lblName.setBounds(65, 20, 46, 20);
		frame.getContentPane().add(lblName);
		
		txtName  = new JTextField();
		txtName.setBounds(210, 20, 250, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		

		
		
		


		
		// Data de Nascimento
		
		
		lblBirth = new JLabel("Data de Nascimento: ");
		lblBirth.setBounds(65, 80, 140, 20);
		frame.getContentPane().add(lblBirth);
		
		txtData = new JFormattedTextField(data);
		txtData.setHorizontalAlignment(txtData.RIGHT);
		txtData.setBounds(210, 81, 80, 20);
		frame.getContentPane().add(txtData);
		
		
		
		
		// Campo texto Data de Telefone:
		lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds( 65, 50, 76, 20);
		frame.getContentPane().add(lblTelefone);

		txtTelefone = new JFormattedTextField(telefone);
		txtTelefone.setBounds(210, 50, 115, 20);
		frame.getContentPane().add(txtTelefone);
		

		
		
		
		// Campo texto Data de CPF:
		lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(300, 80, 60, 20);
		frame.getContentPane().add(lblCpf);

		txtCpf = new JtextFieldSomenteNumeros(11);
		txtCpf.setBounds(360, 80, 100, 20);
		frame.getContentPane().add(txtCpf);

		
		// Campo texto Data de EMail:
		lblEMail = new JLabel("Email: ");
		lblEMail.setBounds(65, 110, 100, 20);
		frame.getContentPane().add(lblEMail);

		txtEmail   = new JTextField();
		txtEmail.setBounds(210, 110, 250, 20);
		frame.getContentPane().add(txtEmail);
		
		
		

		
		
		
		
		// Text area Endereço
		lblAddress = new JLabel("Endereço: ");
		lblAddress.setBounds(65, 140 , 100, 20);
		frame.getContentPane().add(lblAddress);

		txtAdress   = new JTextField();
		txtAdress.setBounds(210, 140, 250, 20);
		frame.getContentPane().add(txtAdress);

		
		
		
		// Radio Button Sexo
		
		sex = new ButtonGroup();
		
		sexInvisible = new JRadioButton("");
		sex.add(sexInvisible);
		sexInvisible.setSelected(true);
		
		lblSex = new JLabel("Sexo: ");
		lblSex.setBounds(65, 170, 46, 14);
		frame.getContentPane().add(lblSex);
		
		radioButtonMale = new JRadioButton("Masculino");
		radioButtonMale.setBounds(210, 170, 107, 23);
		frame.getContentPane().add(radioButtonMale);
		sex.add(radioButtonMale);

		radioButtonFemale = new JRadioButton("Feminino");
		radioButtonFemale.setBounds(325, 170, 123, 23);
		frame.getContentPane().add(radioButtonFemale);
		sex.add(radioButtonFemale);

		


		//Salario
		
		lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(65, 200, 46, 14);
		frame.getContentPane().add(lblSalario);
		
		txtSalario = new JtextFieldSomenteNumeros(9);
		txtSalario.setBounds(210, 200, 100, 20);
		frame.getContentPane().add(txtSalario);
		txtSalario.setColumns(10);
		
		// Vale Alimentação
		
		lblValeAlimentacao = new JLabel("Vale Alimentacao:");
		lblValeAlimentacao.setBounds(65, 230, 123, 14);
		frame.getContentPane().add(lblValeAlimentacao);
		
		
		txtValorValeAlimentacao	= new JtextFieldSomenteNumeros(7);
		txtValorValeAlimentacao.setBounds(355, 230, 105, 20);
		frame.getContentPane().add(txtValorValeAlimentacao);
		txtValorValeAlimentacao.setColumns(10);
		txtValorValeAlimentacao.setVisible(false);
		

		 valeAlimentacao = new ButtonGroup();
	
		
		alimentacaoInvisible = new JRadioButton("");
		valeAlimentacao.add(alimentacaoInvisible);
		alimentacaoInvisible.setSelected(true);
		
		 alimentacaoSim = new JRadioButton("Sim");
		alimentacaoSim.setBounds(210, 230, 60, 23);
		frame.getContentPane().add(alimentacaoSim);
		valeAlimentacao.add(alimentacaoSim);
		alimentacaoSim.addActionListener(switchAlimentacao);
		
		 alimentacaoNao = new JRadioButton("Não");
		alimentacaoNao.setBounds(270, 230, 63, 23);
		frame.getContentPane().add(alimentacaoNao);
		valeAlimentacao.add(alimentacaoNao);
		alimentacaoNao.addActionListener(switchAlimentacao);
		
		
		
			
		
		
		
		//Vale Refeicao
		
		lblValeRefeicao = new JLabel("Vale Refeição");
		lblValeRefeicao.setBounds(65, 260, 100, 14);
		frame.getContentPane().add(lblValeRefeicao);
		
		txtValorValeRefeicao = new JtextFieldSomenteNumeros(7);
		txtValorValeRefeicao.setBounds(355, 260, 105, 20);
		frame.getContentPane().add(txtValorValeRefeicao);
		txtValorValeRefeicao.setColumns(10);
		txtValorValeRefeicao.setVisible(false);
		
		valeRefeicao = new ButtonGroup();
		
		refeicaoInvisible = new JRadioButton("");
		valeRefeicao.add(refeicaoInvisible);
		refeicaoInvisible.setSelected(true);
		
		
		refeicaoSim = new JRadioButton("Sim");
		refeicaoSim.setBounds(210, 260, 60, 23);
		frame.getContentPane().add(refeicaoSim);
		valeRefeicao.add(refeicaoSim);
		refeicaoSim.addActionListener(switchRefeicao);
		
		refeicaoNao = new JRadioButton("Não");
		refeicaoNao.setBounds(270, 260, 63, 23);
		frame.getContentPane().add(refeicaoNao);
		valeRefeicao.add(refeicaoNao);
		refeicaoNao.addActionListener(switchRefeicao);
		
		
		//Vale Transporte
		
		
		lblValeTransporte = new JLabel("Vale Transporte");
		lblValeTransporte.setBounds(65, 290, 123, 14);
		frame.getContentPane().add(lblValeTransporte);
		
		txtValorValeTransporte = new JtextFieldSomenteNumeros(7);
		txtValorValeTransporte.setBounds(355, 290, 105, 20);
		frame.getContentPane().add(txtValorValeTransporte);
		txtValorValeTransporte.setColumns(10);
		txtValorValeTransporte.setVisible(false);
		
		valeTransporte = new ButtonGroup();
		
		transporteInvisible = new JRadioButton("");
		valeTransporte.add(transporteInvisible);
		transporteInvisible.setSelected(true);
		
		transporteSim = new JRadioButton("Sim");
		transporteSim.setBounds(210, 290, 60, 23);
		frame.getContentPane().add(transporteSim);
		valeTransporte.add(transporteSim);
		transporteSim.addActionListener(switchTransporte);
		
		transporteNao = new JRadioButton("Não");
		transporteNao.setBounds(270, 290, 63, 23);
		frame.getContentPane().add(transporteNao);
		valeTransporte.add(transporteNao);
		transporteNao.addActionListener(switchTransporte);
		
		
		
		// Combobox Cargo
		lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(65, 320, 70, 14);
		frame.getContentPane().add(lblCargo);
		
		
		boxCargo = new JComboBox<String>();
		boxCargo.addItem("Selecionar...");
		boxCargo.addItem("Professor");
		boxCargo.addItem("Analista Baixa Plataforma");
		boxCargo.addItem("Analista");
		boxCargo.addItem("Mainframe");
		boxCargo.addItem("Analista Baixa Plataforma");
		boxCargo.addItem("Programador Mainframe");
		boxCargo.addItem("Programador Baixa Plataforma");
		boxCargo.addItem("Líder de Projetos");
		boxCargo.addItem("Gerente");
		boxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boxCargo.setBounds(210, 320, 250, 20);
		frame.getContentPane().add(boxCargo);

		boxCargo.addActionListener(switchProfessor);

		// Combobox Disciplina

		lblDisciplina = new JLabel("Disciplina: ");
		lblDisciplina.setBounds(65, 350, 70, 14);
		frame.getContentPane().add(lblDisciplina);
		lblDisciplina.setVisible(false);

		boxDisciplina = new JComboBox<String>();
		boxDisciplina.addItem("Cursos disponíveis:");
		boxDisciplina.addItem("Banco de Dados");
		boxDisciplina.addItem("Front-end");
		boxDisciplina.addItem("Java WEB");
		boxDisciplina.addItem("Linguagem de Programação Java");
		boxDisciplina.addItem("Outros");
		boxDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boxDisciplina.setBounds(210, 350, 250, 20);
		frame.getContentPane().add(boxDisciplina);
		boxDisciplina.setVisible(false);
		
		
		
		//Filhos
		
		filhos = new ButtonGroup();

		
		filhoInvisible = new JRadioButton("");
		filhos.add(filhoInvisible);
		filhoInvisible.setSelected(true);
		
		
		lblFilhoa = new JLabel("Filho(a)?");
		lblFilhoa.setBounds(65, 350, 70, 14);
		frame.getContentPane().add(lblFilhoa);
		
		filhoSim = new JRadioButton("Sim");
		filhoSim.setBounds(210, 350, 52, 23);
		frame.getContentPane().add(filhoSim);
		filhos.add(filhoSim);
		filhoSim.addActionListener(switchFilho);
		
		filhoNao = new JRadioButton("Não");
		filhoNao.setBounds(285, 350, 60, 23);
		frame.getContentPane().add(filhoNao);
		filhos.add(filhoNao);
		filhoNao.addActionListener(switchFilho);
		
		// Painel de cadastro dos filhos
		
		panelFilhos = new Panel();
		panelFilhos.setBackground(Color.LIGHT_GRAY);
		panelFilhos.setBounds(545, 20, 430, 150);
		frame.getContentPane().add(panelFilhos);
		panelFilhos.setLayout(null);
		panelFilhos.setVisible(false);
		
		adicionarFilhoButton = new Button("Adicionar filho(a)");
		adicionarFilhoButton.setBounds(27, 10, 125, 22);
		panelFilhos.add(adicionarFilhoButton);

		
		
		limitadorFilho = 0;
		filhoJTextField = new ArrayList<>();
		
		adicionarFilhoButton.addActionListener(e -> adicionarInputNovoFilho());
   
		nomeFilho = new JTextField();
		nomeFilho.setBounds(30, 60, 250, 20);
		panelFilhos.add(nomeFilho);
		nomeFilho.setColumns(10);
		filhoJTextField.add(nomeFilho);
		
		lblNomeFilho = new JLabel("Nome do filho(a):");
		lblNomeFilho.setBounds(30, 40, 153, 14);
		panelFilhos.add(lblNomeFilho);
		
		birthFilho = new JFormattedTextField(data);
		birthFilho.setHorizontalAlignment(txtSalario.RIGHT);
		birthFilho.setBounds(300, 60, 80, 20);
		panelFilhos.add(birthFilho);
		birthFilho.setColumns(10);
		filhoJTextField.add(birthFilho);
		
		lblDataDeNascimentoFilho = new JLabel("Data de nascimento");
		lblDataDeNascimentoFilho.setBounds(300, 40, 131, 14);
		panelFilhos.add(lblDataDeNascimentoFilho);

		
		
		

		// Botoes
		
		
		
		btnClear = new JButton("Limpar");
		
		btnClear.setBackground(Color.YELLOW);
		btnClear.setBounds(310, 410, 130, 35);
		frame.getContentPane().add(btnClear);

		btnSubmit = new JButton("Cadastrar");

		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(110, 410, 130, 35);
		frame.getContentPane().add(btnSubmit);
		

		

		
	
		
		frame.setVisible(true);


		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if (	txtName.getText().isEmpty() 
						||	txtCodigo.getText().isEmpty()
						||	ConferirData.isDate(txtData.getText()) == false 
						||  txtTelefone.getText().equals("(  )         ")
						||	txtCpf.getText().isEmpty()
						||	ConferirCpf.isCPF(txtCpf.getText()) == false
						||	txtEmail.getText().isEmpty()
						||	txtAdress.getText().isEmpty()
						||  sexInvisible.isSelected()
						||	txtSalario.getText().isEmpty()
						||	alimentacaoInvisible.isSelected()
						||  (alimentacaoSim.isSelected() && txtValorValeAlimentacao.getText().isEmpty())
						||	refeicaoInvisible.isSelected()
						||	(transporteSim.isSelected() && txtValorValeTransporte.getText().isEmpty())
						||	transporteInvisible.isSelected()
						||	(refeicaoSim.isSelected() && txtValorValeRefeicao.getText().isEmpty())
						||  boxCargo.getSelectedItem().equals("Selecionar...")
						||	(boxCargo.getSelectedItem().equals("Professor") && boxDisciplina.getSelectedItem().equals("Cursos disponíveis:"))
						||	filhoInvisible.isSelected()	)	{
					
					if(txtName.getText().isEmpty() ) {
							lblName.setForeground(Color.red);
						} else {
							lblName.setForeground(Color.black);
					}
					if(txtCodigo.getText().isEmpty() ) {
						lblCodigo.setForeground(Color.red);
						} else {
								lblCodigo.setForeground(Color.black);
						}
					
					if(	ConferirData.isDate(txtData.getText()) == false ){
							lblBirth.setForeground(Color.red);
					}	else {
					
							lblBirth.setForeground(Color.black);
					}
					
					if(txtTelefone.getText().equals("(  )         ") ) {
								lblTelefone.setForeground(Color.red);
					}	else {
							lblTelefone.setForeground(Color.black);
					}
				
					if( 	txtCpf.getText().isEmpty()
						||	ConferirCpf.isCPF(txtCpf.getText()) == false ) {					
							lblCpf.setForeground(Color.red);
					}	else {
							lblCpf.setForeground(Color.black);
					}
					if( txtEmail.getText().isEmpty() ) {
							lblEMail.setForeground(Color.red);
					}	else {
							lblEMail.setForeground(Color.black);
					}
					if( txtAdress.getText().isEmpty() ) {
							lblAddress.setForeground(Color.red);
					} else {
						lblAddress.setForeground(Color.black);
					}
					if( sexInvisible.isSelected() ) {
							lblSex.setForeground(Color.red);
					}	else {
							lblSex.setForeground(Color.black);
					}
					if( txtSalario.getText().isEmpty()) {
						lblSalario.setForeground(Color.red);
					}	else {
						lblSalario.setForeground(Color.black);
					}
					if( alimentacaoInvisible.isSelected() || (alimentacaoSim.isSelected() && txtValorValeAlimentacao.getText().isEmpty())) {
						lblValeAlimentacao.setForeground(Color.red);
					}	else {
						lblValeAlimentacao.setForeground(Color.black);
					}
					if( refeicaoInvisible.isSelected() || (refeicaoSim.isSelected() && txtValorValeRefeicao.getText().isEmpty())) {
						lblValeRefeicao.setForeground(Color.red);
					}	else {
						lblValeRefeicao.setForeground(Color.black);
					}
					if( transporteInvisible.isSelected() || (transporteSim.isSelected() && txtValorValeTransporte.getText().isEmpty())) {
						lblValeTransporte.setForeground(Color.red);
					}	else {
						lblValeTransporte.setForeground(Color.black);
					}
			
					if(  boxCargo.getSelectedItem().equals("Selecionar...") ) {
							lblCargo.setForeground(Color.red);
					}	else	{
							lblCargo.setForeground(Color.black);
					}
					
					if (boxCargo.getSelectedItem().equals("Professor") && boxDisciplina.getSelectedItem().equals("Cursos disponíveis:")){
							lblDisciplina.setForeground(Color.red);
					}	else {
							lblDisciplina.setForeground(Color.black);
					}
					if(filhoInvisible.isSelected()) {
						lblFilhoa.setForeground(Color.red);
					}	else {
						lblFilhoa.setForeground(Color.black);
					}
					
					JOptionPane.showMessageDialog(btnSubmit, "Por favor corrigir os campos em vermelho", "Dados incorretos ou não preenchidos!", 1, null);
					
				} else {
					
					lblName.setForeground(Color.black);
					lblCodigo.setForeground(Color.black);
					lblBirth.setForeground(Color.black);
					lblTelefone.setForeground(Color.black);
					lblCpf.setForeground(Color.black);
					lblEMail.setForeground(Color.black);
					lblAddress.setForeground(Color.black);
					lblSex.setForeground(Color.black);
					lblSalario.setForeground(Color.black);
					lblValeRefeicao.setForeground(Color.black);
					lblValeTransporte.setForeground(Color.black);
					lblCargo.setForeground(Color.black);
					lblDisciplina.setForeground(Color.black);
					lblFilhoa.setForeground(Color.black);
					
					funcionario = new Funcionario();
					funcionario.setNome(txtName.getText());	
					funcionario.setCpf(txtCpf.getText());
					
					String dateFormat = "dd/MM/uuuu";
			    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter
			    	   .ofPattern(dateFormat)
			    	   .withResolverStyle(ResolverStyle.STRICT);
			    	 LocalDate date = LocalDate.parse(txtData.getText(), dateTimeFormatter);
			    	 funcionario.setDataNascimento(date);
					
					funcionario.setEndereco(txtAdress.getText());
					funcionario.setTelefone(txtTelefone.getText());
					funcionario.seteMail(txtEmail.getText());
					funcionario.setSexo(radioButtonMale.isSelected() ? "M" : "F");
					funcionario.setCargo(boxCargo.getSelectedItem().toString());
					funcionario.setSalario(txtSalario.getText());
					funcionario.setValeAlimentacao(txtValorValeAlimentacao.getText());
					funcionario.setValeRefeicao(txtValorValeRefeicao.getText());
					funcionario.setValeTransporte(txtValorValeTransporte.getText());
					
					JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
					
					ControladorFuncionario controladorFuncionario= new ControladorFuncionario();
					controladorFuncionario.cadastrarFuncionario(funcionario);
				
					
					ListaFuncionario.inicializarListaFuncionario();
				}
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtCodigo.setText(null);
				txtData.setValue(null);
				txtTelefone.setValue(null);
				txtCpf.setText(null);
				txtEmail.setText(null);
				txtAdress.setText(null);
				sexInvisible.setSelected(true);
				boxCargo.setSelectedItem("Selecionar...");
				alimentacaoInvisible.setSelected(true);
				txtValorValeAlimentacao.setVisible(false);
				refeicaoInvisible.setSelected(true);
				txtValorValeRefeicao.setVisible(false);
				transporteInvisible.setSelected(true);
				txtValorValeTransporte.setVisible(false);
			}
		});
		
	}
}
