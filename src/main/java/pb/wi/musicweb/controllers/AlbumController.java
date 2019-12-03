package pb.wi.musicweb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import pb.wi.musicweb.modelFX.AlbumFX;
import pb.wi.musicweb.modelFX.AlbumModel;

public class AlbumController {

    @FXML
    private TextField albumTextField;
    @FXML
    private Button addAlbumButton;
    @FXML
    private ComboBox<AlbumFX> albumComboBox;

    private AlbumModel albumModel;

    @FXML
    public void initialize() {
        this.albumModel = new AlbumModel();
        this.albumModel.init();
        this.albumComboBox.setItems(this.albumModel.getAlbumList());
        initBindings();
    }

    private void initBindings() {
        addAlbumButton.disableProperty().bind(albumTextField.textProperty().isEmpty());
    }

    public void addAlbum() {
        albumModel.saveAlbumInDataBase(albumTextField.getText());
        albumTextField.clear();
    }

    public void onActionDeleteButton(ActionEvent actionEvent) {
        this.albumModel.deleteAlbumById();
    }

    public void onActionComboBox(ActionEvent actionEvent) {
        this.albumModel.setAlbum(this.albumComboBox.getSelectionModel().getSelectedItem());
    }
}
