package si.fs.kmtm.ehive.storitve.zrna;

import si.fs.kmtm.ehive.entitete.Podnica;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PodnicaZrno {

    @PersistenceContext(unitName = "ehive-jpa")
    private EntityManager em;

    public List<Podnica> pridobiPodnice() {
        Query q = em.createNamedQuery("Podnica.getAll");
        return q.getResultList();
    }

    public Podnica pridobiPodnico(int id) {
        Podnica podnica = em.find(Podnica.class, id);
        return podnica;
    }

    @Transactional
    public void ustvariPodnico(Podnica podnica) {
        em.persist(podnica);
    }

    @Transactional
    public void posodobiPodnico(Podnica podnica) {
        em.merge(podnica);
    }

    @Transactional
    public boolean izbrisiPodnico(int id) {
        Podnica podnica = em.find(Podnica.class, id);

        if (podnica != null) {
            em.remove(podnica);
            return true;
        }
        return false;
    }
}
