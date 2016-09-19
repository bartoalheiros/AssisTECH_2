package br.ufrpe.assistec.negocio.beans;

public class Ordem {

	private String numero;
	private Cliente cliente;
	private Equipamento equipamento;
	private Tecnico tecnicoResponsavel;
	private String dataEntrada;
	private String dataEntrega;
	private String nomePortador; //O portador é A pessoa que recebeu o equipamento, das mãos do cliente, na entrada. Que será um funcionário da loja: técnico ou atendente.
	private String prioridade;
	private String caracteristicasDefeito;
    private String relatorioDeManutencao;

	public void setTecnicoResponsavel(Tecnico tecnico) {
		this.tecnicoResponsavel = tecnico;
	}
	
	public Tecnico getTecnicoResponsavel() {
		return this.tecnicoResponsavel;
	}
    
    public void setPortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}
	
	public String getPortador() {
		return this.nomePortador;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

    public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Equipamento getEquipamento() {
		return this.equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public String getCaracteristicasDefeito() {
		return caracteristicasDefeito;
	}
	public void setCaracteristicasDefeito(String caracteristicasDefeito) {
		this.caracteristicasDefeito = caracteristicasDefeito;
	}
	
	public String getRelatorioDeManutencao() {
		return this.relatorioDeManutencao;
	}
	
	public void setRelatorioDeManutencao(String relatorioDeManutencao) {
		this.relatorioDeManutencao = relatorioDeManutencao;
	}
	
	public void modificarRelatorioDeManutencao(String relatorioDeManutencao) {
		this.relatorioDeManutencao = this.relatorioDeManutencao + " " + relatorioDeManutencao; //concatena a String recebida de relatorio e acrescenta à antiga.
	}

	public boolean equals(Ordem ordem) {
		boolean resultado = false;
		if(ordem.getNumero() == this.numero) {
			resultado = true;
		}

		return resultado;
	}
	
	@Override
	public String toString() {
		return "OS No: " + this.numero +"\n" + "Data: " + this.dataEntrada + "\n" + "Portador: " + this.nomePortador + "\n\n" + "                 Cliente"+ "\n\n" + this.cliente.toString() + "\n" + "                 Equipamento" + "\n\n" + this.equipamento.toString() + "\n" + "Características do Defeito: \n" + this.getCaracteristicasDefeito() + "\n\n" + "Técnico Responsável" + "\n"  + this.tecnicoResponsavel.toString() + "\n\n" + "Relatório de Manutenção" + "\n" + this.relatorioDeManutencao + "\n\n";
	}
	
	public String toStringPrioridades() {
		return "Cliente: " + "  " + "OS no: " + "Data de Abertura" + "Equipamento" + "Prioridade" + "\n" + this.cliente.getNomeCompleto() + "  " + this.numero + "  " + this.dataEntrada + "  " + this.equipamento.getTipo() + "  " + this.prioridade; 
	}
	
	public String toStringResumo() {
		
		String resultado = String.format("%7s %5s\n", "OS no: ", this.numero);
		resultado += String.format("%6s %10s\n", "Data: ", this.dataEntrada);
		resultado += String.format("%6s %10s\n", "Cliente: ", this.cliente.getNomeCompleto());
		resultado += String.format("%6s %10s\n", "Equip: ", this.equipamento.getTipo());
		resultado += String.format("%6s %10s", "Defeito: ", this.getCaracteristicasDefeito());
		
		return resultado;
	}
	
	public String toStringDatas() {
		
		String resultado = String.format("%7s %5s\n", "OS no: ", this.numero);
		resultado += String.format("%6s %10s\n", "Data: ", this.dataEntrada);
		
		return resultado;
	}
	
	/*
	 * Método que mostra uma tabela com todas as OS's cadastradas.
	 * 
	 * */
	public String toStringTabela() {
		String resultado = "************************************\n";
		resultado += String.format("%16s %15s\n","OS no", "Cliente");
		resultado += "************************************\n";
		//return "OS no: " +"\n"+ this.numero + "Cliente: " +  this.cliente.getNomeCompleto() + "\n" + "Equipamento: " + this.equipamento.getTipo() + "\n" + "Série: " + this.equipamento.getNumeroSerie() +"\n" + "-------------------------------------------------------------------";
		return resultado;
	}
}
