package br.ufrpe.assistec.negocio.beans;

import java.io.Serializable;

public class Usuario implements Serializable{
	protected String primeiroNome;
	protected String segundoNome;
	protected String email;
	protected String telefone;
	protected String endereco;
	protected int numOrdens;
	protected String usrName;
	protected String passwrd;

	
	public Usuario(String usrName, String psswrd, String primeiroNome, String segundoNome, String email, String telefone, String endereco, int numOrdens) {
		this.setPrimeiroNome(primeiroNome);
		this.setSegundoNome(segundoNome);
		this.setUsrName(usrName);
		this.setPasswrd(psswrd);
		this.email = email;
		this.telefone = telefone;
		this.numOrdens = numOrdens;
		this.endereco = endereco;
	}

	public Usuario(){

	}
	
	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public long getNumOrdens() {
		return numOrdens;
	}

	public void setNumOrdens(int numOrdens) {
		this.numOrdens = numOrdens;
	}


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPrimeiroNome() {
		return this.primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone ( String telefone ) {
		this.telefone = telefone;
	}

	public void aumentarNumOrdens() {
		this.numOrdens++;
	}

	public String toString() {
		String resultado = String.format("%5s %5s\n", "Nome: ", this.primeiroNome + " " + this.segundoNome);
		//resultado += String.format("%5s %5s\n", "Sobrenome: ", this.segundoNome);
		resultado += String.format("%6s %5s\n", "Email: ", this.email);
		resultado += String.format("%7s %1s\n", "Telefone: ", this.telefone);
		resultado += String.format("%5s %1s\n", "OS's: ", this.numOrdens);

		return resultado;
	}

	public static void main(String[] args) {

	}

}
