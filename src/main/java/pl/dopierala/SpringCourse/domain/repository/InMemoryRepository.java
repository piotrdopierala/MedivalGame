package pl.dopierala.SpringCourse.domain.repository;

import pl.dopierala.SpringCourse.domain.Knight;
import pl.dopierala.SpringCourse.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.*;


public class InMemoryRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryRepository() {
    }

    @Override
    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(Ids.getNewId(knights.keySet()));

        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public void createKnight(Knight newKnight) {
        newKnight.setId(Ids.getNewId(knights.keySet()));
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public Optional<Knight> getKnightByName(String name) {
        Optional<Knight> knightOptional = knights.values().stream().filter(p -> p.getName().equals(name)).findFirst();
        return knightOptional;
    }

    @Override
    public void deleteKnight(Integer id) {
        knights.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
        //System.out.println("InMemoryRepository has been built.");
    }


    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "knights=" + knights +
                '}';
    }

    @Override
    public void updateKnight(int id, Knight knight) {
        knights.put(id,knight);
        //Knight oldKnight = getKnightById(id);
        //oldKnight=knight;
    }
}
