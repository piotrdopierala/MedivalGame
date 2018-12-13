package pl.dopierala.SpringCourse.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PlayerInformation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int gold = 0;

    private String username;
    private String password;
    private boolean enabled;

    public PlayerInformation(String userName, String password) {
        this.username = userName;
        this.password = password;
        this.enabled = true;
    }

    public PlayerInformation() {
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
