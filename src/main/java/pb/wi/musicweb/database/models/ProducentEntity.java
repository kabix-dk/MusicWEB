package pb.wi.musicweb.database.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PRODUCENT", schema = "SBD_INF_PS3_5", catalog = "")
public class ProducentEntity {
    private short idProducent;
    private String imieProducent;
    private String nazwiskoProducent;
    private String pseudonimProducent;
    private Collection<UtworEntity> utworsByIdProducent;

    @Id
    @Column(name = "ID_PRODUCENT")
    @GeneratedValue
    public short getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(short idProducent) {
        this.idProducent = idProducent;
    }

    @Basic
    @Column(name = "IMIE_PRODUCENT")
    public String getImieProducent() {
        return imieProducent;
    }

    public void setImieProducent(String imieProducent) {
        this.imieProducent = imieProducent;
    }

    @Basic
    @Column(name = "NAZWISKO_PRODUCENT")
    public String getNazwiskoProducent() {
        return nazwiskoProducent;
    }

    public void setNazwiskoProducent(String nazwiskoProducent) {
        this.nazwiskoProducent = nazwiskoProducent;
    }

    @Basic
    @Column(name = "PSEUDONIM_PRODUCENT")
    public String getPseudonimProducent() {
        return pseudonimProducent;
    }

    public void setPseudonimProducent(String pseudonimProducent) {
        this.pseudonimProducent = pseudonimProducent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducentEntity that = (ProducentEntity) o;
        return idProducent == that.idProducent &&
                Objects.equals(imieProducent, that.imieProducent) &&
                Objects.equals(nazwiskoProducent, that.nazwiskoProducent) &&
                Objects.equals(pseudonimProducent, that.pseudonimProducent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducent, imieProducent, nazwiskoProducent, pseudonimProducent);
    }

    @OneToMany(mappedBy = "producentByIdProducent")
    public Collection<UtworEntity> getUtworsByIdProducent() {
        return utworsByIdProducent;
    }

    public void setUtworsByIdProducent(Collection<UtworEntity> utworsByIdProducent) {
        this.utworsByIdProducent = utworsByIdProducent;
    }
}
