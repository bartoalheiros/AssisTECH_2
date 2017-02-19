/*Levantada quando o número de OS o qual está se buscando não for encontrado no sistema.*/

package br.ufrpe.assistec.negocio;

public class OSNaoEncontradaException extends Exception {
	public OSNaoEncontradaException(String numero){
		super("Os numero: " + numero + "não está cadastrada no sistema.");
	}
}
