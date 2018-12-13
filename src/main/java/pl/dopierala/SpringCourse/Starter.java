package pl.dopierala.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.dopierala.SpringCourse.domain.PlayerInformation;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;
import pl.dopierala.SpringCourse.domain.repository.PlayerInformationRepository;
import pl.dopierala.SpringCourse.domain.repository.QuestRepository;
import pl.dopierala.SpringCourse.services.QuestService;
import pl.dopierala.SpringCourse.utils.Role;
import pl.dopierala.SpringCourse.utils.RoleRepository;

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

    @Autowired
    PlayerInformationRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival",33);

        PlayerInformation playerInformation1 = new PlayerInformation("user1", "{noop}user1");
        repository.createPlayerInformation(playerInformation1);
        PlayerInformation playerInformation2 = new PlayerInformation("user2", "{noop}user2");
        repository.createPlayerInformation(playerInformation2);

        Role user1RoleUSER = new Role("user1","USER");
        Role user2RoleUSER = new Role("user2","USER");
        Role user2RoleADMIN = new Role("user2","ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);

        questService.assignRandomQuest("Percival");
    }
}
