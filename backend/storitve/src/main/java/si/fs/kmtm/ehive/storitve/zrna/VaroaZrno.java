package si.fs.kmtm.ehive.storitve.zrna;

import si.fs.kmtm.ehive.entitete.Podnica;
import si.fs.kmtm.ehive.entitete.Varoa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.util.Date;

@ApplicationScoped
public class VaroaZrno {
    @PersistenceContext(unitName = "ehive-jpa")
    private EntityManager em;

    @Transactional
    public String ustvariSliko(BufferedImage bufferedImage, Date ustvarjeno, Podnica podnica) {
        Varoa varoa = new Varoa();
        varoa.ustvariSliko(bufferedImage, ustvarjeno, podnica);
        em.persist(varoa);
        return varoa.getIme_datoteke();
    }

//    public File datotekaSlikeKarte(String imeSlike) {
//        QueryParameters parameters = new QueryParameters();
//        QueryFilter nameFilter = new QueryFilter("imeSlike", FilterOperation.EQ, imeSlike);
//        parameters.getFilters().add(nameFilter);
//        List<Slika> slike = JPAUtils.queryEntities(em, Slika.class, parameters);
//        if (slike == null || slike.size() == 0)
//            return null;
//        Slika slika = slike.get(0);
//        if (slika == null) {
//            return null;
//        }
//        return slika.getSlikaFile();
//    }
}
