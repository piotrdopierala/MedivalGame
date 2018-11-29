package pl.dopierala.SpringCourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import pl.dopierala.SpringCourse.domain.Knight;
import pl.dopierala.SpringCourse.domain.Quest;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
//@PropertySource("classpath:knightProperties.properties")
public class MainConfig {

//    @Autowired
//    Quest quest;


//
//    public Quest createQuest() {
//        return new Quest();
//    }
//
//
//    @Bean(name="lancelot")
//    @Primary
//    public Knight lancelot() {
//        Knight lancelot = new Knight("Lancelot", 29);
//        lancelot.setQuest(quest);
//        return lancelot;
//    }
//
//    @Bean(name="percival")
//    public Knight percival() {
//        Knight percival = new Knight("Percival", 25);
//        percival.setQuest(quest);
//        return percival;
//    }

//
//    @Bean(name = "zamek", initMethod = "build", destroyMethod = "tearDown")
//    @Value("${my.castle.name:East Watch}")
//    public InMemoryRepository castle(String name){
//        InMemoryRepository castle = new InMemoryRepository(knight());
//        castle.setName(name);
//        return castle;
//    }
}
