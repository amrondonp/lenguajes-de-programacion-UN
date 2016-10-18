package classes;

import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Interpreter {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("Codigo.txt"));
		String buffer = new String("");
		String currLine = new String("");
		while((currLine = br.readLine()) != null){
            buffer += currLine.toLowerCase();
            buffer += "\n";
		}
		
		ANTLRInputStream input = new ANTLRInputStream(buffer);
		//System.out.println(input.toString());
		MyLanguageLexer lexer = new MyLanguageLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MyLanguageParser parser = new MyLanguageParser(tokens);
		ParseTree tree = parser.programa();
		MyVisitor<Object> loader = new MyVisitor<Object>();
		loader.visit(tree);
		//System.out.println("todo bien, todo bonito");
		br.close();

	}

}
