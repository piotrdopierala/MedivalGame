package pl.dopierala.SpringCourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dopierala.SpringCourse.domain.Knight;
import pl.dopierala.SpringCourse.domain.PlayerInformation;
import pl.dopierala.SpringCourse.domain.Quest;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;
import pl.dopierala.SpringCourse.domain.repository.PlayerInformationRepository;
import pl.dopierala.SpringCourse.services.KnightService;
import pl.dopierala.SpringCourse.services.QuestService;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuest = questService.getAllNotStartedQuests();
        model.addAttribute("knight",knight);
        model.addAttribute("notStartedQuests",notStartedQuest);
        return "assignQuest"; //to jest nazwa widoku
    }

    @RequestMapping(value="/assignQuest",method= RequestMethod.POST)
    public String assignQuest(Knight knightWithNewQuest){
        knightService.updateKnight(knightWithNewQuest);
        Quest quest = knightWithNewQuest.getQuest();
        questService.update(quest);
        return "redirect:/knights"; //to jest nazwa widoku
    }

    @RequestMapping(value="/checkQuests")
    public String checkQuest(Model model){

        knightService.getMyGold();
        return "redirect:/knights";
    }

}
