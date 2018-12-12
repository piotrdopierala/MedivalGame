package pl.dopierala.SpringCourse.domain.repository;

import pl.dopierala.SpringCourse.domain.Knight;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class DBKnightRepository implements KnightRepository {


    @PersistenceContext
    EntityManager em;

    Map<String, Knight> knights = new HashMap<>();

    public DBKnightRepository() {
    }

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        em.persist(knight); //dodanie do bazy danych
    }

    @Override
    @Transactional
    public void createKnight(Knight newKnight) {
        em.persist(newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return em.createQuery("from Knight", Knight.class).getResultList();

    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class, id);
    }

    @Override
    public Optional<Knight> getKnightByName(String name) {
        Knight knightByName = em.createQuery("from Knight k where k.name=:name", Knight.class).setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        em.remove(id);
    }

    @Override
    @Transactional
    public void updateKnight(int id,Knight knight){
        em.merge(knight);
    }

    @Override
    public String toString() {
        return "InDBRepository{" +
                "knights=" + knights +
                '}';
    }

    @Override
    public void build() {

    }
}
