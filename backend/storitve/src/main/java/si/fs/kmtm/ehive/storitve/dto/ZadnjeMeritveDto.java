package si.fs.kmtm.ehive.storitve.dto;

import java.util.Calendar;

public class ZadnjeMeritveDto {

    public ZadnjeMeritveDto(Calendar cas, float vred, String koda) {
        this.cas_meritve = cas;
        this.vrednost = vred;
        this.koda = koda;
    }

    private Calendar cas_meritve;

    private float vrednost;

    private String koda;

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

    public String getKoda() {
        return koda;
    }

    public void setKoda(String koda) {
        this.koda = koda;
    }
}
