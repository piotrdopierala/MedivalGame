package pl.dopierala.SpringCourse.utils;

import java.util.Comparator;
import java.util.Set;

public class Ids {
    public static int getNewId(Set<Integer> keysSoFar) {
        if (keysSoFar.isEmpty()) {
            return 0;
        }
        return (keysSoFar.stream().max(Comparator.naturalOrder()).get()) + 1;
    }
}
