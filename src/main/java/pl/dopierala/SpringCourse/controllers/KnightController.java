package pl.dopierala.SpringCourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dopierala.SpringCourse.components.TimeComponent;
import pl.dopierala.SpringCourse.domain.Knight;
import pl.dopierala.SpringCourse.domain.PlayerInformation;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;
import pl.dopierala.SpringCourse.domain.repository.PlayerInformationRepository;
import pl.dopierala.SpringCourse.services.KnightService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService service;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        PlayerInformation pi = playerInformationRepository.getFirst();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", pi);
        return "knights";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnights(@Valid Knight newKnight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error Knight validation");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getObjectName()+" "+error.getDefaultMessage());
                    }
            );
            return "knightform";
        }
        service.saveKnight(newKnight);
        return "redirect:/knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        PlayerInformation pi = playerInformationRepository.getFirst();
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", pi);
        return "knightform";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = service.getKnight(id);
        PlayerInformation pi = playerInformationRepository.getFirst();
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", pi);
        return "knight";
    }

    @RequestMapping("/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id, Model model) {
        service.deleteKnight(id);
        return "redirect:/knights";
    }
}
