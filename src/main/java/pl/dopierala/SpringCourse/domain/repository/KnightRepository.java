package pl.dopierala.SpringCourse.domain.repository;

import pl.dopierala.SpringCourse.domain.Knight;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {
    void createKnight(String name, int age);

    void createKnight(Knight newKnight);

    Collection<Knight> getAllKnights();

    Knight getKnightById(Integer id);

    Optional<Knight> getKnightByName(String name);

    void deleteKnight(Integer id);

    void build();
}
