package br.ufrpe.assistec.negocio.beans;

import java.io.Serializable;

public class Cliente extends Usuario implements Comparable<Cliente>, Serializable{

	private Long cpf;


	public Cliente(String usrName, String psswd, Long cpf, String primeiroNome,String segundoNome, String endereco, String telefone, String email, int numOrdens) {
		super(usrName, psswd, primeiroNome, segundoNome, email, telefone, endereco, numOrdens);
		this.setCpf(cpf);
	}

	public Cliente(Long cpf) {
		this.cpf = cpf;
	}

	public Cliente () {

	}

	public Long getCpf() {
		return this.cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public boolean equals(Cliente cli) {
		if(this.cpf.equals(cli.getCpf())){
			return true;
		}

		return false;
	}

	public String toString() {
		String resultado = String.format("%5s %5s\n", "cpf: ", this.cpf);
		resultado += super.toString();
		resultado += String.format("%5s %5s\n", "Endereço: ", this.endereco);

		return resultado;
	}

	public static void main(String[] args) {
		//Cliente c1 = new Cliente("032890098-78", "João", "da Silva Júnior", "Rua Leão Coroado, 109, Jardim Brasil, Olinda - PE", "3729-0452", "joao_da_silva_37@yahoo.com.br", 12);

		//System.out.println(c1);

	}

	@Override
	public int compareTo(Cliente cli) {
		
		return this.getNomeCompleto().compareTo(cli.getNomeCompleto());
	}

}
