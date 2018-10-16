import java.util.Date;
public class Professor extends Pessoa {
	public String disciplina;
	
	public Professor(String nome, String cpf, Date data, String endereco, String sexo, String telefone, String eMail, String disciplina) {
		
		
		super( nome,  cpf,  data,  endereco,  sexo,  telefone,  eMail);
		
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
		
		
}
