
package me.u6k.spec_engine;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
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
    public void 正常_1エントリー() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ok-1entry.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 正常_3エントリー() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ok-3entry.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 正常_空エントリー() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ok-empty.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 解析失敗_endumlが存在しない() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ng-enduml-not-found.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 解析失敗_IDから開始状態に遷移() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ng-id-to-state-start.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 解析失敗_startumlが存在しない() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ng-startuml-not-found.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 解析失敗_開始状態から開始状態に遷移() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ng-state-start-to-start.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 解析失敗_遷移後状態が存在しない() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ok-3entry.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    @Test
    public void 解析失敗_遷移前状態が存在しない() throws Exception {
        String text = readTestFile("/data/me/u6k/spec_engine/MainTest/ng-from-state-not-found.pu");
        Object result = new Main().parse(text);

        L.debug("result={}", result);
    }

    private String readTestFile(String path) throws IOException {
        L.debug("path={}", path);

        String text = IOUtils.readLines(this.getClass().getResourceAsStream(path), "UTF-8")
                        .stream()
                        .map(x -> x + "\n")
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString();

        L.debug("testFile={}", text);
        return text;
    }

}
