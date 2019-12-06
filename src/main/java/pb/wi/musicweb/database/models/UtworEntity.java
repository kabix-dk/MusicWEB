package pb.wi.musicweb.database.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UTWOR", schema = "SBD_INF_PS3_5", catalog = "")
public class UtworEntity {
    private short idUtwor;
    private String nazwaUtwor;
    private short idWykonawca;
    private short idProducent;
    private Short idAlbum;

    @Id
    @Column(name = "ID_UTWOR")
    @GeneratedValue
    public short getIdUtwor() {
        return idUtwor;
    }

    public void setIdUtwor(short idUtwor) {
        this.idUtwor = idUtwor;
    }

    @Basic
    @Column(name = "NAZWA_UTWOR")
    public String getNazwaUtwor() {
        return nazwaUtwor;
    }

    public void setNazwaUtwor(String nazwaUtwor) {
        this.nazwaUtwor = nazwaUtwor;
    }

    @Basic
    @Column(name = "ID_WYKONAWCA")
    public short getIdWykonawca() {
        return idWykonawca;
    }

    public void setIdWykonawca(short idWykonawca) {
        this.idWykonawca = idWykonawca;
    }

    @Basic
    @Column(name = "ID_PRODUCENT")
    public short getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(short idProducent) {
        this.idProducent = idProducent;
    }

    @Basic
    @Column(name = "ID_ALBUM")
    public Short getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Short idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtworEntity that = (UtworEntity) o;
        return idUtwor == that.idUtwor &&
                idWykonawca == that.idWykonawca &&
                idProducent == that.idProducent &&
                Objects.equals(nazwaUtwor, that.nazwaUtwor) &&
                Objects.equals(idAlbum, that.idAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtwor, nazwaUtwor, idWykonawca, idProducent, idAlbum);
    }
}
