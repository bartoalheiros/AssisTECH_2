package br.ufrpe.assistec.gui;

import br.ufrpe.assistec.exceptions.NomeDeUsuarioOuSenhaInvalidaException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LoginController {
	@FXML TextField txtUserName;
	@FXML TextField txtPassWord;
	@FXML Button btnAcessar;
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	
	
	@FXML public void ckLoginData() {
		String usrName = new String(txtUserName.getText());
		String pswd = new String(txtPassWord.getText());
		
		try {
			svr.buscarClientePorLogin(usrName, pswd);
		} catch (NomeDeUsuarioOuSenhaInvalidaException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
}
