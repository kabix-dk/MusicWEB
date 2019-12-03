package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.AlbumEntity;

import java.util.List;
import java.util.Random;

public class AlbumModel {

    Session session;
    Random generator = new Random();

    private ObservableList<AlbumFX> albumList = FXCollections.observableArrayList();
    private ObjectProperty<AlbumFX> album = new SimpleObjectProperty<>();

    public void init() {
        DataBaseSession.startTransaction();
        session = DataBaseSession.getSession();
        Query q = session.createQuery("FROM AlbumEntity");
        List<AlbumEntity> albums = q.list();
        this.albumList.clear();
        albums.forEach(c->{
            AlbumFX albumFX = new AlbumFX();
            albumFX.setId(c.getIdAlbum());
            albumFX.setName(c.getNazwaAlbum());
            this.albumList.add(albumFX);
        });
    }

    public void deleteAlbumById() {
        String id = String.valueOf(album.getValue().getId());
        Query q = session.createQuery("delete from AlbumEntity where idAlbum = :id");
        q.setString("id", id);
        q.executeUpdate();
        DataBaseSession.endTransaction();
        init();
    }

    public void saveAlbumInDataBase(String name) {
        AlbumEntity album = new AlbumEntity();
        album.setIdAlbum((short) Math.abs(generator.nextInt(Short.MAX_VALUE)));
        album.setNazwaAlbum(name);
        DataBaseSession.saveObject(album);
        DataBaseSession.endTransaction();
        init();
    }

    public ObservableList<AlbumFX> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(ObservableList<AlbumFX> albumList) {
        this.albumList = albumList;
    }

    public AlbumFX getAlbum() {
        return album.get();
    }

    public ObjectProperty<AlbumFX> albumProperty() {
        return album;
    }

    public void setAlbum(AlbumFX album) {
        this.album.set(album);
    }
}
