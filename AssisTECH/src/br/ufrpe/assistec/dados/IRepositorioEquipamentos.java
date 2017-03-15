package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.exceptions.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.beans.Equipamento;

public interface IRepositorioEquipamentos {
	public void cadastrar (Equipamento e);
	
	public void listar();
	
	public void remover(String numSerie) throws EquipamentoNaoExisteException, br.ufrpe.assistec.exceptions.EquipamentoNaoExisteException;
	
	public Equipamento buscar(String numSerie);
	
	public void atualizar(Equipamento equip) throws EquipamentoNaoExisteException;
}
