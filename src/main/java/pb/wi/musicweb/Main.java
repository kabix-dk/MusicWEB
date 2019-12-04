package pb.wi.musicweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.utils.FxmlUtils;

public class Main extends Application{

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        DataBaseSession.initDataBase();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        stage.show();
    }
}
