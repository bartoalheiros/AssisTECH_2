package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.negocio.beans.Login;

public interface IRepositorioLogin {
	public void adicionar(Login lgn);
	
	public Login buscar(String usrName);
}

