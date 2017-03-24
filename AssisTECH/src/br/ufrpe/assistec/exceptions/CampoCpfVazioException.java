package br.ufrpe.assistec.exceptions;

public class CampoCpfVazioException extends Exception {
	public CampoCpfVazioException() {
		super("Preencha o campo CPF!");
	}
}
