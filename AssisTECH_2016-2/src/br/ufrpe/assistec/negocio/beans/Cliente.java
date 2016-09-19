package br.ufrpe.assistec.negocio.beans;

public class Cliente extends Usuario {
	
	private String cpf;
	
    
	public Cliente(String cpf, String nomeCompleto, String endereco, String telefone, String email, int numOrdens) {
		super(nomeCompleto, email, telefone, endereco, numOrdens);
		this.cpf = cpf;
	}
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente () {
		
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String toString() {
		String resultado = String.format("%5s %5s\n", "cpf: ", this.cpf);
    	resultado += super.toString();
    	resultado += String.format("%5s %5s\n", "Endereço: ", this.endereco);
    	
    	return resultado;
	}

	public static void main(String[] args) {
	    Cliente c1 = new Cliente("032890098-78", "João da Silva Júnior", "Rua Leão Coroado, 109, Jardim Brasil, Olinda - PE", "3729-0452", "joao_da_silva_37@yahoo.com.br", 12);
	    	
	    System.out.println(c1);

	}

}
