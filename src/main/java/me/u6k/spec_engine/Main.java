
package me.u6k.spec_engine;

import java.util.List;

import me.u6k.spec_engine.parser.SampleBaseVisitor;
import me.u6k.spec_engine.parser.SampleLexer;
import me.u6k.spec_engine.parser.SampleParser;
import me.u6k.spec_engine.parser.SampleParser.ElementContext;
import me.u6k.spec_engine.parser.SampleParser.ExprAssignContext;
import me.u6k.spec_engine.parser.SampleParser.ExprContext;
import me.u6k.spec_engine.parser.SampleParser.FormulaAssignContext;
import me.u6k.spec_engine.parser.SampleParser.FormulaContext;
import me.u6k.spec_engine.parser.SampleParser.ProgContext;
import me.u6k.spec_engine.parser.SampleParser.StatContext;
import me.u6k.spec_engine.parser.SampleParser.TupleAssignContext;
import me.u6k.spec_engine.parser.SampleVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public Object parse(String text) {
        CharStream stream = CharStreams.fromString(text);
        SampleLexer lexer = new SampleLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SampleParser parser = new SampleParser(tokens);
        SampleVisitor visitor = new SampleVisitorImpl();
        Object result = visitor.visit(parser.prog());

        return result;
    }

    private class SampleVisitorImpl extends SampleBaseVisitor<Object> {

        @Override
        public Object visitProg(ProgContext ctx) {
            System.out.println("visitProg:");
            this.printTokens(ctx.children);

            return super.visitProg(ctx);
        }

        @Override
        public Object visitStat(StatContext ctx) {
            System.out.println("visitStat:");
            this.printTokens(ctx.children);

            return super.visitStat(ctx);
        }

        @Override
        public Object visitExprAssign(ExprAssignContext ctx) {
            System.out.println("visitExprAssign: ID=" + ctx.ID());
            this.printTokens(ctx.children);

            return super.visitExprAssign(ctx);
        }

        @Override
        public Object visitFormulaAssign(FormulaAssignContext ctx) {
            System.out.println("visitFormulaAssign: ID=" + ctx.ID());
            this.printTokens(ctx.children);

            return super.visitFormulaAssign(ctx);
        }

        @Override
        public Object visitTupleAssign(TupleAssignContext ctx) {
            System.out.println("visitTupleAssign: ID=" + ctx.ID());
            this.printTokens(ctx.children);

            return super.visitTupleAssign(ctx);
        }

        @Override
        public Object visitElement(ElementContext ctx) {
            System.out.println("visitElement:");
            this.printTokens(ctx.children);

            return super.visitElement(ctx);
        }

        @Override
        public Object visitExpr(ExprContext ctx) {
            System.out.println("visitExpr: ID=" + ctx.ID() + ", INT=" + ctx.INT() + ", ADD=" + ctx.ADD() + ", SUB=" + ctx.SUB() + ", MUL=" + ctx.MUL() + ", DIV=" + ctx.DIV());
            this.printTokens(ctx.children);

            return super.visitExpr(ctx);
        }

        @Override
        public Object visitFormula(FormulaContext ctx) {
            System.out.println("visitFormula:");
            this.printTokens(ctx.children);

            return super.visitFormula(ctx);
        }

        private void printTokens(List<ParseTree> ctx) {
            ctx.forEach(x -> System.out.println("  child=[" + x.getClass().getName() + ", " + x + "]"));
        }

    }

}
