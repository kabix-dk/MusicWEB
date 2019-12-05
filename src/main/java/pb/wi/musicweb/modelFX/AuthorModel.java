package pb.wi.musicweb.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.Session;
import pb.wi.musicweb.database.dbutils.DataBaseSession;
import pb.wi.musicweb.database.models.AutorTekstuEntity;
import pb.wi.musicweb.utils.converters.ConverterAuthor;

import java.util.List;

public class AuthorModel {

    Session session;

    private ObjectProperty<AuthorFX> authorFXObjectProperty = new SimpleObjectProperty<>(new AuthorFX());
    private ObservableList<AuthorFX> authorFXObservableList = FXCollections.observableArrayList();

    private ObjectProperty<AuthorFX> authorFXObjectPropertyEdit = new SimpleObjectProperty<>(new AuthorFX());

    public void init() {
        DataBaseSession.startTransaction();
        session = DataBaseSession.getSession();
        Query q = session.createQuery("FROM AutorTekstuEntity");
        List<AutorTekstuEntity> autorzy = q.list();
        this.authorFXObservableList.clear();
        autorzy.forEach(autor -> {
            AuthorFX authorFX = ConverterAuthor.convertToAuthorFX(autor);
            this.authorFXObservableList.add(authorFX);
        });
    }

    public void saveAuthorEditInDataBase() {
        AutorTekstuEntity autorTekstuEntity  = ConverterAuthor.convertToAutorTekstuEntity(this.getAuthorFXObjectPropertyEdit());

        DataBaseSession.updateObject(autorTekstuEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public void saveAuthorInDataBase() {
        AutorTekstuEntity autorTekstuEntity  = ConverterAuthor.convertToAutorTekstuEntity(this.getAuthorFXObjectProperty());

        DataBaseSession.saveObject(autorTekstuEntity);;
        DataBaseSession.endTransaction();
        init();
    }

    public void deleteAuthorInDataBase() {
        AutorTekstuEntity autorTekstuEntity  = ConverterAuthor.convertToAutorTekstuEntity(this.getAuthorFXObjectPropertyEdit());

        DataBaseSession.deleteObject(autorTekstuEntity);
        DataBaseSession.endTransaction();
        init();
    }

    public AuthorFX getAuthorFXObjectProperty() {
        return authorFXObjectProperty.get();
    }

    public ObjectProperty<AuthorFX> authorFXObjectPropertyProperty() {
        return authorFXObjectProperty;
    }

    public void setAuthorFXObjectProperty(AuthorFX authorFXObjectProperty) {
        this.authorFXObjectProperty.set(authorFXObjectProperty);
    }

    public ObservableList<AuthorFX> getAuthorFXObservableList() {
        return authorFXObservableList;
    }

    public void setAuthorFXObservableList(ObservableList<AuthorFX> authorFXObservableList) {
        this.authorFXObservableList = authorFXObservableList;
    }

    public AuthorFX getAuthorFXObjectPropertyEdit() {
        return authorFXObjectPropertyEdit.get();
    }

    public ObjectProperty<AuthorFX> authorFXObjectPropertyEditProperty() {
        return authorFXObjectPropertyEdit;
    }

    public void setAuthorFXObjectPropertyEdit(AuthorFX authorFXObjectPropertyEdit) {
        this.authorFXObjectPropertyEdit.set(authorFXObjectPropertyEdit);
    }
}
