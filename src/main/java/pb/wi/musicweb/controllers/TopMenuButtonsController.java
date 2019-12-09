package pb.wi.musicweb.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String MUSIC_BASE_FXML = "/fxml/MusicBase.fxml";
    public static final String SONG_LIST_FXML = "/fxml/SongList.fxml";
    public static final String ADD_SONG_FXML = "/fxml/AddSong.fxml";
    public static final String ADD_ALBUM_FXML = "/fxml/AddAlbum.fxml";
    public static final String ADD_WYKONAWCA_FXML = "/fxml/AddWykonawca.fxml";
    public static final String ADD_PRODUCENT_FXML = "/fxml/AddProducent.fxml";
    public static final String ADD_AUTHOR_FXML = "/fxml/AddAuthor.fxml";
    private MainController mainController;

//    @FXML
//    private ToggleGroup toggleButtons;

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
//        resetToggleButton();
        mainController.setCenter(ADD_SONG_FXML);
    }

    @FXML
    public void addAlbum() {
//        resetToggleButton();
        mainController.setCenter(ADD_ALBUM_FXML);
    }

    @FXML
    public void addWykonawca() {
//        resetToggleButton();
        mainController.setCenter(ADD_WYKONAWCA_FXML);
    }

    @FXML
    public void addProducent() {
//        resetToggleButton();
        mainController.setCenter(ADD_PRODUCENT_FXML);
    }

    @FXML
    public void addAuthor() {
//        resetToggleButton();
        mainController.setCenter(ADD_AUTHOR_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

//    private void resetToggleButton() {
//        if (toggleButtons.getSelectedToggle() != null) {
//            toggleButtons.getSelectedToggle().setSelected(false);
//        }
//    }
}
