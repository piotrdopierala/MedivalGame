package pl.dopierala.SpringCourse.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import pl.dopierala.SpringCourse.domain.repository.DBKnightRepository;
import pl.dopierala.SpringCourse.domain.repository.InMemoryRepository;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
//@PropertySource("classpath:knightProperties.properties")
public class MainConfig {

    @Bean(name="inMemoryKnightRepository")
    @Profile(value="dev")
    public KnightRepository createInMemoryRepo(){
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="inDBKnightRepository")
    @Profile(value="prod")
    public KnightRepository createInDBRepo(){
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }



}
