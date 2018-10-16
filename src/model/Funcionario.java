package model;

import java.util.Date;

public class Funcionario extends Pessoa {
	public String cargo;
	public int codigo;
	public String salario;
	public String valeAlimentacao;
	public String valeRefeicao;
	public String valeTransporte;
	public String nomeFilho;
	public String filhoDataNascimento;
	public String disciplina;







	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getValeAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeAlimentacao(String valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	public String getValeRefeicao() {
		return valeRefeicao;
	}

	public void setValeRefeicao(String valeRefeicao) {
		this.valeRefeicao = valeRefeicao;
	}

	public String getValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(String valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public String getNomeFilho() {
		return nomeFilho;
	}

	public void setNomeFilho(String nomeFilho) {
		this.nomeFilho = nomeFilho;
	}

	public String getFilhoDataNascimento() {
		return filhoDataNascimento;
	}

	public void setFilhoDataNascimento(String filhoDataNascimento) {
		this.filhoDataNascimento = filhoDataNascimento;
	}

	
	
	public String getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
