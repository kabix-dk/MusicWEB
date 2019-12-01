package pb.wi.musicweb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String MUSIC_BASE_FXML = "/fxml/MusicBase.fxml";
    public static final String SONG_LIST_FXML = "/fxml/SongList.fxml";
    public static final String ADD_SONG_FXML = "/fxml/AddSong.fxml";
    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openBase(ActionEvent actionEvent) {
        mainController.setCenter(MUSIC_BASE_FXML);
    }

    @FXML
    public void openMusicList(ActionEvent actionEvent) {
        mainController.setCenter(SONG_LIST_FXML);
    }

    @FXML
    public void addSong(ActionEvent actionEvent) {
        if(toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
        mainController.setCenter(ADD_SONG_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
