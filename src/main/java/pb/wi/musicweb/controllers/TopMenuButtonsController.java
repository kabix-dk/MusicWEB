package pb.wi.musicweb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopMenuButtonsController {

    private MainController mainController;

    @FXML
    public void openBase(ActionEvent actionEvent) {
        System.out.println("Base!\n");
    }

    @FXML
    public void openMusicList(ActionEvent actionEvent) {
        System.out.println("Music List!\n");
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
