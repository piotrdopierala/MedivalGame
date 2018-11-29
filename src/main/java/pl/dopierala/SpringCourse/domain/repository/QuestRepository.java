package pl.dopierala.SpringCourse.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.dopierala.SpringCourse.domain.Quest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {
    List<Quest> questList = new ArrayList<>();
    static final Random rnd = new Random();

    public void createQuest(String description){
        questList.add(new Quest(description));
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

        System.out.println("New quest appeared: "+RndDescription);

    }

    public void deleteQuest(Quest questToDelet){
        questList.remove(questToDelet);
    }

    public List<Quest> getAll() {
        return questList;
    }

    @PostConstruct
    public void init(){

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }
}
