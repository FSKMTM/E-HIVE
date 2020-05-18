package si.fs.kmtm.ehive.entitete;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity(name="meritev")
@NamedQueries({
    @NamedQuery(name="Meritev.getAll", query = "SELECT m FROM meritev m"),
    @NamedQuery(name="Meritev.getSpecificPodnica", query = "SELECT m FROM meritev m WHERE m.podnica = ?1")
})
@SqlResultSetMapping(
        name="LatestResults",
        entities={
                @EntityResult(
                        entityClass = Meritev.class,
                        fields={
                                @FieldResult(name="cas_meritve",column="cas_meritve"),
                                @FieldResult(name="vrednost", column="vrednost"),
                                @FieldResult(name="tip_koda", column = "tip_koda"),
                                @FieldResult(name="id", column = "id"),
                                @FieldResult(name="podnica", column = "podnica")
                        })}
                )
@NamedNativeQuery(
        name = "Meritev.getLatest",
        query = "SELECT m.cas_meritve, m.vrednost, m.tip_koda, m.id, m.podnica FROM (SELECT max(cas_meritve) AS cas, tip_koda FROM meritev m WHERE m.podnica = ?1 GROUP BY tip_koda) t JOIN meritev m ON t.cas=m.cas_meritve AND t.tip_koda = m.tip_koda",
        resultSetMapping = "LatestResults")
public class Meritev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float vrednost;

    @ManyToOne
    private Tip tip;

//    @Temporal(TemporalType.TIMESTAMP)
    private Date cas_meritve;

    @ManyToOne
    @JoinColumn(name = "podnica")
    private Podnica podnica;

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

    public Podnica getPodnica() {
        return podnica;
    }

    public void setPodnica(Podnica podnica) {
        this.podnica = podnica;
    }

    @Override
    public String toString() {
        return "Meritev{" +
                "id=" + id +
                ", vrednost=" + vrednost +
                ", tip=" + tip +
                ", cas_meritve=" + cas_meritve +
                ", podnica_id=" + podnica +
                '}';
    }
}
