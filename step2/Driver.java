import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Driver 
{
    public static void main( String[] args) throws Exception 
    {	
        little_grammarLexer lex = new little_grammarLexer(CharStreams.fromFileName(args[0]));
        CommonTokenStream tok = new CommonTokenStream(lex);
        little_grammarParser par = new little_grammarParser(tok);
        new ParseTreeWalker().walk(new little_grammarBaseListener(), par.program());
        String result = par.getNumberOfSyntaxErrors() > 0 ? "Not Accepted" : "Accepted";
        System.out.println(result);
    }
}