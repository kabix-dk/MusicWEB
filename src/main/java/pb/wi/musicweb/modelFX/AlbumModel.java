package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.hibernate.Query;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.AlbumEntity;
import pb.wi.musicweb.database.models.UtworEntity;
import pb.wi.musicweb.utils.converters.ConverterAlbum;
import pb.wi.musicweb.utils.converters.ConverterUtwor;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AlbumModel {

    Session session;
    Random generator = new Random();

    private ObservableList<AlbumFX> albumList = FXCollections.observableArrayList();
    private ObservableList<UtworFX> utworList = FXCollections.observableArrayList();
    private ObjectProperty<AlbumFX> album = new SimpleObjectProperty<>();
    private ObjectProperty<UtworFX> utwor = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();

    public void init() {
        DataBaseSession.startTransaction();
        session = DataBaseSession.getSession();
        Query q = session.createQuery("FROM AlbumEntity");
        List<AlbumEntity> albums = q.list();
        initAlbumList(albums);
        initRoot(albums);
        q = session.createQuery("FROM UtworEntity");
        List<UtworEntity> utwory = q.list();
        initUtworList(utwory);
    }

    private void initUtworList(List<UtworEntity> utwory) {
        this.utworList.clear();
        utwory.forEach(c-> {
            UtworFX utworFX = ConverterUtwor.convertUtworFX(c);
            this.utworList.add(utworFX);
        });
    }

    private void initRoot(List<AlbumEntity> albums) {
        this.root.getChildren().clear();
        albums.forEach(c-> {
            TreeItem<String> albumItem = new TreeItem<>(c.getNazwaAlbum());
            root.getChildren().add(albumItem);
        });
    }

    private void initAlbumList(List<AlbumEntity> albums) {
        this.albumList.clear();
        albums.forEach(c->{
            AlbumFX albumFX = ConverterAlbum.convertAlbumFX(c);
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

    public void addUtworToAlbum() {
        short id_utwor = (short) getUtwor().getId();
        short id_album = (short) getAlbum().getId();
        UtworEntity utworEntity = (UtworEntity) session.get(UtworEntity.class, id_utwor);
        AlbumEntity albumEntity = (AlbumEntity) session.get(AlbumEntity.class, id_album);
        utworEntity.setAlbumByIdAlbum(albumEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public void updateAlbum() {
        String id = String.valueOf(album.getValue().getId());
        String name = getAlbum().getName();
        Query q = session.createQuery("update AlbumEntity set nazwaAlbum = :name where idAlbum = :id");
        q.setString("id", id);
        q.setString("name", name);
        q.executeUpdate();
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

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }

    public ObservableList<UtworFX> getUtworList() {
        return utworList;
    }

    public void setUtworList(ObservableList<UtworFX> utworList) {
        this.utworList = utworList;
    }

    public UtworFX getUtwor() {
        return utwor.get();
    }

    public ObjectProperty<UtworFX> utworProperty() {
        return utwor;
    }

    public void setUtwor(UtworFX utwor) {
        this.utwor.set(utwor);
    }
}
