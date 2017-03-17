package br.ufrpe.assistec.negocio.beans;

public class Tecnico extends Usuario {
	private String matricula;

	public Tecnico(String usrName, String psswd, String mat, String primeiroNome, String segundoNome, String email, String telefone, String endereco, int numOrdens) {
		super(usrName, psswd, primeiroNome, segundoNome, email, telefone, endereco, numOrdens);
		this.matricula = mat;
	}

	public Tecnico() {

	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public boolean equals(Tecnico tec) {
		if(tec.getMatricula().equals(this.getMatricula())) {
			return true;
		}
		
		return false;
	}

	public String toString() {
		String resultado = String.format("%5s %5s\n", "Nome: ", this.primeiroNome + this.segundoNome);
		resultado += String.format("%6s %5s\n", "Email: ", this.email);
		resultado += String.format("%7s %1s\n", "Telefone: ", this.telefone);
		resultado += String.format("%6s %1s\n", "OS's: ", this.numOrdens);

		return resultado;
	}

	public void setNomeCompleto(String string) {
		// TODO Auto-generated method stub
		
	}
}
