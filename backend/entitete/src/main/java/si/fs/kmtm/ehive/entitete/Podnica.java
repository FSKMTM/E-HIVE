package si.fs.kmtm.ehive.entitete;

import javax.persistence.*;

@Entity(name = "podnica")
@NamedQueries(value = {
        @NamedQuery(name = "Podnica.getAll", query = "SELECT p FROM podnica p ORDER BY p.id")
})
public class Podnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String naziv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Podnica{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
