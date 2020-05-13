package si.fs.kmtm.ehive.storitve.dto;

import si.fs.kmtm.ehive.entitete.Tip;

import java.util.Calendar;

public class UrejanjeMeritevDto {
    private Calendar cas_meritve;

    private float vrednost;

    private int podnica_id;

    private String tip_id;

    public Calendar getCas_meritve() {
        return cas_meritve;
    }

    public void setCas_meritve(Calendar cas_meritve) {
        this.cas_meritve = cas_meritve;
    }

    public float getVrednost() {
        return vrednost;
    }

    public void setVrednost(float vrednost) {
        this.vrednost = vrednost;
    }

    public int getPodnica_id() {
        return podnica_id;
    }

    public void setPodnica_id(int podnica_id) {
        this.podnica_id = podnica_id;
    }

    public String getTip_id() {
        return tip_id;
    }

    public void setTip_id(String tip_id) {
        this.tip_id = tip_id;
    }
}
