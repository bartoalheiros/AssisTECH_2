package br.ufrpe.assistec.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.exceptions.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.beans.Cliente;
import br.ufrpe.assistec.negocio.beans.Equipamento;

public class RepositorioEquipamentoArrayList implements IRepositorioEquipamentos, Serializable{
	private List<Equipamento> listaEquipamentos = null;
	private static RepositorioEquipamentoArrayList instance;

	private RepositorioEquipamentoArrayList() {
		this.listaEquipamentos = new ArrayList(); 
	}

	public static RepositorioEquipamentoArrayList getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}

		return instance;
	}

	@Override
	public boolean cadastrar(Equipamento e) {
		if(getInstance().listaEquipamentos.contains(e)){
			return false;
		}else {
			getInstance().listaEquipamentos.add(e);
			this.salvarArquivo();
			return true;
		}

	}

	private static RepositorioEquipamentoArrayList lerDoArquivo() {
		RepositorioEquipamentoArrayList instanciaLocal = null;

		File in = new File("equipamentos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioEquipamentoArrayList) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioEquipamentoArrayList();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("equipamentos.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try { oos.close(); } catch (IOException e) {/*Silent*/}
			}
		}
	}


	@Override
	public List<Equipamento> listar() {
		return getInstance().listaEquipamentos;

	}

	@Override
	public void remover(String numSerie) {
		for(Equipamento equip: getInstance().listaEquipamentos) {
			if(equip.getNumSerie().equals(numSerie)) {
				getInstance().listaEquipamentos.remove(equip);
				this.salvarArquivo();
				break;
			}
		}

	}

	@Override
	public Equipamento buscar(String numSerie) {
		Equipamento equipamento = null;

		for(Equipamento equip: getInstance().listaEquipamentos) {
			if(equip.getNumSerie().equals(numSerie)) {
				equipamento = equip;
				break;
			}
		}


		return equipamento;
	}

	@Override
	public boolean atualizar(Equipamento equip) {
		List<Equipamento> instanciaLocal= getInstance().listaEquipamentos;
		boolean resultado = false;
		
		if(!instanciaLocal.contains(equip)) {
			resultado = false;
		}else {
			for(Equipamento equip2: instanciaLocal) {
				if(equip2.equals(equip)) {
					instanciaLocal.set(instanciaLocal.indexOf(equip2), equip);
					this.salvarArquivo();
					resultado = true;
				}
				
			}

		}
		
		return resultado;
	}

}
