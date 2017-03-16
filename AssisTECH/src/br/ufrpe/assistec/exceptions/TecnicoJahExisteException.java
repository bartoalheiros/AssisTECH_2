package br.ufrpe.assistec.exceptions;

public class TecnicoJahExisteException extends Exception {
	public TecnicoJahExisteException(String mat, String nome) {
		super("O técnico " + nome + "\n Matricula:  " + mat + "já está cadastrado no sistema!");
	}
}
