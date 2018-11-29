package pl.dopierala.SpringCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource("classpath:knightProperties.properties")
@EnableScheduling
public class SpringCourseApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringCourseApplication.class, args);
    }
}
