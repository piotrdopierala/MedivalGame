package pl.dopierala.SpringCourse.domain.repository;

import pl.dopierala.SpringCourse.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;

public interface KnightRepository {
    void createKnight(String name, int age);

    void createKnight(Knight newKnight);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void deleteKnight(String name);

    void build();
}
