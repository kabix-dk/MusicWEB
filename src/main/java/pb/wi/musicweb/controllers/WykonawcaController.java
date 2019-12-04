package pb.wi.musicweb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pb.wi.musicweb.modelFX.WykonawcaFX;
import pb.wi.musicweb.modelFX.WykonawcaModel;

public class WykonawcaController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField nickTextField;
    @FXML
    private Button addButton;

    @FXML
    private TableView<WykonawcaFX> wykonawcaTableView;
    @FXML
    private TableColumn<WykonawcaFX, String> nameColumn;
    @FXML
    private TableColumn<WykonawcaFX, String> surnameColumn;
    @FXML
    private TableColumn<WykonawcaFX, String> nickColumn;

    private WykonawcaModel wykonawcaModel;

    public void initialize() {
        this.wykonawcaModel = new WykonawcaModel();
        this.wykonawcaModel.init();
        this.wykonawcaModel.wykonawcaFXObjectPropertyProperty().get().nameProperty().bind(this.nameTextField.textProperty());
        this.wykonawcaModel.wykonawcaFXObjectPropertyProperty().get().surnameProperty().bind(this.surnameTextField.textProperty());
        this.wykonawcaModel.wykonawcaFXObjectPropertyProperty().get().nickProperty().bind(this.nickTextField.textProperty());
        this.addButton.disableProperty().bind(this.nameTextField.textProperty().isEmpty().or(this.surnameTextField.textProperty().isEmpty().or(this.nickTextField.textProperty().isEmpty())));

        this.wykonawcaTableView.setItems(this.wykonawcaModel.getWykonawcaFXObservableList());
        this.nameColumn.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        this.surnameColumn.setCellValueFactory(cellData-> cellData.getValue().surnameProperty());
        this.nickColumn.setCellValueFactory(cellData-> cellData.getValue().nickProperty());
    }

    public void addWykonawcaOnAction(ActionEvent actionEvent) {
        this.wykonawcaModel.saveWykonawcaInDataBase();
        this.nameTextField.clear();
        this.surnameTextField.clear();
        this.nickTextField.clear();
    }
}
