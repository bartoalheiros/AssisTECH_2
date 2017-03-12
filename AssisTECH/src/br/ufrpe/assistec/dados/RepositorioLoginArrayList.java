package br.ufrpe.assistec.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.negocio.beans.Login;

public class RepositorioLoginArrayList implements IRepositorioLogin{

	public List<Login> listaLogin = null;
	private static RepositorioLoginArrayList instance;
	
	private RepositorioLoginArrayList() {
		this.listaLogin = new ArrayList();
	}
	
	public static RepositorioLoginArrayList getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}
		
		return instance;
	}
	
	@Override
	public void adicionar(Login lgn) {
		getInstance().adicionar(lgn);
		this.salvarArquivo();
		
	}

	@Override
	public Login buscar(String usrName) {
		
		
	}
	
	private static RepositorioLoginArrayList lerDoArquivo() {
		RepositorioLoginArrayList instanciaLocal = null;

		File in = new File("login.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioLoginArrayList) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioLoginArrayList();
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
		File out = new File("login.dat");
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


}
