package pl.dopierala.SpringCourse.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String helloController()
    {
        System.out.println("in hello!");
        return "helloworld.html";
    }
}
