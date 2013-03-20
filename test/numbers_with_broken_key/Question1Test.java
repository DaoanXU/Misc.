package numbers_with_broken_key;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Question1Test {

    @Test
    public void test() {
        Question1 it = new Question1();
        for (int b = 0; b < 10; b++) {
            Question1NumGenerator g = new Question1NumGenerator(1, b);
            for (int i = 1; i < 10000; i++) {
                int aa = g.next();
                int bb = it.largestLable(i, b);
                Assert.assertEquals(aa, bb);
            }
        }
    }

}
