package si.fs.kmtm.ehive.entitete;

import javax.persistence.*;
import java.util.Date;

@Entity(name="meritev")
@NamedQuery(name="Meritev.getAll", query = "SELECT m FROM meritev m")
public class Meritev {
    @Id
    private int id;

    private float vrednost;

    @ManyToOne
    private Tip tip;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cas_meritve;

    @ManyToOne
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

    public Date getCas_meritve() {
        return cas_meritve;
    }

    public void setCas_meritve(Date cas_meritve) {
        this.cas_meritve = cas_meritve;
    }

    public Podnica getPodnica_id() {
        return podnica_id;
    }

    public void setPodnica_id(Podnica podnica_id) {
        this.podnica_id = podnica_id;
    }
}
