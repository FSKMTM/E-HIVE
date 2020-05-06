package si.fs.kmtm.ehive.entitete;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity(name="meritev")
@NamedQuery(name="Meritev.getAll", query = "SELECT m FROM meritev m")
public class Meritev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float vrednost;

    @ManyToOne
    private Tip tip;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar cas_meritve;

    @ManyToOne
    @JoinColumn(name = "podnica_id")
    private Podnica podnica_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVrednost() {
        return vrednost;
    }

    public void setVrednost(float vrednost) {
        this.vrednost = vrednost;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public Calendar getCas_meritve() {
        return cas_meritve;
    }

    public void setCas_meritve(Calendar cas_meritve) {
        this.cas_meritve = cas_meritve;
    }

    public Podnica getPodnica_id() {
        return podnica_id;
    }

    public void setPodnica_id(Podnica podnica_id) {
        this.podnica_id = podnica_id;
    }

    @Override
    public String toString() {
        return "Meritev{" +
                "id=" + id +
                ", vrednost=" + vrednost +
                ", tip=" + tip +
                ", cas_meritve=" + cas_meritve +
                ", podnica_id=" + podnica_id +
                '}';
    }
}
