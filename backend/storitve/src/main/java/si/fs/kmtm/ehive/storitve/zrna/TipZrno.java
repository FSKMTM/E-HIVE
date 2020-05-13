package si.fs.kmtm.ehive.storitve.zrna;

import si.fs.kmtm.ehive.entitete.Meritev;
import si.fs.kmtm.ehive.entitete.Tip;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class TipZrno {
    @PersistenceContext(unitName = "ehive-jpa")
    private EntityManager em;

    public List<Tip> pridobiTipe() {
        Query q = em.createNamedQuery("Tip.getAll");
        return q.getResultList();
    }

    public Tip pridobiTip(String id) {
        Tip tip = em.find(Tip.class, id);
        return tip;
    }

    @Transactional
    public void ustvariTip(Tip tip) {
        em.persist(tip);
    }


    @Transactional
    public boolean izbrisiMeritev(String id) {
        Tip tip = em.find(Tip.class, id);

        if (tip != null) {
            em.remove(tip);
            return true;
        }
        return false;
    }
}
