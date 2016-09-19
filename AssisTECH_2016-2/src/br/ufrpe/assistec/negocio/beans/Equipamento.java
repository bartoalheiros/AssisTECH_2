package br.ufrpe.assistec.negocio.beans;


/*Regrinhas: 1 - se o no da OS for '0' ele não está em NENHUMA OS*/

public class Equipamento {
    private String tipo;
    private String numSerie;
    private String numOS;
    
    public Equipamento(String tipo, String numSerie, String numOS) {
		this.tipo = tipo;
		this.numSerie = numSerie;
		this.numOS = numOS;
	}
    
    public Equipamento() {
    	this.numOS = "00";
    }
    
    public String getOs() {
		return numOS;
	}
	public void setOs(String os) {
		this.numOS = os;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumeroSerie() {
		return numSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numSerie = numeroSerie;
	}
	
    public String toString() {
    	
    	String resultado = String.format("%7s %5s\n", "Numero de Série: ", this.numSerie);
    	resultado += String.format("%6s %5s\n", "Equipamento: ", this.tipo);
    	resultado += String.format("%7s %1s\n", "Os no: ", this.numOS);
    	
    	return resultado;
	}
    
    public boolean equals(Equipamento equip) {
    	boolean resultado = false;
    	if(this.numSerie.equals(equip.getNumeroSerie())) {
    		resultado = true;
    	}
    	
    	return resultado;
    }
    
    
    public static void main(String[] args) {
    	Equipamento e1 = new Equipamento();
    	Equipamento e2 = new Equipamento();
    	Equipamento e3 = new Equipamento();
    	
    	e1.setTipo("Guitarra");
    	e1.setNumeroSerie("Marshall 332");
    	e1.setOs("112");
    	
    	System.out.println(e1);
    }
}
