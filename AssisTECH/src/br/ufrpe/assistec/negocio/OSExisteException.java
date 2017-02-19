package br.ufrpe.assistec.negocio;

public class OSExisteException extends Exception{
	public OSExisteException(String numero) {
		super("A OS número: " + numero + "já está cadastrada no sistema.");
	}
}
