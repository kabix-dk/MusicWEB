package pb.wi.musicweb.controllers;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pb.wi.musicweb.modelFX.UtworFX;
import pb.wi.musicweb.modelFX.UtworModel;

public class SongListController {


    public TableView<UtworFX> songTableView;
    public TableColumn<UtworFX, String> nameColumn;
    public TableColumn<UtworFX, String> wykonawcaColumn;
    public TableColumn<UtworFX, String> producentColumn;
    public TableColumn<UtworFX, String> autorColumn;

    private UtworModel utworModel;

    public void initialize() {
        this.utworModel = new UtworModel();
    }


}
