package pl.dopierala.SpringCourse.domain.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dopierala.SpringCourse.domain.PlayerInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {
        PlayerInformation pi = new PlayerInformation();
        em.persist(pi);
    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
