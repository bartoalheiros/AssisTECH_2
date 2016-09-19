/*Levantada quando um Cliente for ser alterado, mas ele não está cadastrado no sistema.*/

package br.ufrpe.assistec.negocio;

public class ClienteNaoCadastradoException extends Exception {
	
	public ClienteNaoCadastradoException(String cpf) {
		super("O cpf " + cpf + " não é referente a nenhum cliente cadastrado neste Sistema.");
	}
}
