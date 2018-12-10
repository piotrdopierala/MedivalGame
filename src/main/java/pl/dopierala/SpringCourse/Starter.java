package pl.dopierala.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;
import pl.dopierala.SpringCourse.domain.repository.QuestRepository;
import pl.dopierala.SpringCourse.services.QuestService;

import javax.transaction.Transactional;


@Component
public class Starter implements CommandLineRunner {

    @Autowired
    //@Qualifier(value = "inDBKnightRepository")
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival",33);

        questService.assignRandomQuest("Percival");
    }
}
