package pl.dopierala.SpringCourse.domain;

public class Quest {
    private int id;
    private String description;
    private int reward=100; //ile zlota za wykonanie questa
    private int length=30000; //czas trwania questa w [ms]
    private boolean started = false;
    private boolean finished = false;

    public Quest(int id,String description) {
        this.id=id;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
