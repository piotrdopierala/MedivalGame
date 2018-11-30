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


    public static void main(String[] args)
    {
        SpringApplication.run(SpringCourseApplication.class, args);
    }
}
