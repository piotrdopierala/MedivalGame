package pl.dopierala.SpringCourse.domain.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pl.dopierala.SpringCourse.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


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
    public Knight getKnight(String name){
        System.out.println("Using DB...");
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteKnight(String name){
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
