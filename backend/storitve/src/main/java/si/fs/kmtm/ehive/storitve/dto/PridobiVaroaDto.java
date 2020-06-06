package si.fs.kmtm.ehive.storitve.dto;

import java.io.File;
import java.util.Date;

public class PridobiVaroaDto {
    private File slika;

    private Date ustvarjeno;

    private String ime_datoteke;

    public File getSlika() {
        return slika;
    }

    public void setSlika(File slika) {
        this.slika = slika;
    }

    public Date getUstvarjeno() {
        return ustvarjeno;
    }

    public void setUstvarjeno(Date ustvarjeno) {
        this.ustvarjeno = ustvarjeno;
    }

    public String getIme_datoteke() {
        return ime_datoteke;
    }

    public void setIme_datoteke(String ime_datoteke) {
        this.ime_datoteke = ime_datoteke;
    }
}
