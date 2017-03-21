package br.ufrpe.assistec.negocio.beans;


/*Regrinhas: 1 - se o no da OS for '0' ele não está em NENHUMA OS*/

public class Equipamento {
	
	private String numSerie;
	private String tipo;
	private String numOS;
	private String prioridade;
	private String caracteristicasDoDefeito;
	private String relatorio;
	private String nomePortador; // O portador é A pessoa que recebeu o equipamento, das mãos do cliente, na entrada. Que será um funcionário da loja: técnico ou atendente.
	
	public Equipamento(String tipo, String numSerie, String numOS) {
		this.tipo = tipo;
		this.numSerie = numSerie;
		this.numOS = numOS;
	}
	
	public Equipamento() {
		this.numOS = "00";
	}

	public String getNumOS() {
		return numOS;
	}

	public void setNumOS(String numOS) {
		this.numOS = numOS;
	}

	public String getNomePortador() {
		return nomePortador;
	}

	public void setNomePortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}

	public String getNumeroDeOrdem() {
		return numOS;
	}
	public void setNumeroDeOrdem(String numeroDaOrdem) {
		this.numOS = numeroDaOrdem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getCaracteristicasDoDefeito() {
		return caracteristicasDoDefeito;
	}

	public void setCaracteristicasDoDefeito(String caracteristicasDoDefeito) {
		this.caracteristicasDoDefeito = caracteristicasDoDefeito;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
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
		resultado += String.format("%7s %1s\n", "Prioridade : ", this.prioridade);
		resultado += String.format("%7s %1s\n", "Os no: ", this.numOS);
		resultado += String.format("%7s %1s\n", "Os no: ", this.numOS);
		resultado += String.format("%7s %1s\n", "Os no: ", this.numOS);
		resultado += String.format("%7s %1s\n", "Os no: ", this.numOS);

		return resultado;
	}

	public boolean equals(Equipamento equip) {
		
		if(this.numSerie.equals(equip.getNumeroSerie())) {
			return true;
		}

		return false;
	}


	public static void main(String[] args) {
		Equipamento e1 = new Equipamento();
		Equipamento e2 = new Equipamento();
		Equipamento e3 = new Equipamento();

		e1.setTipo("Guitarra");
		e1.setNumeroSerie("Marshall 332");
		e1.setNumeroDeOrdem("112");

		System.out.println(e1);
	}
}
