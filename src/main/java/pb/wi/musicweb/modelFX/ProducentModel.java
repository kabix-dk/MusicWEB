package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.ProducentEntity;
import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.utils.converters.ConvertProducent;
import pb.wi.musicweb.utils.converters.ConverterWykonawca;

import java.util.List;

public class ProducentModel {

    Session session;

    private ObjectProperty<ProducentFX> producentFXObjectProperty = new SimpleObjectProperty<>(new ProducentFX());
    private ObservableList<ProducentFX> producentFXObservableList = FXCollections.observableArrayList();

    private ObjectProperty<ProducentFX> producentFXObjectPropertyEdit = new SimpleObjectProperty<>(new ProducentFX());

    public void init() {
        DataBaseSession.startTransaction();
        session = DataBaseSession.getSession();
        Query q = session.createQuery("FROM ProducentEntity");
        List<ProducentEntity> producenci = q.list();
        this.producentFXObservableList.clear();
        producenci.forEach(producent -> {
            ProducentFX producentFX = ConvertProducent.convertToProducentFX(producent);
            this.producentFXObservableList.add(producentFX);
        });
    }

    public void saveProducentEditInDataBase() {
        ProducentEntity producentEntity = ConvertProducent.convertToProducentEntity(this.getProducentFXObjectPropertyEdit());

        DataBaseSession.updateObject(producentEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public void saveProducentInDataBase() {
        ProducentEntity producentEntity = ConvertProducent.convertToProducentEntity(this.getProducentFXObjectProperty());

        DataBaseSession.saveObject(producentEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public void deleteWykonawcaInDataBase() {
        ProducentEntity producentEntity = ConvertProducent.convertToProducentEntity(this.getProducentFXObjectPropertyEdit());

        DataBaseSession.deleteObject(producentEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public ProducentFX getProducentFXObjectProperty() {
        return producentFXObjectProperty.get();
    }

    public ObjectProperty<ProducentFX> producentFXObjectPropertyProperty() {
        return producentFXObjectProperty;
    }

    public void setProducentFXObjectProperty(ProducentFX producentFXObjectProperty) {
        this.producentFXObjectProperty.set(producentFXObjectProperty);
    }

    public ObservableList<ProducentFX> getProducentFXObservableList() {
        return producentFXObservableList;
    }

    public void setProducentFXObservableList(ObservableList<ProducentFX> producentFXObservableList) {
        this.producentFXObservableList = producentFXObservableList;
    }

    public ProducentFX getProducentFXObjectPropertyEdit() {
        return producentFXObjectPropertyEdit.get();
    }

    public ObjectProperty<ProducentFX> producentFXObjectPropertyEditProperty() {
        return producentFXObjectPropertyEdit;
    }

    public void setProducentFXObjectPropertyEdit(ProducentFX producentFXObjectPropertyEdit) {
        this.producentFXObjectPropertyEdit.set(producentFXObjectPropertyEdit);
    }
}
