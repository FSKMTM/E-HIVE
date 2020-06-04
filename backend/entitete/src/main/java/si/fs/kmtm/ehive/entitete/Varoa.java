package si.fs.kmtm.ehive.entitete;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Entity(name="varoa")
public class Varoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date cas_meritve;

    @ManyToOne
    @JoinColumn(name = "podnica")
    private Podnica podnica;

    private String ime_datoteke;

    public void ustvariSliko(BufferedImage slika, Date ustvarjeno, Podnica podnica) {
        String nakljucnoIme;
        Random gen = new Random();
        StringBuilder gradnjaImena = new StringBuilder();
        String abeceda = "abcdefghijklmnoprstuvzABCDEFGHIJKLMNOPRSTUVZ1234567890";
        for (int i = 0; i < 50; i++) {
            gradnjaImena.append(abeceda.charAt(gen.nextInt(abeceda.length())));
        }
        nakljucnoIme =  gradnjaImena.toString() + ".jpg";
        String dir = "slike/" + podnica.getId();
        if (!new File(dir).exists()) {
            new File(dir).mkdir();
        }
        try {
            File outputfile = new File(dir + "/" + nakljucnoIme);
            ImageIO.write(slika, "jpg", outputfile);
            ime_datoteke = nakljucnoIme;
            cas_meritve = ustvarjeno;
            this.podnica = podnica;
        } catch (IOException e) {
        }
    }

    public File pridobiSlikaFile() {
        return new File("slike/" + id + "/" + ime_datoteke);
    }

    public BufferedImage pridobiSliko() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("slike/" + id + "/" + ime_datoteke));
        } catch (IOException e) {
        }
        return img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIme_datoteke() {
        return ime_datoteke;
    }
}
