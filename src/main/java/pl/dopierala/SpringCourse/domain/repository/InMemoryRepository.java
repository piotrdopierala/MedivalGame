package pl.dopierala.SpringCourse.domain.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pl.dopierala.SpringCourse.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Scope(value="singleton")
public class InMemoryRepository implements KnightRepository {

    Map<String, Knight> knights= new HashMap<>();

    public InMemoryRepository(){
    }

    @Override
    public void createKnight(String name, int age){
        Knight newKnight = new Knight(name,age);
        knights.put(name,newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights(){
        return  knights.values();
    }

    @Override
    public Knight getKnight(String name){
        return knights.get(name);
    }

    @Override
    public void deleteKnight(String name){
        knights.remove(name);
    }

    @Override
    @PostConstruct
    public void build(){
        createKnight("Lancelot",29);
        createKnight("Percival",25);
        System.out.println("InMemoryRepository has been built.");
    }


    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "knights=" + knights +
                '}';
    }
}
