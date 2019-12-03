package pb.wi.musicweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.AlbumEntity;
import pb.wi.musicweb.database.models.UtworEntity;
import pb.wi.musicweb.utils.FxmlUtils;

import java.util.Date;

public class Main extends Application{

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {

//        UtworEntity song = new UtworEntity();
//        song.setIdUtwor((short)3);
//        song.setIdAlbum((short)5);
//        song.setIdProducent((short)2);
//        song.setIdWykonawca((short)7);
//        song.setNazwaUtwor("Trójkąty");

//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session session = sf.openSession();

//        AlbumEntity album = new AlbumEntity();
//        album.setIdAlbum((short) 10);
//        album.setNazwaAlbum("Nie ma mnie");
//        album.setIdProducent((short) 2);
//        album.setIdWykonawca((short) 3);

//        session.beginTransaction();
//        session.save(album);
//        session.getTransaction().commit();
//        session.close();

//        System.out.println("SIEMA");
//        System.out.println(album.toString());

//        Session session = DataBaseSession.getSession();

//        session.save(song);
//        session.getTransaction().commit();
//        session.close();

//        Configuration con = new Configuration().configure().addAnnotatedClass(UtworEntity.class);
//        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
//        SessionFactory sf = con.buildSessionFactory(reg);
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(song);
//        tx.commit();

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
