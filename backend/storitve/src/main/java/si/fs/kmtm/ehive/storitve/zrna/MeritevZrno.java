package si.fs.kmtm.ehive.storitve.zrna;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fs.kmtm.ehive.entitete.Meritev;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class MeritevZrno {

    @PersistenceContext(unitName = "ehive-jpa")
    private EntityManager em;

    public List<Meritev> pridobiMeritve(QueryParameters query) {
        List<Meritev> meritve = JPAUtils.queryEntities(em, Meritev.class, query);
        return meritve;
    }

    public Long stMeritev(QueryParameters query) {
        Long count = JPAUtils.queryEntitiesCount(em, Meritev.class, query);
        return count;
    }

    public List<Meritev> pridobiMeritve() {
        Query q = em.createNamedQuery("Meritev.getAll");
        return q.getResultList();
    }

    public Meritev pridobiMeritev(int id) {
        Meritev meritev = em.find(Meritev.class, id);
        return meritev;
    }

    @Transactional
    public void ustvariMeritev(Meritev meritev) {
        em.persist(meritev);
    }

    @Transactional
    public void posodobiMeritev(Meritev meritev) {
        em.merge(meritev);
    }

    @Transactional
    public boolean izbrisiMeritev(int id) {
        Meritev meritev = em.find(Meritev.class, id);

        if (meritev != null) {
            em.remove(meritev);
            return true;
        }
        return false;
    }
}
