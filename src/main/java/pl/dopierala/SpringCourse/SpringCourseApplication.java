package pl.dopierala.SpringCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages={"pl.dopierala.SpringCourse"})
@PropertySource("classpath:knightProperties.properties")
@EnableScheduling
public class SpringCourseApplication {

    //TODO:
    //ideas for furute improvements:
    // random gold for quest
    // random that knight failed to finish quest
    // knight level, after finishing quest add level
    // multuple playest on one server
    // store for item you can buy for gold (helps finish quests)
    // build castle for gold
    // improve knight and sent them to fight castles of other players

    public static void main(String[] args)
    {
        SpringApplication.run(SpringCourseApplication.class, args);
    }
}
