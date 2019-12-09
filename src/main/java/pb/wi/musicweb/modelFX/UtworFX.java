package pb.wi.musicweb.modelFX;

import javafx.beans.property.*;

public class UtworFX {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<WykonawcaFX> wykonawcaFX = new SimpleObjectProperty<>();
    private ObjectProperty<ProducentFX> producentFX = new SimpleObjectProperty<>();
    private ObjectProperty<AuthorFX> authorFX = new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public WykonawcaFX getWykonawcaFX() {
        return wykonawcaFX.get();
    }

    public ObjectProperty<WykonawcaFX> wykonawcaFXProperty() {
        return wykonawcaFX;
    }

    public void setWykonawcaFX(WykonawcaFX wykonawcaFX) {
        this.wykonawcaFX.set(wykonawcaFX);
    }

    public ProducentFX getProducentFX() {
        return producentFX.get();
    }

    public ObjectProperty<ProducentFX> producentFXProperty() {
        return producentFX;
    }

    public void setProducentFX(ProducentFX producentFX) {
        this.producentFX.set(producentFX);
    }

    public AuthorFX getAuthorFX() {
        return authorFX.get();
    }

    public ObjectProperty<AuthorFX> authorFXProperty() {
        return authorFX;
    }

    public void setAuthorFX(AuthorFX authorFX) {
        this.authorFX.set(authorFX);
    }

    @Override
    public String toString() {
        return getName();
    }
}
