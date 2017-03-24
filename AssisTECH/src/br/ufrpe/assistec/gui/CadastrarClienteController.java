package br.ufrpe.assistec.gui;

import br.ufrpe.assistec.exceptions.ClienteJahCadastradoException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class CadastrarClienteController {
	@FXML private TextField txtNome;
	@FXML private TextField txtSobreNome;
	@FXML private TextField txtCpf;
	@FXML private TextField txtEndereco;
	@FXML private TextField txtTelefone;
	@FXML private TextField txtEmail;
	@FXML private TextField txtLogin;
	@FXML private TextField txtSenha;
	@FXML private Button btnCadastrar;
	
	ServidorAssisTech serv = ServidorAssisTech.getInstance();
	
	Long cpf = null;
	
	@FXML public void cadastrar() throws NumberFormatException, ClienteJahCadastradoException {
		
		//testando o campo CPF
		try{
			cpf = Long.parseLong(txtCpf.getText());
		}catch(NumberFormatException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText("Preencha o campo CPF corretamente.");
			err.showAndWait();
			return;
		}
		
		
		
		//instanciando o cliente
		Cliente cliente = new Cliente(txtLogin.getText(), txtSenha.getText(), cpf, txtNome.getText(), txtSobreNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtEmail.getText(), 0);
		
		
		
		//cadastrando o cliente
		try {
			serv.cadastrarCliente(cliente);
			Alert inf = new Alert(AlertType.INFORMATION);
			inf.setContentText("Cliente Cadastrado com Sucesso!");
			inf.showAndWait();
		} catch (ClienteJahCadastradoException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	
	}
}
