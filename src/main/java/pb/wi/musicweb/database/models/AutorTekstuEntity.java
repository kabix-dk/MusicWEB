package pb.wi.musicweb.database.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "AUTOR_TEKSTU", schema = "SBD_INF_PS3_5", catalog = "")
public class AutorTekstuEntity {
    private short idAutorTekstu;
    private String imieAutorTekstu;
    private String nazwiskoAutorTekstu;
    private String pseudonimAutorTekstu;
    private Collection<UtworEntity> utworsByIdAutorTekstu;

    @Id
    @Column(name = "ID_AUTOR_TEKSTU")
    @GeneratedValue
    public short getIdAutorTekstu() {
        return idAutorTekstu;
    }

    public void setIdAutorTekstu(short idAutorTekstu) {
        this.idAutorTekstu = idAutorTekstu;
    }

    @Basic
    @Column(name = "IMIE_AUTOR_TEKSTU")
    public String getImieAutorTekstu() {
        return imieAutorTekstu;
    }

    public void setImieAutorTekstu(String imieAutorTekstu) {
        this.imieAutorTekstu = imieAutorTekstu;
    }

    @Basic
    @Column(name = "NAZWISKO_AUTOR_TEKSTU")
    public String getNazwiskoAutorTekstu() {
        return nazwiskoAutorTekstu;
    }

    public void setNazwiskoAutorTekstu(String nazwiskoAutorTekstu) {
        this.nazwiskoAutorTekstu = nazwiskoAutorTekstu;
    }

    @Basic
    @Column(name = "PSEUDONIM_AUTOR_TEKSTU")
    public String getPseudonimAutorTekstu() {
        return pseudonimAutorTekstu;
    }

    public void setPseudonimAutorTekstu(String pseudonimAutorTekstu) {
        this.pseudonimAutorTekstu = pseudonimAutorTekstu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorTekstuEntity that = (AutorTekstuEntity) o;
        return idAutorTekstu == that.idAutorTekstu &&
                Objects.equals(imieAutorTekstu, that.imieAutorTekstu) &&
                Objects.equals(nazwiskoAutorTekstu, that.nazwiskoAutorTekstu) &&
                Objects.equals(pseudonimAutorTekstu, that.pseudonimAutorTekstu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutorTekstu, imieAutorTekstu, nazwiskoAutorTekstu, pseudonimAutorTekstu);
    }

    @OneToMany(mappedBy = "autorTekstuByIdAutorTekstu")
    public Collection<UtworEntity> getUtworsByIdAutorTekstu() {
        return utworsByIdAutorTekstu;
    }

    public void setUtworsByIdAutorTekstu(Collection<UtworEntity> utworsByIdAutorTekstu) {
        this.utworsByIdAutorTekstu = utworsByIdAutorTekstu;
    }
}
