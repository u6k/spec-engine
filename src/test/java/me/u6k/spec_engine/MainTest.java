
package me.u6k.spec_engine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    private static final Logger L = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void test1() {
        String text = "a = 100;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test2() {
        String text = "b = 100 * 2;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test3() {
        String text = "c = 100 - 20 * 3;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test4() {
        String text = "d = true;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test5() {
        String text = "e = true && false;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test6() {
        String text = "f = true -> true && false;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test7() {
        String text = "g = true || false <-> false;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test8() {
        String text = "h = a + b * c;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test9() {
        String text = "i = d && e || f;";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test10() {
        String text = "j = ();";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test11() {
        String text = "k = (100);";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test12() {
        String text = "l = (b);";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test13() {
        String text = "m = (x + y);";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test14() {
        String text = "n = (x && y);";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void test15() {
        String text = "o = (x + y, x && y);";
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

}
