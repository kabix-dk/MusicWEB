package pb.wi.musicweb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pb.wi.musicweb.modelFX.ProducentFX;
import pb.wi.musicweb.modelFX.ProducentModel;

public class ProducentController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField nickTextField;
    @FXML
    private Button addButton;

    @FXML
    private TableView<ProducentFX> producentTableView;
    @FXML
    private TableColumn<ProducentFX, String> nameColumn;
    @FXML
    private TableColumn<ProducentFX, String> surnameColumn;
    @FXML
    private TableColumn<ProducentFX, String> nickColumn;

    private ProducentModel producentModel;

    public void initialize() {
        this.producentModel = new ProducentModel();
        this.producentModel.init();
        this.producentModel.producentFXObjectPropertyProperty().get().nameProperty().bind(this.nameTextField.textProperty());
        this.producentModel.producentFXObjectPropertyProperty().get().surnameProperty().bind(this.surnameTextField.textProperty());
        this.producentModel.producentFXObjectPropertyProperty().get().nickProperty().bind(this.nickTextField.textProperty());
        this.addButton.disableProperty().bind(this.nameTextField.textProperty().isEmpty().or(this.surnameTextField.textProperty().isEmpty().or(this.nickTextField.textProperty().isEmpty())));

        this.producentTableView.setItems(this.producentModel.getProducentFXObservableList());
        this.nameColumn.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        this.surnameColumn.setCellValueFactory(cellData-> cellData.getValue().surnameProperty());
        this.nickColumn.setCellValueFactory(cellData-> cellData.getValue().nickProperty());
    }

    public void addProducentOnAction(ActionEvent actionEvent) {
        this.producentModel.saveProducentInDataBase();
        this.nameTextField.clear();
        this.surnameTextField.clear();
        this.nickTextField.clear();
    }
}
