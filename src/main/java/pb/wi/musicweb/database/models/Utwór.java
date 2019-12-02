package pb.wi.musicweb.database.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utwór {

    @Id
    private int ID_Utwór;
    private String Nazwa_Utwór;

    public int getID_Utwór() {
        return ID_Utwór;
    }

    public void setID_Utwór(int ID_Utwór) {
        this.ID_Utwór = ID_Utwór;
    }

    public String getNazwa_Utwór() {
        return Nazwa_Utwór;
    }

    public void setNazwa_Utwór(String nazwa_Utwór) {
        Nazwa_Utwór = nazwa_Utwór;
    }

    @Override
    public String toString() {
        return "Utwór{" +
                "ID_Utwór=" + ID_Utwór +
                ", Nazwa_Utwór='" + Nazwa_Utwór + '\'' +
                '}';
    }
}
