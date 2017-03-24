/*Levantada quando um Cliente for ser alterado, mas ele não está cadastrado no sistema.*/

package br.ufrpe.assistec.exceptions;

public class ClienteNaoCadastradoException extends Exception {

	public ClienteNaoCadastradoException(Long cpf) {
		super("O cpf " + cpf + " não é referente a nenhum cliente cadastrado neste Sistema.");
	}
}
