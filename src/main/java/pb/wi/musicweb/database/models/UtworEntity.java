package pb.wi.musicweb.database.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UTWOR", schema = "SBD_INF_PS3_5", catalog = "")
public class UtworEntity {
    private short idUtwor;
    private String nazwaUtwor;
    private WykonawcaEntity wykonawcaByIdWykonawca;
    private ProducentEntity producentByIdProducent;
    private AutorTekstuEntity autorTekstuByIdAutorTekstu;
    private AlbumEntity albumByIdAlbum;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtworEntity that = (UtworEntity) o;
        return idUtwor == that.idUtwor &&
                Objects.equals(nazwaUtwor, that.nazwaUtwor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtwor, nazwaUtwor);
    }

    @ManyToOne
    @JoinColumn(name = "ID_WYKONAWCA", referencedColumnName = "ID_WYKONAWCA", nullable = false)
    public WykonawcaEntity getWykonawcaByIdWykonawca() {
        return wykonawcaByIdWykonawca;
    }

    public void setWykonawcaByIdWykonawca(WykonawcaEntity wykonawcaByIdWykonawca) {
        this.wykonawcaByIdWykonawca = wykonawcaByIdWykonawca;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCENT", referencedColumnName = "ID_PRODUCENT", nullable = false)
    public ProducentEntity getProducentByIdProducent() {
        return producentByIdProducent;
    }

    public void setProducentByIdProducent(ProducentEntity producentByIdProducent) {
        this.producentByIdProducent = producentByIdProducent;
    }

    @ManyToOne
    @JoinColumn(name = "ID_AUTOR_TEKSTU", referencedColumnName = "ID_AUTOR_TEKSTU", nullable = false)
    public AutorTekstuEntity getAutorTekstuByIdAutorTekstu() {
        return autorTekstuByIdAutorTekstu;
    }

    public void setAutorTekstuByIdAutorTekstu(AutorTekstuEntity autorTekstuByIdAutorTekstu) {
        this.autorTekstuByIdAutorTekstu = autorTekstuByIdAutorTekstu;
    }

    @ManyToOne
    @JoinColumn(name = "ID_ALBUM", referencedColumnName = "ID_ALBUM")
    public AlbumEntity getAlbumByIdAlbum() {
        return albumByIdAlbum;
    }

    public void setAlbumByIdAlbum(AlbumEntity albumByIdAlbum) {
        this.albumByIdAlbum = albumByIdAlbum;
    }
}
