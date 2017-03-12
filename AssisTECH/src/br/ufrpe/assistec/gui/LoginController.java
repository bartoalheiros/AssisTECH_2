package br.ufrpe.assistec.gui;

import br.ufrpe.assistec.negocio.ServidorAssisTech;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML TextField txtUserName;
	@FXML TextField txtPassWord;
	ServidorAssisTech svr = ServidorAssisTech.getInstance(); 
	
	@FXML public void ckLoginData() {
		
	}
}
