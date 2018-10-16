import java.util.Date;
public class Aluno extends Pessoa {
	public String matricula;
	
	public Aluno(String nome, String cpf, Date data, String endereco, String sexo, String telefone, String eMail, String matricula) {
		super( nome,  cpf,  data,  endereco,  sexo,  telefone,  eMail);
		
		this.matricula = matricula;
	
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
		
		
		
}
