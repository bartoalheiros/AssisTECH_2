package br.ufrpe.assistec.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.assistec.exceptions.NomeDeUsuarioOuSenhaInvalidaException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable{
	@FXML private TextField txtUserName;
	@FXML private TextField txtPassWord;
	@FXML private Button btnAcessar;
	@FXML private ComboBox privilegio;
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	
	
	@FXML public void ckLoginData(ActionEvent event) throws IOException {
		String usrName = new String(txtUserName.getText());
		String pswd = new String(txtPassWord.getText());
		
		if(privilegio.getValue().equals("Cliente")) {
			try {
				svr.buscarClientePorLogin(usrName, pswd);
				((Node)event.getSource()).getScene().getWindow().hide();
				Parent parent = FXMLLoader.load(getClass().getResource("Janela1.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setTitle("AssisTech");
				stage.setMaximized(true);
				stage.show();
			} catch (NomeDeUsuarioOuSenhaInvalidaException e) {
				Alert err = new Alert(AlertType.ERROR);
				err.setContentText(e.getMessage());
				err.showAndWait();
			}
		}else{
			try {
				svr.buscarTecnicoPorLogin(usrName, pswd);
				((Node)event.getSource()).getScene().getWindow().hide();
				Parent parent = FXMLLoader.load(getClass().getResource("Janela1.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setTitle("AssisTech");
				stage.show();
			} catch (NomeDeUsuarioOuSenhaInvalidaException e) {
				Alert err = new Alert(AlertType.ERROR);
				err.setContentText(e.getMessage());
				err.showAndWait();
			}
		}
		
		
	} 
	
	ObservableList<String> list = FXCollections.observableArrayList("Cliente", "Técnico");

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		privilegio.setItems(list);
		
	}
}
