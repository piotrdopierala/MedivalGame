package pl.dopierala.SpringCourse.domain;

import org.junit.Assert;
import org.junit.Test;

public class QuestTest {

    @Test
    public void settingStartedFlagToTrueShouldSetStartDate() {
        //given
        Quest quest = new Quest(1,"Test quest");
        //when
        quest.setStarted(true);
        //then
        Assert.assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted(){
        Quest q = new Quest(1,"Test quest");
        q.setStarted(true);
        q.lengthInSeconds = -6000; //quest finished minute ago
        Assert.assertTrue(q.isCompleted());
        Assert.assertTrue(q.isCompleted());
    }

    @Test
    public void questShouldNotBeCompleted(){
        Quest q = new Quest(1,"Test quest");
        q.setStarted(true);
        q.lengthInSeconds = 600000; //quest finished minute ago
        Assert.assertFalse(q.isCompleted());
        Assert.assertFalse(q.isCompleted());
    }
}
