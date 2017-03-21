package br.ufrpe.assistec.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CadastrarEquipamentoController implements Initializable{
	@FXML Button btnCadastrar;
	@FXML ComboBox<String> cbbxUrgencia;
	
	ObservableList<String> list = FXCollections.observableArrayList("Alta", "Média", "Baixa");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbbxUrgencia.setItems(list);
		
	}
}
