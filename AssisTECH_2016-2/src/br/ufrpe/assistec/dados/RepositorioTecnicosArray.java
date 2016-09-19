package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.negocio.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.beans.Equipamento;
import br.ufrpe.assistec.negocio.beans.Tecnico;

public class RepositorioTecnicosArray implements IRepositorioTecnicos {
	private Tecnico[] tecnicos;
	private int proximo;
	
	public RepositorioTecnicosArray() {
		this.tecnicos = new Tecnico[100];
		this.proximo = 0;
	}
	
	public boolean existe(Tecnico tecnico) {
		boolean resultado = false;
		
		for(int i = 0; i < this.proximo; i++) {
			if(this.tecnicos[i].getMatricula().equals(tecnico.getMatricula())){
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	
	public void cadastrar(Tecnico tecnico) {
		if(this.existe(tecnico)) {
			//TecnicoJahExisteException
		} else{
			this.tecnicos[this.proximo] = tecnico;
			this.proximo++;
		}
	}
	
	public void listar() {
		if(this.proximo > 0){
			for(int i = 0; i < this.proximo; i++) {
				System.out.println(tecnicos[i]);
			}
		} else {
			System.out.println("Nenhum tecnico cadastrado.");
		}
	}
	
	/*buscar: Caso encontre a matrícula procurada, devolve a instância de Tecnico que possue tal matrícula.*/
	
	public Tecnico buscar(String mat){
		Tecnico tec = null;
		
		for(int i = 0; i < this.proximo; i++) {
			if(this.tecnicos[i].getMatricula().equals(mat)) {
				tec = new Tecnico();
				tec = this.tecnicos[i];
			}
		}
		
		return tec;
	}

	
	public void remover(String matricula) {
		int i = this.procurarIndice(matricula);                          //removerCadastro(String cpf) - remove o cadastro do array de clientes, seguindo as regras
		if(i == this.proximo - 1) {                                            // 1 -  se o cliente for o último do array, ou seja, se i == this.proximo - 1 
			this.tecnicos[i] = null;                                           // esta posição recebe null 
			this.proximo = this.proximo - 1;                                   // o próximo passa a ser ela ou seja: this.proximo = proximo - 1  
			System.out.print("Técnico Removido com Sucesso.");
		}else{
			this.tecnicos[i] = this.tecnicos[this.proximo - 1];                //Se o cliente não for o último do array
			this.tecnicos[this.proximo -  1] = null;                           //linha 44  o cliente na posição i, que eu encontrei, receberá o cliente da última posição
			this.proximo = this.proximo - 1;                                   //linha 45 então eu atualizo a última posição para null
			System.out.print("Técnico Removido com Sucesso.");                 // linha 46 eu atualizo o valor de próxima para próximo - 1 e a última posição passa
		}		                                                                   // a ser a que era penúltima, anteriormente.
	}
		
	
	public int procurarIndice(String matr) {
		int indice = 0, i;
		for(i = 0; i < this.proximo; i++) { 
			if( this.tecnicos[i].getMatricula().equals(matr) ) { 
				indice = i;
				break;
			}
		}
		if(i == this.proximo) {
			//IndiceNaoEncontradoException
		}
		
		return indice;
	}
	
	public int procurarIndice(Tecnico tec) {
		String mat = tec.getMatricula();
		int indice = 0, i;
		
		for(i = 0; i < this.proximo; i++) { 
			if( this.tecnicos[i].getMatricula().equals(mat) ) { 
				indice = i;
				break;
			}
		}
		
		return indice;
	} 

	
	public void atualizar(Tecnico tec) {
		int i;
		
		i = procurarIndice(tec);
		this.tecnicos[i] = tec;
		
	}
}
