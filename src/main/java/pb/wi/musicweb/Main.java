package pb.wi.musicweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import pb.wi.musicweb.database.models.Utwór;
import pb.wi.musicweb.utils.FxmlUtils;

public class Main extends Application{

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        Utwór utwór = new Utwór();
        utwór.setID_Utwór(7);
        utwór.setNazwa_Utwór("Trójkąt Warszawski");

        Configuration con = new Configuration().configure().addAnnotatedClass(Utwór.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        utwór = (Utwór) session.get(Utwór.class, 7);

//        session.save(utwór);
        tx.commit();

        System.out.println(utwór);

//        launch(args);
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
