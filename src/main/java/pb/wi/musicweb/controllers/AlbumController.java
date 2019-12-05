package pb.wi.musicweb.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;
import pb.wi.musicweb.modelFX.AlbumFX;
import pb.wi.musicweb.modelFX.AlbumModel;
import pb.wi.musicweb.utils.DialogUtils;

public class AlbumController {

    @FXML
    private TextField albumTextField;
    @FXML
    private Button addAlbumButton;
    @FXML
    private Button deleteAlbumButton;
    @FXML
    private Button editAlbumButton;
    @FXML
    private ComboBox<AlbumFX> albumComboBox;
    @FXML
    private TreeView<String> albumTreeView;

    private AlbumModel albumModel;

    @FXML
    public void initialize() {
        this.albumModel = new AlbumModel();
        this.albumModel.init();
        this.albumComboBox.setItems(this.albumModel.getAlbumList());
        this.albumTreeView.setRoot(this.albumModel.getRoot());
        initBindings();
    }

    private void initBindings() {
        addAlbumButton.disableProperty().bind(albumTextField.textProperty().isEmpty());
        deleteAlbumButton.disableProperty().bind(albumModel.albumProperty().isNull());
        editAlbumButton.disableProperty().bind(albumModel.albumProperty().isNull());
    }

    public void addAlbum() {
        albumModel.saveAlbumInDataBase(albumTextField.getText());
        albumTextField.clear();
    }

    public void onActionDeleteButton() {
        this.albumModel.deleteAlbumById();
    }

    public void onActionComboBox() {
        this.albumModel.setAlbum(this.albumComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditAlbum() {
        String newAlbumName = DialogUtils.editDialog(albumModel.getAlbum().getName());
        if(newAlbumName!=null) {
            albumModel.getAlbum().setName(newAlbumName);
            albumModel.updateAlbum();
        }
    }
}
