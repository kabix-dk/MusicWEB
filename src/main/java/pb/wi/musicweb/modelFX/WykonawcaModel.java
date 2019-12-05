package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.utils.converters.ConverterWykonawca;

import java.util.List;

public class WykonawcaModel {

    Session session;

    private ObjectProperty<WykonawcaFX> wykonawcaFXObjectProperty = new SimpleObjectProperty<>(new WykonawcaFX());
    private ObservableList<WykonawcaFX> wykonawcaFXObservableList = FXCollections.observableArrayList();

    private ObjectProperty<WykonawcaFX> wykonawcaFXObjectPropertyEdit = new SimpleObjectProperty<>(new WykonawcaFX());

    public void init() {
        DataBaseSession.startTransaction();
        session = DataBaseSession.getSession();
        Query q = session.createQuery("FROM WykonawcaEntity");
        List<WykonawcaEntity> wykonawcy = q.list();
        this.wykonawcaFXObservableList.clear();
        wykonawcy.forEach(wykonawca -> {
            WykonawcaFX wykonawcaFX = ConverterWykonawca.convertToWykonawcaFX(wykonawca);
            this.wykonawcaFXObservableList.add(wykonawcaFX);
        });
    }

    public void saveWykonawcaEditInDataBase() {
        WykonawcaEntity wykonawcaEntity = ConverterWykonawca.converToWykonawcaEntity(this.getWykonawcaFXObjectPropertyEdit());

        DataBaseSession.updateObject(wykonawcaEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public void saveWykonawcaInDataBase() {
        WykonawcaEntity wykonawcaEntity = ConverterWykonawca.converToWykonawcaEntity(this.getWykonawcaFXObjectProperty());

        DataBaseSession.saveObject(wykonawcaEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public void deleteWykonawcaInDataBase() {
        WykonawcaEntity wykonawcaEntity = ConverterWykonawca.converToWykonawcaEntity(this.getWykonawcaFXObjectPropertyEdit());

        DataBaseSession.deleteObject(wykonawcaEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public WykonawcaFX getWykonawcaFXObjectProperty() {
        return wykonawcaFXObjectProperty.get();
    }

    public ObjectProperty<WykonawcaFX> wykonawcaFXObjectPropertyProperty() {
        return wykonawcaFXObjectProperty;
    }

    public void setWykonawcaFXObjectProperty(WykonawcaFX wykonawcaFXObjectProperty) {
        this.wykonawcaFXObjectProperty.set(wykonawcaFXObjectProperty);
    }

    public ObservableList<WykonawcaFX> getWykonawcaFXObservableList() {
        return wykonawcaFXObservableList;
    }

    public void setWykonawcaFXObservableList(ObservableList<WykonawcaFX> wykonawcaFXObservableList) {
        this.wykonawcaFXObservableList = wykonawcaFXObservableList;
    }

    public WykonawcaFX getWykonawcaFXObjectPropertyEdit() {
        return wykonawcaFXObjectPropertyEdit.get();
    }

    public ObjectProperty<WykonawcaFX> wykonawcaFXObjectPropertyEditProperty() {
        return wykonawcaFXObjectPropertyEdit;
    }

    public void setWykonawcaFXObjectPropertyEdit(WykonawcaFX wykonawcaFXObjectPropertyEdit) {
        this.wykonawcaFXObjectPropertyEdit.set(wykonawcaFXObjectPropertyEdit);
    }
}
