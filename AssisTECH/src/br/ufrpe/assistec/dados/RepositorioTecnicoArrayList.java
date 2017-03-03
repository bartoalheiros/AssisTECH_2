package br.ufrpe.assistec.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.negocio.beans.Tecnico;

public class RepositorioTecnicoArrayList implements IRepositorioTecnicos {
	List<Tecnico> listaTecnicos = null;
	
	public RepositorioTecnicoArrayList() {
		this.listaTecnicos = new ArrayList();
	}
	
	@Override
	public void cadastrar(Tecnico tecnico) {
		this.listaTecnicos.add(tecnico);

	}

	@Override
	public Tecnico buscar(String mat) {
		Tecnico tecnico = null;
		
		for(Tecnico tec: this.listaTecnicos) {
			if(tec.getMatricula().equals(mat)) {
				tecnico = tec;
				break;
			}
		}
		return tecnico;
	}

	public List<Tecnico> listarTodos() {
		return this.listaTecnicos;

	}

	@Override
	public boolean remover(String matricula) {
		Tecnico tecnico = null;
		boolean r = false;
		
		for(Tecnico tec: this.listaTecnicos) {
			if(tec.getMatricula().equals(matricula)) {
				tecnico = tec;
				r = true;
			}
		}
		return r;
	}

	@Override
	public void atualizar(Tecnico tec) {
		

	}

}
