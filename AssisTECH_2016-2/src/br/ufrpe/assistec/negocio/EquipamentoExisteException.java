package br.ufrpe.assistec.negocio;

public class EquipamentoExisteException extends Exception {
	
	private String numSerie;
	
	public EquipamentoExisteException(String numSerie){
		super("Impossível cadastrar o equipamento " + numSerie +  " \n Um outro equipamento com o mesmo no de Série já está cadastrado no sistema.");
		this.numSerie = numSerie;
	}
	
	public EquipamentoExisteException(){
		
	}
	
	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

}
