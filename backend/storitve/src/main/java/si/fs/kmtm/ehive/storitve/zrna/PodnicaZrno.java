package si.fs.kmtm.ehive.storitve.zrna;

import si.fs.kmtm.ehive.entitete.Podnica;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class PodnicaZrno {

    @PersistenceContext(unitName = "ehive-jpa")
    private EntityManager em;

    public List<Podnica> pridobiVse() {
        Query q = em.createNamedQuery("Podnica.getAll");
        return q.getResultList();
    }
}
