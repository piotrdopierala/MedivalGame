package pl.dopierala.SpringCourse.domain;

import org.junit.Assert;
import org.junit.Test;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted(){
        Knight knight = new Knight("Percival",25);
        Quest quest = new Quest(1,"Test quest");

        knight.setQuest(quest);

        Assert.assertTrue(quest.isStarted());
    }
}
