
package me.u6k.spec_engine;

import java.util.List;

import me.u6k.spec_engine.parser.PlantUmlBaseVisitor;
import me.u6k.spec_engine.parser.PlantUmlLexer;
import me.u6k.spec_engine.parser.PlantUmlParser;
import me.u6k.spec_engine.parser.PlantUmlParser.PlantumlContext;
import me.u6k.spec_engine.parser.PlantUmlParser.StatementContext;
import me.u6k.spec_engine.parser.PlantUmlVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private static final Logger L = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public Object parse(String text) {
        L.debug("#parse: text={}", text);

        CharStream stream = CharStreams.fromString(text);
        PlantUmlLexer lexer = new PlantUmlLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlantUmlParser parser = new PlantUmlParser(tokens);

        PlantUmlVisitor<Object> visitor = new PlantUmlVisitorImpl();
        Object result = visitor.visit(parser.plantuml());

        L.debug("result={}", result);
        return result;
    }

    private class PlantUmlVisitorImpl extends PlantUmlBaseVisitor<Object> {

        @Override
        public Object visitPlantuml(PlantumlContext ctx) {
            L.debug("visitPlantuml:");
            this.printTokens(ctx.children);

            return super.visitPlantuml(ctx);
        }

        @Override
        public Object visitStatement(StatementContext ctx) {
            L.debug("visitStatement:");
            this.printTokens(ctx.children);

            return super.visitStatement(ctx);
        }

        private void printTokens(List<ParseTree> ctx) {
            ctx.forEach(x -> L.debug("  child=[{}, {}]", x.getClass().getName(), x));
        }

    }

}
