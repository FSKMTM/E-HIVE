package si.fs.kmtm.ehive.entitete;

import javax.persistence.*;

@Entity(name = "podnica")
@NamedQueries(value = {
        @NamedQuery(name = "Podnica.getAll", query = "SELECT p FROM podnica p")
})
public class Podnica {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
