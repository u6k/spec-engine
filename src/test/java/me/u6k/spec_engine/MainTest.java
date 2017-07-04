
package me.u6k.spec_engine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    @Test
    public void test1() {
        String text = "a = 100;";
        new Main().parse(text);
    }

    @Test
    public void test2() {
        String text = "b = 100 * 2;";
        new Main().parse(text);
    }

    @Test
    public void test3() {
        String text = "c = 100 - 20 * 3;";
        new Main().parse(text);
    }

    @Test
    public void test4() {
        String text = "d = true;";
        new Main().parse(text);
    }

    @Test
    public void test5() {
        String text = "e = true && false;";
        new Main().parse(text);
    }

    @Test
    public void test6() {
        String text = "f = true -> true && false;";
        new Main().parse(text);
    }

}
