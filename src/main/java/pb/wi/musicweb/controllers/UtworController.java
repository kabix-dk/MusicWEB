package pb.wi.musicweb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pb.wi.musicweb.modelFX.AuthorFX;
import pb.wi.musicweb.modelFX.ProducentFX;
import pb.wi.musicweb.modelFX.UtworModel;
import pb.wi.musicweb.modelFX.WykonawcaFX;

public class UtworController {

    @FXML
    private Button addButton;
    @FXML
    private ComboBox<WykonawcaFX> wykonawcaComboBox;
    @FXML
    private ComboBox<ProducentFX> producentComboBox;
    @FXML
    private ComboBox<AuthorFX> autorComboBox;
    @FXML
    private TextField nameTextField;

    private UtworModel utworModel;

    public void initialize() {
        this.utworModel = new UtworModel();

        this.utworModel.init();

        this.autorComboBox.setItems(this.utworModel.getAuthorFXObservableList());
        this.producentComboBox.setItems(this.utworModel.getProducentFXObservableList());
        this.wykonawcaComboBox.setItems(this.utworModel.getWykonawcaFXObservableList());

        this.utworModel.getUtworFXObjectProperty().wykonawcaFXProperty().bind(this.wykonawcaComboBox.valueProperty());
        this.utworModel.getUtworFXObjectProperty().producentFXProperty().bind(this.producentComboBox.valueProperty());
        this.utworModel.getUtworFXObjectProperty().authorFXProperty().bind(this.autorComboBox.valueProperty());
        this.utworModel.getUtworFXObjectProperty().nameProperty().bind(this.nameTextField.textProperty());
    }

    public void addButtonOnAction() {

    }
}
