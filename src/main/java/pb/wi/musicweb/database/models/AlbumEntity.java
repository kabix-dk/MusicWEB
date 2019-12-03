package pb.wi.musicweb.database.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "ALBUM", schema = "SBD_INF_PS3_5", catalog = "")
public class AlbumEntity {
    private short idAlbum;
    private String nazwaAlbum;
    private Time dataWydania;
    private short idWykonawca;
    private short idProducent;

    @Id
    @Column(name = "ID_ALBUM")
    public short getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(short idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Basic
    @Column(name = "NAZWA_ALBUM", unique = true)
    public String getNazwaAlbum() {
        return nazwaAlbum;
    }

    public void setNazwaAlbum(String nazwaAlbum) {
        this.nazwaAlbum = nazwaAlbum;
    }

    @Basic
    @Column(name = "DATA_WYDANIA")
    public Time getDataWydania() {
        return dataWydania;
    }

    public void setDataWydania(Time dataWydania) {
        this.dataWydania = dataWydania;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumEntity that = (AlbumEntity) o;
        return idAlbum == that.idAlbum &&
                idWykonawca == that.idWykonawca &&
                idProducent == that.idProducent &&
                Objects.equals(nazwaAlbum, that.nazwaAlbum) &&
                Objects.equals(dataWydania, that.dataWydania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlbum, nazwaAlbum, dataWydania, idWykonawca, idProducent);
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "idAlbum=" + idAlbum +
                ", nazwaAlbum='" + nazwaAlbum + '\'' +
                ", dataWydania=" + dataWydania +
                ", idWykonawca=" + idWykonawca +
                ", idProducent=" + idProducent +
                '}';
    }
}
