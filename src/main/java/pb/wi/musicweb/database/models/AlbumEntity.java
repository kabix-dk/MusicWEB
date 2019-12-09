package pb.wi.musicweb.database.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ALBUM", schema = "SBD_INF_PS3_5", catalog = "")
public class AlbumEntity {
    private short idAlbum;
    private String nazwaAlbum;
    private Collection<UtworEntity> utworsByIdAlbum;

    @Id
    @Column(name = "ID_ALBUM")
    @GeneratedValue
    public short getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(short idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Basic
    @Column(name = "NAZWA_ALBUM")
    public String getNazwaAlbum() {
        return nazwaAlbum;
    }

    public void setNazwaAlbum(String nazwaAlbum) {
        this.nazwaAlbum = nazwaAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumEntity that = (AlbumEntity) o;
        return idAlbum == that.idAlbum &&
                Objects.equals(nazwaAlbum, that.nazwaAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlbum, nazwaAlbum);
    }

    @OneToMany(mappedBy = "albumByIdAlbum")
    public Collection<UtworEntity> getUtworsByIdAlbum() {
        return utworsByIdAlbum;
    }

    public void setUtworsByIdAlbum(Collection<UtworEntity> utworsByIdAlbum) {
        this.utworsByIdAlbum = utworsByIdAlbum;
    }
}
