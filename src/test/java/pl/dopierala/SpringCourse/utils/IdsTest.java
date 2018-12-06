package pl.dopierala.SpringCourse.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IdsTest {
    @Test
    public void testEmptySet(){
        int result = Ids.getNewId(Collections.emptySet());
        Assert.assertEquals( 0,result);
    }

    @Test
    public void testGenerateNewId(){
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        sample.add(5);
        sample.add(6);

        int result = Ids.getNewId(sample);
        Assert.assertEquals( 7,result);
    }
}
