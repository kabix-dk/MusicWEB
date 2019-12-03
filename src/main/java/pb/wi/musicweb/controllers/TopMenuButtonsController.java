package pb.wi.musicweb.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String MUSIC_BASE_FXML = "/fxml/MusicBase.fxml";
    public static final String SONG_LIST_FXML = "/fxml/SongList.fxml";
    public static final String ADD_SONG_FXML = "/fxml/AddSong.fxml";
    public static final String ADD_ALBUM_FXML = "/fxml/AddAlbum.fxml";
    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openBase() {
        mainController.setCenter(MUSIC_BASE_FXML);
    }

    @FXML
    public void openMusicList() {
        mainController.setCenter(SONG_LIST_FXML);
    }

    @FXML
    public void addSong() {
        resetToggleButton();
        mainController.setCenter(ADD_SONG_FXML);
    }

    @FXML
    public void addAlbum() {
        resetToggleButton();
        mainController.setCenter(ADD_ALBUM_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void resetToggleButton() {
        if (toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }
}
