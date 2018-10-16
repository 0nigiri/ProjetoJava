package view;

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;

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
import model.Aluno;

import formatacao.ConferirCpf;
import formatacao.ConferirData;
import formatacao.JtextFieldSomenteNumeros;



public class CadastroAluno {

	private JFrame frame;
	private MaskFormatter data = null;
	private	MaskFormatter telefone = null;
	
	private Aluno aluno;
	
	private JLabel lblName;
	private JTextField txtName;
	
	
	private JLabel lblBirth;
	private JFormattedTextField txtData;
	
	private JLabel lblTelefone;
	private	JFormattedTextField txtTelefone;
	
	private JLabel lblCpf;
	private JTextField txtCpf;
	
	private JLabel lblEMail;
	private JTextField txtEmail;
	
	private JLabel lblAddress;
	private JTextField txtAdress;
	
	private ButtonGroup sex;
	private JRadioButton sexInvisible;
	private JLabel lblSex;
	private JLabel lblMale;
	private JRadioButton radioButtonMale;
	private JLabel lblFemale;
	private JRadioButton radioButtonFemale;

	private JLabel lblOccupation;	
	private JComboBox<String> comboBox;

	private JButton btnClear;
	private JButton btnSubmit;
	
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
		
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 420);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Campo texto Nome
		
		txtName  = new JTextField();
		txtName.setBounds(190, 20, 350, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		lblName = new JLabel("Nome: ");
		lblName.setBounds(60, 20, 45, 20);
		frame.getContentPane().add(lblName);
		
		
	/*	
	//Matricula
		
		lblMatricula = new JLabel("Numero de matricula: ");
		lblMatricula.setBounds(60, 60, 131, 20);
		frame.getContentPane().add(lblMatricula);
		
		txtMatricula = new JtextFieldSomenteNumeros(9);

		txtMatricula.setBounds(190, 60, 150, 20);
		frame.getContentPane().add(txtMatricula);

	 */
	
		// Data de Nascimento
		
		
		lblBirth = new JLabel("Data de Nascimento: ");
		lblBirth.setBounds(60, 60, 108, 20);
		frame.getContentPane().add(lblBirth);
		
		txtData = new JFormattedTextField(data);
		txtData.setHorizontalAlignment(txtData.RIGHT);
		txtData.setBounds(190, 60, 80, 20);
		frame.getContentPane().add(txtData);


		
		
	
		
		
		// Campo texto Data de Telefone:
		lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds( 340, 100, 60, 20);
		frame.getContentPane().add(lblTelefone);

		txtTelefone = new JFormattedTextField(telefone);
		txtTelefone.setBounds(400, 100, 100, 20);
		frame.getContentPane().add(txtTelefone);
		

		
		
		
		// Campo texto Data de CPF:
		lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(60, 100, 140, 20);
		frame.getContentPane().add(lblCpf);

		txtCpf =  new JtextFieldSomenteNumeros(11);
		txtCpf.setBounds(190, 100, 140, 20);
		frame.getContentPane().add(txtCpf);

		

		
		// Campo texto Data de EMail:
		lblEMail = new JLabel("Email: ");
		lblEMail.setBounds(60, 140, 140, 20);
		frame.getContentPane().add(lblEMail);

		txtEmail   = new JTextField();
		txtEmail.setBounds(190, 140, 350, 20);
		frame.getContentPane().add(txtEmail);
		

		
		
		
		
		// Text area Endereço
		lblAddress = new JLabel("Endereço: ");
		lblAddress.setBounds(60, 180 , 100, 20);
		frame.getContentPane().add(lblAddress);

		txtAdress   = new JTextField();
		txtAdress.setBounds(190, 180, 350, 20);
		frame.getContentPane().add(txtAdress);

		
		
		
		// Radio Button Sexo
		
		sex = new ButtonGroup();
		
		sexInvisible = new JRadioButton("");
		sex.add(sexInvisible);
		sexInvisible.setSelected(true);
		
		lblSex = new JLabel("Sexo: ");
		lblSex.setBounds(60, 220, 46, 14);
		frame.getContentPane().add(lblSex);
		
		

		lblMale = new JLabel("Masculino");
		lblMale.setBounds(190, 220, 60, 20);
		frame.getContentPane().add(lblMale);
		
		radioButtonMale = new JRadioButton("");
		radioButtonMale.setBounds(250, 224, 20, 14);
		frame.getContentPane().add(radioButtonMale);
		sex.add(radioButtonMale);
		

		
		lblFemale = new JLabel("Feminino");
		lblFemale.setBounds(300, 220, 60, 20);
		frame.getContentPane().add(lblFemale);

		radioButtonFemale = new JRadioButton("");
		radioButtonFemale.setBounds(360, 224, 20, 14);
		frame.getContentPane().add(radioButtonFemale);
		sex.add(radioButtonFemale);

		// Combobox Disciplina
		lblOccupation = new JLabel("Curso: ");
		lblOccupation.setBounds(60, 260, 70, 14);
		frame.getContentPane().add(lblOccupation);

		comboBox = new JComboBox<String>();
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
		comboBox.setBounds(190, 260, 250, 20);
		frame.getContentPane().add(comboBox);

		// Botoes
		
		
		 btnClear = new JButton("Limpar");
		
		btnClear.setBackground(Color.YELLOW);
		btnClear.setBounds(380, 320, 89, 23);
		frame.getContentPane().add(btnClear);

		 btnSubmit = new JButton("Cadastrar");

		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(140, 320, 100, 23);
		frame.getContentPane().add(btnSubmit);
		

		frame.setVisible(true);
		
	
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (		txtName.getText().isEmpty() 
						||	ConferirData.isDate(txtData.getText()) == false 
						||  txtTelefone.getText().equals("(  )         ")
						||	txtCpf.getText().isEmpty()
						||	ConferirCpf.isCPF(txtCpf.getText()) == false
						||	txtEmail.getText().isEmpty()
						||	txtAdress.getText().isEmpty()
						||  sexInvisible.isSelected()
						||  comboBox.getSelectedItem().equals("Cursos disponíveis:"))	{

					if (txtName.getText().isEmpty()) {
						lblName.setForeground(Color.red);
					} else {
						lblName.setForeground(Color.black);
					}
				

					if (ConferirData.isDate(txtData.getText()) == false) {
						lblBirth.setForeground(Color.red);
					} else {

						lblBirth.setForeground(Color.black);
					}

					if (txtTelefone.getText().equals("(  )         ")) {
						lblTelefone.setForeground(Color.red);
					} else {
						lblTelefone.setForeground(Color.black);
					}

					if (txtCpf.getText().isEmpty() || ConferirCpf.isCPF(txtCpf.getText()) == false) {
						lblCpf.setForeground(Color.red);
					} else {
						lblCpf.setForeground(Color.black);
					}
					if (txtEmail.getText().isEmpty()) {
						lblEMail.setForeground(Color.red);
					} else {
						lblEMail.setForeground(Color.black);
					}
					if (txtAdress.getText().isEmpty()) {
						lblAddress.setForeground(Color.red);
					} else {
						lblAddress.setForeground(Color.black);
					}
					if (sexInvisible.isSelected()) {
						lblSex.setForeground(Color.red);
					} else {
						lblSex.setForeground(Color.black);
					}
					if(comboBox.getSelectedItem().equals("Cursos disponíveis:")) {
						lblOccupation.setForeground(Color.red);
					}	else {
						lblOccupation.setForeground(Color.black);
					}
					
					

				JOptionPane.showMessageDialog(btnSubmit, "Por favor corrigir os campos em vermelho", "Dados incorretos ou não preenchidos!", 1, null);
				
					
				} else {
						aluno = new Aluno();
						aluno.setCpf(txtCpf.getText());
						aluno.setNome(txtName.getText());

						String dateFormat = "dd/MM/uuuu";
				    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				    	   .ofPattern(dateFormat)
				    	   .withResolverStyle(ResolverStyle.STRICT);
				    	 LocalDate date = LocalDate.parse(txtData.getText(), dateTimeFormatter);
				    	 aluno.setDataNascimento(date);
						
				    	aluno.setEndereco(txtAdress.getText());
						aluno.setTelefone(txtTelefone.getText());
						aluno.seteMail(txtEmail.getText());
						aluno.setSexo(radioButtonMale.isSelected() ? "M" : "F");
						aluno.setCurso(comboBox.getSelectedItem().toString());
						
							lblName.setForeground(Color.black);
							lblBirth.setForeground(Color.black);
							lblTelefone.setForeground(Color.black);
							lblCpf.setForeground(Color.black);
							lblEMail.setForeground(Color.black);
							lblAddress.setForeground(Color.black);
							lblSex.setForeground(Color.black);
							lblOccupation.setForeground(Color.black);
						
						ControladorAluno controladorAluno = new ControladorAluno();
						controladorAluno.cadastrarAluno(aluno);
					
						JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
						
						ListaAluno.inicializarListaAlunos();
				}
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtData.setValue(null);
				txtTelefone.setValue(null);
				txtCpf.setText(null);
				txtEmail.setText(null);
				txtAdress.setText(null);
				sexInvisible.setSelected(true);
				comboBox.setSelectedItem("Cursos disponíveis:");
			
			}
		});
		
	}



}
