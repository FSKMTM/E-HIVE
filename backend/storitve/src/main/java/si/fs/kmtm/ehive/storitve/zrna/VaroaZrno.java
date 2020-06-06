package si.fs.kmtm.ehive.storitve.zrna;

import com.kumuluz.ee.rest.beans.QueryFilter;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.enums.FilterOperation;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fs.kmtm.ehive.entitete.Meritev;
import si.fs.kmtm.ehive.entitete.Podnica;
import si.fs.kmtm.ehive.entitete.Varoa;
import si.fs.kmtm.ehive.storitve.dto.PridobiVaroaDto;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.List;

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

    public List<Varoa> pridobi(QueryParameters query){
        List<Varoa> najnovejse = JPAUtils.queryEntities(em, Varoa.class, query);
        return najnovejse;
    }

    public PridobiVaroaDto pridobiZadnjoSliko(QueryParameters query) {
//        Query q = em.createNamedQuery("Varoa.getLatest").setParameter(1,podnica);
//        q.setMaxResults(1);
//        List<Varoa> najnovejse = q.getResultList();
        List<Varoa> najnovejse = JPAUtils.queryEntities(em, Varoa.class, query);
        if (najnovejse.size() == 0) {
            return null;
        } else {
            Varoa varoa = najnovejse.get(0);
            if (varoa == null) {
                return null;
            }
            File slika =  varoa.pridobiSlikaFile();
            PridobiVaroaDto dto = new PridobiVaroaDto();
            dto.setIme_datoteke(varoa.getIme_datoteke());
            dto.setUstvarjeno(varoa.getCas_meritve());
            dto.setSlika(slika);
            return dto;

        }
    }

}
