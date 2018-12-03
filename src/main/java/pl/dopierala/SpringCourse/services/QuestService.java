package pl.dopierala.SpringCourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dopierala.SpringCourse.domain.Quest;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;
import pl.dopierala.SpringCourse.domain.repository.QuestRepository;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    //@Qualifier(value = "inMemoryKnightRepository")
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rnd = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rnd.nextInt(allQuests.size()));
        knightRepository.getKnightByName(knightName).ifPresent(kn->kn.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }
}
