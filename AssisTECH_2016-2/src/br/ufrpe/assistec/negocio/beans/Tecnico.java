package br.ufrpe.assistec.negocio.beans;

public class Tecnico extends Usuario {
	private String matricula;

	public Tecnico(String matricula) {
		this.matricula = matricula;
	}

	public Tecnico() {

	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String toString() {
		String resultado = String.format("%5s %5s\n", "Nome: ", this.nomeCompleto);
		resultado += String.format("%6s %5s\n", "Email: ", this.email);
		resultado += String.format("%7s %1s\n", "Telefone: ", this.telefone);
		resultado += String.format("%6s %1s\n", "OS's: ", this.numOrdens);

		return resultado;
	}
}
