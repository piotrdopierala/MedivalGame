package pl.dopierala.SpringCourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dopierala.SpringCourse.domain.Knight;
import pl.dopierala.SpringCourse.domain.repository.KnightRepository;

import java.util.ArrayList;
import java.util.List;


@Component
public class KnightService {

    @Autowired
    KnightRepository repository;


    public List<Knight> getAllKnights() {
        List<Knight> allKnights = new ArrayList<>(repository.getAllKnights());
        return allKnights;
    }

    public void saveKnight(Knight newKnight) {
        repository.createKnight(newKnight);
    }

    public Knight getKnight(Integer id) {
        return repository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        repository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        repository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        int sum = repository.getAllKnights().stream()
                .filter(k -> k.getQuest().isCompleted())
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        repository.getAllKnights().stream()
                .filter(k -> k.getQuest().isCompleted())
                .forEach(k -> k.setQuest(null));

        return sum;
    }
}
