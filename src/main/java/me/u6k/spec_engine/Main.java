
package me.u6k.spec_engine;

import java.io.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.u6k.spec_engine.parser.*;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        StringReader reader = new StringReader("123.4");
        MyParser parser = new MyParser(reader);
        parser.doParse();
    }

}
