package br.ufrpe.assistec.negocio;

public class EquipamentoNaoExisteException extends Exception{
	private String numSerie;
	
	public EquipamentoNaoExisteException(String numSerie) {
		super("O equipamento " + numSerie + " não está cadastrado no sistema.");
		this.numSerie = numSerie;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	
}
