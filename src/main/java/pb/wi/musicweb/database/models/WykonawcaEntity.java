package pb.wi.musicweb.database.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "WYKONAWCA", schema = "SBD_INF_PS3_5", catalog = "")
public class WykonawcaEntity {
    private short idWykonawca;
    private String imieWykonawca;
    private String nazwiskoWykonawca;
    private String pseudonimWykonawca;
    private Collection<UtworEntity> utworsByIdWykonawca;

    @Id
    @Column(name = "ID_WYKONAWCA")
    @GeneratedValue
    public short getIdWykonawca() {
        return idWykonawca;
    }

    public void setIdWykonawca(short idWykonawca) {
        this.idWykonawca = idWykonawca;
    }

    @Basic
    @Column(name = "IMIE_WYKONAWCA")
    public String getImieWykonawca() {
        return imieWykonawca;
    }

    public void setImieWykonawca(String imieWykonawca) {
        this.imieWykonawca = imieWykonawca;
    }

    @Basic
    @Column(name = "NAZWISKO_WYKONAWCA")
    public String getNazwiskoWykonawca() {
        return nazwiskoWykonawca;
    }

    public void setNazwiskoWykonawca(String nazwiskoWykonawca) {
        this.nazwiskoWykonawca = nazwiskoWykonawca;
    }

    @Basic
    @Column(name = "PSEUDONIM_WYKONAWCA")
    public String getPseudonimWykonawca() {
        return pseudonimWykonawca;
    }

    public void setPseudonimWykonawca(String pseudonimWykonawca) {
        this.pseudonimWykonawca = pseudonimWykonawca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WykonawcaEntity that = (WykonawcaEntity) o;
        return idWykonawca == that.idWykonawca &&
                Objects.equals(imieWykonawca, that.imieWykonawca) &&
                Objects.equals(nazwiskoWykonawca, that.nazwiskoWykonawca) &&
                Objects.equals(pseudonimWykonawca, that.pseudonimWykonawca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWykonawca, imieWykonawca, nazwiskoWykonawca, pseudonimWykonawca);
    }

    @OneToMany(mappedBy = "wykonawcaByIdWykonawca")
    public Collection<UtworEntity> getUtworsByIdWykonawca() {
        return utworsByIdWykonawca;
    }

    public void setUtworsByIdWykonawca(Collection<UtworEntity> utworsByIdWykonawca) {
        this.utworsByIdWykonawca = utworsByIdWykonawca;
    }

    @Override
    public String toString() {
        return "WykonawcaEntity{" +
                "idWykonawca=" + idWykonawca +
                ", imieWykonawca='" + imieWykonawca + '\'' +
                ", nazwiskoWykonawca='" + nazwiskoWykonawca + '\'' +
                ", pseudonimWykonawca='" + pseudonimWykonawca + '\'' +
                '}';
    }
}
