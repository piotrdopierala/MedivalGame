package pl.dopierala.SpringCourse.domain.repository;

import pl.dopierala.SpringCourse.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class DBKnightRepository implements KnightRepository {

    Map<String, Knight> knights= new HashMap<>();

    public DBKnightRepository(){
    }

    @Override
    public void createKnight(String name, int age){
        System.out.println("Using DB...");
    }

    @Override
    public void createKnight(Knight newKnight) {
        System.out.println("Using DB ...");
    }

    @Override
    public Collection<Knight> getAllKnights(){
        System.out.println("Using DB...");
        throw new UnsupportedOperationException();
    }

    @Override
    public Knight getKnightById(Integer id){
        System.out.println("Using DB...");
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Knight> getKnightByName(String name) {
        System.out.println("Using DB...");
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteKnight(Integer id){
        System.out.println("Using DB...");
        throw new UnsupportedOperationException();
    }

    @Override
    @PostConstruct
    public void build(){
    }


    @Override
    public String toString() {
        return "InDBRepository{" +
                "knights=" + knights +
                '}';
    }
}
