package com.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker; 

public class BuildParser {
	
	public static void main(String[]  args) 
			throws FileNotFoundException, IOException {
		Lexer lexer = new Java8Lexer(CharStreams.fromStream(new FileInputStream(new File("/Users/samanjatesood/Documents/workspace/JavaParser/ANTLR/MainActivity.java"))));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Java8Parser parser = new Java8Parser(tokens);
		ParserRuleContext tree = parser.compilationUnit(); 
		
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		Set<String> methodNames = new HashSet<String>();
		Java8Listener extractor = new MyListener(parser, methodNames); // MyListener is your implementation of TheCListener interface
		walker.walk(extractor, tree);
		System.out.println(methodNames.toArray()[0]);
	}
}
