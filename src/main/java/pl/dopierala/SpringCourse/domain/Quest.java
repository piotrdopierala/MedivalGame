package pl.dopierala.SpringCourse.domain;

import java.time.LocalDateTime;

public class Quest {
    private int id;
    private String description;
    private int reward = 100; //ile zlota za wykonanie questa
    protected int lengthInSeconds = 15; //czas trwania questa w [sek]
    private boolean started = false;
    private boolean completed = false;
    protected LocalDateTime startDate;

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Quest{" + description + '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started)
            this.startDate = LocalDateTime.now();
        this.started = started;
    }

    public boolean isCompleted() {
        if (completed) {
            return true;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime finishDateTime = this.startDate.plusSeconds(lengthInSeconds);
            boolean isAfter = now.isAfter(finishDateTime);
            if (isAfter) {
                this.completed = true;
            }
            return completed;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
