package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.AutorTekstuEntity;
import pb.wi.musicweb.database.models.ProducentEntity;
import pb.wi.musicweb.database.models.UtworEntity;
import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.utils.converters.ConvertProducent;
import pb.wi.musicweb.utils.converters.ConverterAuthor;
import pb.wi.musicweb.utils.converters.ConverterUtwor;
import pb.wi.musicweb.utils.converters.ConverterWykonawca;

import java.util.List;

public class UtworModel {

    Session session;

    private ObjectProperty<UtworFX> utworFXObjectProperty = new SimpleObjectProperty<>(new UtworFX());

    private ObservableList<WykonawcaFX> wykonawcaFXObservableList = FXCollections.observableArrayList();
    private ObservableList<ProducentFX> producentFXObservableList = FXCollections.observableArrayList();
    private ObservableList<AuthorFX> authorFXObservableList = FXCollections.observableArrayList();

    public void init() {
        DataBaseSession.startTransaction();
        session = DataBaseSession.getSession();
        initWykonawcaList();
        initProducentList();
        initAuthorList();
        DataBaseSession.endTransaction();
    }

    private void initAuthorList() {
        Query q = session.createQuery("FROM AutorTekstuEntity");
        List<AutorTekstuEntity> autorzy = q.list();
        this.authorFXObservableList.clear();
        autorzy.forEach(c-> {
            AuthorFX authorFX = ConverterAuthor.convertToAuthorFX(c);
            this.authorFXObservableList.add(authorFX);
        });
    }

    private void initProducentList() {
        Query q = session.createQuery("FROM ProducentEntity");
        List<ProducentEntity> producenci = q.list();
        this.producentFXObservableList.clear();
        producenci.forEach(c-> {
            ProducentFX producentFX = ConvertProducent.convertToProducentFX(c);
            this.producentFXObservableList.add(producentFX);
        });
    }

    private void initWykonawcaList() {
        Query q = session.createQuery("FROM WykonawcaEntity");
        List<WykonawcaEntity> wykonawcy = q.list();
        this.wykonawcaFXObservableList.clear();
        wykonawcy.forEach(c-> {
            WykonawcaFX wykonawcaFX = ConverterWykonawca.convertToWykonawcaFX(c);
            this.wykonawcaFXObservableList.add(wykonawcaFX);
        });
    }

    public void saveUtworInDataBase() {
        UtworEntity utworEntity = ConverterUtwor.convertToUtwor(this.getUtworFXObjectProperty());
        DataBaseSession.startTransaction();
        session = DataBaseSession.getSession();

        Short id_wykonawca = (short) this.getUtworFXObjectProperty().getWykonawcaFX().getId();
        WykonawcaEntity wykonawcaEntity = (WykonawcaEntity) session.get(WykonawcaEntity.class, id_wykonawca);

        Short id_producent = (short) this.getUtworFXObjectProperty().getProducentFX().getId();
        ProducentEntity producentEntity = (ProducentEntity) session.get(ProducentEntity.class, id_producent);

        Short id_autor_tekstu = (short) this.getUtworFXObjectProperty().getAuthorFX().getId();
        AutorTekstuEntity autorTekstuEntity = (AutorTekstuEntity) session.get(AutorTekstuEntity.class, id_autor_tekstu);

        utworEntity.setWykonawcaByIdWykonawca(wykonawcaEntity);
        utworEntity.setProducentByIdProducent(producentEntity);
        utworEntity.setAutorTekstuByIdAutorTekstu(autorTekstuEntity);
        System.out.println(utworEntity);
        DataBaseSession.saveObject(utworEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public UtworFX getUtworFXObjectProperty() {
        return utworFXObjectProperty.get();
    }

    public ObjectProperty<UtworFX> utworFXObjectPropertyProperty() {
        return utworFXObjectProperty;
    }

    public void setUtworFXObjectProperty(UtworFX utworFXObjectProperty) {
        this.utworFXObjectProperty.set(utworFXObjectProperty);
    }

    public ObservableList<AuthorFX> getAuthorFXObservableList() {
        return authorFXObservableList;
    }

    public void setAuthorFXObservableList(ObservableList<AuthorFX> authorFXObservableList) {
        this.authorFXObservableList = authorFXObservableList;
    }

    public ObservableList<WykonawcaFX> getWykonawcaFXObservableList() {
        return wykonawcaFXObservableList;
    }

    public void setWykonawcaFXObservableList(ObservableList<WykonawcaFX> wykonawcaFXObservableList) {
        this.wykonawcaFXObservableList = wykonawcaFXObservableList;
    }

    public ObservableList<ProducentFX> getProducentFXObservableList() {
        return producentFXObservableList;
    }

    public void setProducentFXObservableList(ObservableList<ProducentFX> producentFXObservableList) {
        this.producentFXObservableList = producentFXObservableList;
    }
}
