package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.ProducentEntity;
import pb.wi.musicweb.utils.converters.ConvertProducent;

public class ProducentModel {

    Session session;

    private ObjectProperty<ProducentFX> producentFXObjectProperty = new SimpleObjectProperty<>(new ProducentFX());

    public void saveProducentInDataBase() {
        DataBaseSession.startTransaction();

        ProducentEntity producentEntity = ConvertProducent.convertProducentFXToProducentEntity(this.getProducentFXObjectProperty());

        DataBaseSession.saveObject(producentEntity);
        DataBaseSession.endTransaction();
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
}
