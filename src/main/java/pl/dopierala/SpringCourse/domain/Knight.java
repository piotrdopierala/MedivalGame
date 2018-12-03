package pl.dopierala.SpringCourse.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class Knight {
    private int id;
    private String name;
    private int age;
    private Quest quest;
    private int level;

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level=1;
        //this.quest = quest;
    }

    public Knight() {

    }

    public void setQuest(Quest quest) {
        System.out.println("Quest"+quest.toString()+" injected to knight "+name);
        this.quest = quest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Knight named:" + name + " (age: " + age + ")." + " Has quest: " + quest;
        //return "named:"+name+" (age: "+age+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
