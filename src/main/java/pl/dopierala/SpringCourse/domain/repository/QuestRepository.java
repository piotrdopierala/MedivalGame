package pl.dopierala.SpringCourse.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.dopierala.SpringCourse.domain.Quest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager em;

    //Map<Integer,Quest> quests = new HashMap<>();
    static final Random rnd = new Random();

    @Transactional
    public void createQuest(String description){
        //int newId = Ids.getNewId(quests.keySet()); //now hibernate will create ID
        //quests.put(newId, new Quest(description));

        Quest quest = new Quest(description);
        em.persist(quest);

    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest(){
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Save the princess");
        descriptions.add("Start in torunament");
        descriptions.add("Kill the dragon");
        descriptions.add("Fight forest goblins");
        descriptions.add("Kill evil donkey and eat it");

        int rndDescrIdx = rnd.nextInt(descriptions.size());
        String RndDescription = descriptions.get(rndDescrIdx);
        createQuest(RndDescription);
    }

    @Transactional
    public void deleteQuest(Quest questToDelet){
        //quests.remove(questToDelet.getId());
        em.remove(questToDelet);
    }

    public List<Quest> getAll() {
        return em.createQuery("from Quest",Quest.class).getResultList();
    }

    @Transactional
    public void update(Quest quest){
        //quests.put(quest.getId(),quest);
        em.merge(quest);
    }

    public Quest getQuest(Integer id){
        //return quests.get(id);
        return em.find(Quest.class,id);
    }
}
