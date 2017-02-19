package br.ufrpe.assistec.negocio;

public class TecnicoNaoCadastradoException extends Exception {
	public TecnicoNaoCadastradoException(String mat) {
		super("O técnico com matricula: " + mat + "não está cadastrado no sistema.");
	}
}
