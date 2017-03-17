package br.ufrpe.assistec.gui;

import br.ufrpe.assistec.exceptions.TecnicoJahExisteException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastrarTecnicoController {
	@FXML private TextField txtNome;
	@FXML private TextField txtSobreNome;
	@FXML private TextField txtMatricula;
	@FXML private TextField txtEndereco;
	@FXML private TextField txtTelefone;
	@FXML private TextField txtEmail;
	@FXML private TextField txtLogin;
	@FXML private TextField txtSenha;
	@FXML private Button btnCadastrar;
	
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	
	@FXML public void cadastrar(ActionEvent event) {
		Tecnico tecnico = new Tecnico(txtLogin.getText(), txtSenha.getText(), txtMatricula.getText(), txtNome.getText(), txtSobreNome.getText(), txtEmail.getText(), txtTelefone.getText(), txtEndereco.getText(), 0);
		
		try{
			svr.cadastrarTecnico(tecnico);
			Alert inf = new Alert(AlertType.INFORMATION);
			inf.setContentText("Cliente Cadastrado com Sucesso!");
			inf.showAndWait();		
		}catch(TecnicoJahExisteException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
}
