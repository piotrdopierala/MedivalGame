package pl.dopierala.SpringCourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dopierala.SpringCourse.domain.Knight;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;
import pl.dopierala.SpringCourse.services.KnightService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights",allKnights);
        return "knights";
    }

    @RequestMapping(value="/knights",method= RequestMethod.POST)
    public String saveKnights(Knight newKnight) {
        service.saveKnight(newKnight);
        return "redirect:/knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight",new Knight());
        return "knightform";
    }
}
