package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.negocio.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.beans.Equipamento;

public interface IRepositorioEquipamentos {
	public void cadastrar (Equipamento e);
	
	public void listar();
	
	public void remover(String numSerie) throws EquipamentoNaoExisteException;
	
	public Equipamento buscar(String numSerie);
	
	public void atualizar(Equipamento equip) throws EquipamentoNaoExisteException;
}
