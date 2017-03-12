package br.ufrpe.assistec.exceptions;

public class OSExisteException extends Exception{
	public OSExisteException(String numero) {
		super("A OS número: " + numero + "já está cadastrada no sistema.");
	}
}
