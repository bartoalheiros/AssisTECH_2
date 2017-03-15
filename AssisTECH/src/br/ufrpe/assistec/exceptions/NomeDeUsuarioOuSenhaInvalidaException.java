package br.ufrpe.assistec.exceptions;

public class NomeDeUsuarioOuSenhaInvalidaException extends Exception {
	public NomeDeUsuarioOuSenhaInvalidaException() {
		super("Nome de Usuário ou Senha Inválidos!");
	}
}
