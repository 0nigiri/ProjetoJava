/*	inicio	27/9 - 15:00 -	17:30 	-> 	mudanca na validação da data de nascimento
*			28/9 - 13:30 -	14:00   ->	finalizando validacao da data de nascimento  
*				   14:00 -	16:00	->	inicio  matricula, apenas aceitar numeroes e com limite de 9 digitos		
*				   16:00 -	16:10	->	atualizando CPF para apenas numeros e com limite de 11 digitos
*				   16:10 -	16:55	->	Atualizar cadastro professor com a nova validacao de data de nascimento e cpf
*	Concluido	   16:55 -	17:25	->	Teste do programa 
*/
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class CadastroAluno {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno window = new CadastroAluno();
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
	public CadastroAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Campo texto Nome
		
		JTextField txtName  = new JTextField();
		txtName.setBounds(190, 20, 350, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Nome: ");
		lblName.setBounds(60, 20, 45, 20);
		frame.getContentPane().add(lblName);
		
		
		
	//Matricula
		
		JLabel lbMatricula = new JLabel("Numero de matricula: ");
		lbMatricula.setBounds(60, 60, 131, 20);
		frame.getContentPane().add(lbMatricula);
		
		JTextField txtMatricula = new JtextFieldSomenteNumeros(9);

		txtMatricula.setBounds(190, 60, 150, 20);
		frame.getContentPane().add(txtMatricula);


	
		// Data de Nascimento
		
		
		JLabel lbBirth = new JLabel("Data de Nascimento: ");
		lbBirth.setBounds(60, 100, 108, 20);
		frame.getContentPane().add(lbBirth);
		
		


		// DIA 
		
		
		JComboBox<String> dataDia = new JComboBox<String>();
		for (Integer i = 0; i < 32; i++) {
			if (i == 0) {
				dataDia.addItem("Dia");
			} else {
				dataDia.addItem(Integer.toString(i));
			}
		}
			
		dataDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dataDia.setBounds(190, 100, 50, 20);
		frame.getContentPane().add(dataDia);
		
		//MES
;
		
		JComboBox<String> dataMes = new JComboBox<String>();
		for (Integer i = 0; i <13; i++) {
			if (i == 0) {
				dataMes.addItem("Mes");
			} else {
				dataMes.addItem(Integer.toString(i));
			}
		}
		dataMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dataMes.setBounds(260, 100, 50, 20);
		frame.getContentPane().add(dataMes);
		
		
		//ANO

		JComboBox<String> dataAno = new JComboBox<String>();
		for (Integer i = 2018; 1900 < i; i--) {
			if (i == 2018) {
				dataAno.addItem("Ano");
			} else {
				dataAno.addItem(Integer.toString(i));
			}
		}
		dataAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dataAno.setBounds(330, 100, 70, 20);
		frame.getContentPane().add(dataAno);
		
		
	
		
		
		// Campo texto Data de Telefone:
		JLabel lbTel = new JLabel("Telefone: ");
		lbTel.setBounds( 340, 140, 60, 20);
		frame.getContentPane().add(lbTel);

		JTextField txtTel = new JtextFieldSomenteNumeros(12);
		txtTel.setBounds(395, 140, 145, 20);
		frame.getContentPane().add(txtTel);
		

		
		
		
		// Campo texto Data de CPF:
		JLabel lbCpf = new JLabel("CPF: ");
		lbCpf.setBounds(60, 140, 140, 20);
		frame.getContentPane().add(lbCpf);

		JTextField txtCpf =  new JtextFieldSomenteNumeros(11);
		txtCpf.setBounds(190, 140, 140, 20);
		frame.getContentPane().add(txtCpf);

		

		
		// Campo texto Data de EMail:
		JLabel lbEMail = new JLabel("Email: ");
		lbEMail.setBounds(60, 180, 140, 20);
		frame.getContentPane().add(lbEMail);

		JTextField txtEmail   = new JTextField();
		txtEmail.setBounds(190, 180, 350, 20);
		frame.getContentPane().add(txtEmail);
		

		
		
		
		
		// Text area Endereço
		JLabel lblAddress = new JLabel("Endereço: ");
		lblAddress.setBounds(60, 220 , 100, 20);
		frame.getContentPane().add(lblAddress);

		JTextField txtAdress   = new JTextField();
		txtAdress.setBounds(190, 220, 350, 20);
		frame.getContentPane().add(txtAdress);

		
		
		
		// Radio Button Sexo
		
		ButtonGroup sex = new ButtonGroup();
		
		JRadioButton radioButtonInvisible = new JRadioButton("");
		sex.add(radioButtonInvisible);
		radioButtonInvisible.setSelected(true);
		
		JLabel lblSex = new JLabel("Sexo: ");
		lblSex.setBounds(60, 260, 46, 14);
		frame.getContentPane().add(lblSex);
		
		

		JLabel lblMale = new JLabel("Masculino");
		lblMale.setBounds(190, 260, 60, 20);
		frame.getContentPane().add(lblMale);
		
		JRadioButton radioButtonMale = new JRadioButton("");
		radioButtonMale.setBounds(250, 264, 20, 14);
		frame.getContentPane().add(radioButtonMale);
		sex.add(radioButtonMale);
		

		
		JLabel lblFemale = new JLabel("Feminino");
		lblFemale.setBounds(300, 260, 60, 20);
		frame.getContentPane().add(lblFemale);

		JRadioButton radioButtonFemale = new JRadioButton("");
		radioButtonFemale.setBounds(360, 264, 20, 14);
		frame.getContentPane().add(radioButtonFemale);
		sex.add(radioButtonFemale);

		// Combobox Disciplina
		JLabel lblOccupation = new JLabel("Curso: ");
		lblOccupation.setBounds(60, 300, 70, 14);
		frame.getContentPane().add(lblOccupation);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Cursos disponíveis:");
		comboBox.addItem("Java WEB");
		comboBox.addItem("Cobol");
		comboBox.addItem(".NET");
		comboBox.addItem("Redes");
		comboBox.addItem("Python");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(190, 300, 250, 20);
		frame.getContentPane().add(comboBox);

		// Botoes
		
		
		
		JButton btnClear = new JButton("Limpar");
		
		btnClear.setBackground(Color.YELLOW);
		btnClear.setBounds(380, 360, 89, 23);
		frame.getContentPane().add(btnClear);

		JButton btnSubmit = new JButton("Cadastrar");

		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(140, 360, 100, 23);
		frame.getContentPane().add(btnSubmit);
		

		
		
	
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dadosErros = "";
				String data = "";
				data = String.join("", dataDia.getSelectedItem() + "/" + dataMes.getSelectedItem()  + "/" + dataAno.getSelectedItem() );
				
				if (	txtName.getText().isEmpty() 
						||  dataDia.getSelectedItem().equals("Dia") 
						||  dataMes.getSelectedItem().equals("Mes") 
						||	dataAno.getSelectedItem().equals("Ano")
						||	ConferirData.isDate(data) == false 
						||  txtTel.getText().isEmpty()
						||	txtCpf.getText().isEmpty()
						||	ConferirCpf.isCPF(txtCpf.getText()) == false
						||	txtEmail.getText().isEmpty()
						||	txtAdress.getText().isEmpty()
						||  radioButtonInvisible.isSelected()
						||  comboBox.getSelectedItem().equals("Cursos disponíveis:"))	{
					
					if(txtName.getText().isEmpty() ) {
						dadosErros += String.join("", "Nome Invalido\n");
					}
					if(txtMatricula.getText().isEmpty() ) {
						dadosErros += String.join("", "Matricula invalido \n");
					}
					if(			dataDia.getSelectedItem().equals("Dia") 
							||  dataMes.getSelectedItem().equals("Mes") 
							||	dataAno.getSelectedItem().equals("Ano") 
							||	ConferirData.isDate(data) == false ){
								dadosErros += String.join("", "Data de nascimento invalido \n");
					}
				
					
					if( txtTel.getText().isEmpty() ) {
						dadosErros += String.join("", "Telefone invalido \n");
					}
					if( 	txtCpf.getText().isEmpty()
						||	ConferirCpf.isCPF(txtCpf.getText()) == false ) {					
								dadosErros += String.join("", "CPF invalido\n");
					}
					if( txtEmail.getText().isEmpty() ) {
						dadosErros += String.join("", "E-mail invalido\n");
					}
					if( txtAdress.getText().isEmpty() ) {
						dadosErros += String.join("", "Endereco invalido\n");
					}
					if( radioButtonInvisible.isSelected() ) {
						dadosErros += String.join("", "Sexo invalido \n");
					}
					if(  comboBox.getSelectedItem().equals("Cursos disponíveis:") ) {
						dadosErros += String.join("", "Disciplina invalido\n");
					}
					
					JOptionPane.showMessageDialog(btnSubmit, "Por favor tentar preencher novamente os seguintes campos novamente:\n\n" + dadosErros, "Dados incorretos ou não preenchidos!", 1, null);
					dadosErros ="";
					data = "";
					
				} else {
						JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
				}
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtMatricula.setText(null);
				txtTel.setText(null);
				txtCpf.setText(null);
				txtEmail.setText(null);
				txtAdress.setText(null);
				radioButtonInvisible.setSelected(true);
				comboBox.setSelectedItem("Cursos disponíveis:");
				dataDia.setSelectedIndex(0);
				dataMes.setSelectedIndex(0);
				dataAno.setSelectedIndex(0);
			
			}
		});
	}



}
