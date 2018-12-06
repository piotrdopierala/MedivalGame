package pl.dopierala.SpringCourse.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.dopierala.SpringCourse.domain.Quest;
import pl.dopierala.SpringCourse.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {
    Map<Integer,Quest> quests = new HashMap<>();
    static final Random rnd = new Random();

    public void createQuest(String description){
        int newId = Ids.getNewId(quests.keySet());
        quests.put(newId, new Quest(newId,description));
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
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

    public void deleteQuest(Quest questToDelet){
        quests.remove(questToDelet.getId());
    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }

    @PostConstruct
    public void init(){

    }

    public void update(Quest quest){
        quests.put(quest.getId(),quest);
    }

    public Quest getQuest(Integer id){
        return quests.get(id);
    }


    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }
}
