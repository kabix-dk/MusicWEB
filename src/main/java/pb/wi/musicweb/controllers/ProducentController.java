package pb.wi.musicweb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    private ProducentModel producentModel;

    public void initialize() {
        this.producentModel = new ProducentModel();
        this.producentModel.producentFXObjectPropertyProperty().get().nameProperty().bind(this.nameTextField.textProperty());
        this.producentModel.producentFXObjectPropertyProperty().get().surnameProperty().bind(this.surnameTextField.textProperty());
        this.producentModel.producentFXObjectPropertyProperty().get().nickProperty().bind(this.nickTextField.textProperty());
        this.addButton.disableProperty().bind(this.nameTextField.textProperty().isEmpty().or(this.surnameTextField.textProperty().isEmpty().or(this.nickTextField.textProperty().isEmpty())));
    }

    public void addProducentOnAction(ActionEvent actionEvent) {
        this.producentModel.saveProducentInDataBase();
        this.nameTextField.clear();
        this.surnameTextField.clear();
        this.nickTextField.clear();
    }
}
