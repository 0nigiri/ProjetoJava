/*inicio 25/9 - 15:17
- 15:20 -> 15:40 = arrumando setters e getters do aluno e professores
- 15:40 --> 17:00 = organizando UI do cadastro

- 29/9
- 13:30 - 14:30 -> arrumando a parte se campo vazio = erro
*/

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

import formatacao.ConferirCpf;
import formatacao.ConferirData;
import formatacao.JtextFieldSomenteNumeros;

public class CadastroProfessor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProfessor window = new CadastroProfessor();
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
	public CadastroProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Campo texto Nome
		JLabel lblName = new JLabel("Nome: ");
		lblName.setBounds(65, 20, 46, 20);
		frame.getContentPane().add(lblName);
		
		JTextField txtName  = new JTextField();
		txtName.setBounds(225, 20, 350, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		
		


		
		// Data de Nascimento
		
		
		JLabel lbBirth = new JLabel("Data de Nascimento: ");
		lbBirth.setBounds(65, 60, 140, 20);
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
		dataDia.setBounds(225, 60, 50, 20);
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
		dataMes.setBounds(300, 60, 50, 20);
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
		dataAno.setBounds(375, 60, 70, 20);
		frame.getContentPane().add(dataAno);
		
		
		
		
		// Campo texto Data de Telefone:
		JLabel lbTel = new JLabel("Telefone: ");
		lbTel.setBounds( 375, 100, 140, 20);
		frame.getContentPane().add(lbTel);

		JTextField txtTel = new JtextFieldSomenteNumeros(12);
		txtTel.setBounds(435, 100, 140, 20);
		frame.getContentPane().add(txtTel);
		

		
		
		
		// Campo texto Data de CPF:
		JLabel lbCpf = new JLabel("CPF: ");
		lbCpf.setBounds(65, 100, 140, 20);
		frame.getContentPane().add(lbCpf);

		JTextField txtCpf = new JtextFieldSomenteNumeros(11);
		txtCpf.setBounds(225, 100, 140, 20);
		frame.getContentPane().add(txtCpf);

		
		// Campo texto Data de EMail:
		JLabel lbEMail = new JLabel("Email: ");
		lbEMail.setBounds(65, 140, 140, 20);
		frame.getContentPane().add(lbEMail);

		JTextField txtEmail   = new JTextField();
		txtEmail.setBounds(225, 140, 350, 20);
		frame.getContentPane().add(txtEmail);
		
		
		

		
		
		
		
		// Text area Endereço
		JLabel lblAddress = new JLabel("Endereço: ");
		lblAddress.setBounds(65, 180 , 100, 20);
		frame.getContentPane().add(lblAddress);

		JTextField txtAdress   = new JTextField();
		txtAdress.setBounds(225, 180, 350, 20);
		frame.getContentPane().add(txtAdress);

		
		
		
		// Radio Button Sexo
		
		ButtonGroup sex = new ButtonGroup();
		
		JRadioButton radioButtonInvisible = new JRadioButton("");
		sex.add(radioButtonInvisible);
		radioButtonInvisible.setSelected(true);
		
		JLabel lblSex = new JLabel("Sexo: ");
		lblSex.setBounds(65, 220, 46, 14);
		frame.getContentPane().add(lblSex);
		
		

		JLabel lblMale = new JLabel("Masculino");
		lblMale.setBounds(225, 220, 60, 14);
		frame.getContentPane().add(lblMale);
		
		JRadioButton radioButtonMale = new JRadioButton("");
		radioButtonMale.setBounds(285, 218, 20, 23);
		frame.getContentPane().add(radioButtonMale);
		sex.add(radioButtonMale);
		

		
		JLabel lblFemale = new JLabel("Feminino");
		lblFemale.setBounds(370, 220, 60, 14);
		frame.getContentPane().add(lblFemale);

		JRadioButton radioButtonFemale = new JRadioButton("");
		radioButtonFemale.setBounds(430, 218, 20, 23);
		frame.getContentPane().add(radioButtonFemale);
		sex.add(radioButtonFemale);

		// Combobox Disciplina
		JLabel lbDisciplina = new JLabel("Disciplina: ");
		lbDisciplina.setBounds(65, 260, 70, 14);
		frame.getContentPane().add(lbDisciplina);

		JComboBox<String> boxDisciplina = new JComboBox<String>();
		boxDisciplina.addItem("Selecionar...");
		boxDisciplina.addItem("Banco de Dados");
		boxDisciplina.addItem("Front-end");
		boxDisciplina.addItem("Java WEB");
		boxDisciplina.addItem("Linguagem de Programação Java");
		boxDisciplina.addItem("Outros");
		boxDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boxDisciplina.setBounds(225, 260, 250, 20);
		frame.getContentPane().add(boxDisciplina);

		// Botoes
		
		
		
		JButton btnClear = new JButton("Limpar");
		
		btnClear.setBackground(Color.YELLOW);
		btnClear.setBounds(450, 320, 89, 23);
		frame.getContentPane().add(btnClear);

		JButton btnSubmit = new JButton("Cadastrar");

		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(140, 320, 100, 23);
		frame.getContentPane().add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dadosErros = "";
				String data = "";
				data = String.join("", dataDia.getSelectedItem() + "/" + dataMes.getSelectedItem()  + "/" + dataAno.getSelectedItem() );
				
				if (		txtName.getText().isEmpty() 
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
						||  boxDisciplina.getSelectedItem().equals("Cursos disponíveis:"))	{
					
					if(txtName.getText().isEmpty() ) {
						dadosErros += String.join("", "Nome Invalido\n");
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
					if(  boxDisciplina.getSelectedItem().equals("Cursos disponíveis:") ) {
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
				dataDia.setSelectedIndex(0);
				dataMes.setSelectedIndex(0);
				dataAno.setSelectedIndex(0);
				txtTel.setText(null);
				txtCpf.setText(null);
				txtEmail.setText(null);
				txtAdress.setText(null);
				radioButtonInvisible.setSelected(true);
				boxDisciplina.setSelectedItem("Selecionar...");
			}
		});
	}
}
