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

public class RepositorioEquipamentosArrayList implements IRepositorioEquipamentos, Serializable{
	private List<Cliente> listaClientes = null;
	private static RepositorioEquipamentosArrayList instance;

	private RepositorioEquipamentosArrayList() {
		this.listaClientes = new ArrayList(); 
	}

	public static RepositorioEquipamentosArrayList getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}

		return instance;
	}
	
	@Override
	public void cadastrar(Equipamento e) {
		// TODO Auto-generated method stub
		
	}
	
	private static RepositorioClientesArrayList lerDoArquivo() {
		RepositorioClientesArrayList instanciaLocal = null;

		File in = new File("clientes.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioClientesArrayList) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioClientesArrayList();
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
		File out = new File("clientes.dat");
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
	public void listar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String numSerie) throws EquipamentoNaoExisteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Equipamento buscar(String numSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Equipamento equip) throws EquipamentoNaoExisteException {
		// TODO Auto-generated method stub
		
	}

}
