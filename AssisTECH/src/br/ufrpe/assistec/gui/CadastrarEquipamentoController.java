package br.ufrpe.assistec.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.assistec.exceptions.EquipamentoExisteException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Equipamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastrarEquipamentoController implements Initializable{
	@FXML Button btnCadastrar;
	@FXML TextField txtTipo;
	@FXML TextField txtPortador;
	@FXML TextField txtNumeroDaOS;
	@FXML TextField txtNumSerie;
	@FXML TextArea txtCharDefeito;
	@FXML TextArea txtRelatorio;
	@FXML ComboBox<String> cbbxUrgencia;
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	
	ObservableList<String> list = FXCollections.observableArrayList("Alta", "Média", "Baixa");
	
	@FXML public void cadastrar(ActionEvent event) {
		Equipamento equip = new Equipamento();
		equip.setTipo(txtTipo.getText());
		equip.setNomePortador(txtPortador.getText());
		equip.setNumeroDeOrdem(txtNumeroDaOS.getText());
		equip.setNumeroSerie(txtNumSerie.getText());
		equip.setCaracteristicasDoDefeito(txtCharDefeito.getText());
		equip.setRelatorio(txtRelatorio.getText());
		
		try {
			svr.cadastrarEquipamento(equip);
		} catch (EquipamentoExisteException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbbxUrgencia.setItems(list);
		
	}
}
