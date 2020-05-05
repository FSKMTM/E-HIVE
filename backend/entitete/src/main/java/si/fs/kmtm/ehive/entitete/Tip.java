package si.fs.kmtm.ehive.entitete;

import javax.persistence.*;

@Entity(name = "tip")
public class Tip {
    @Id
//    @Enumerated(EnumType.STRING)
    private String koda;

//    private enum TipKoda{
//        TEMP1, TEMP2, VLA1, VLA2, VAROA
//    }

    public String getKoda() {
        return koda;
    }

    public void setKoda(String koda) {
        this.koda = koda;
    }
}
