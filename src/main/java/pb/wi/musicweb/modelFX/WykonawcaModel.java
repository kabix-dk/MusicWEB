package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.utils.converters.ConverterWykonawca;

import java.util.Random;

public class WykonawcaModel {

    Session session;


    private ObjectProperty<WykonawcaFX> wykonawcaFXObjectProperty = new SimpleObjectProperty<>(new WykonawcaFX());

    public void saveWykonawcaInDataBase() {
        DataBaseSession.startTransaction();

        WykonawcaEntity wykonawcaEntity = ConverterWykonawca.convertWykonawcaFXToWykonawcaEntity(this.getWykonawcaFXObjectProperty());

        DataBaseSession.saveObject(wykonawcaEntity);
        DataBaseSession.endTransaction();
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
}
