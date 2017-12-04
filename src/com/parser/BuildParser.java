package com.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker; 

public class BuildParser {
	
	public static void main(String[]  args) 
			throws FileNotFoundException, IOException {
		String filePath = "/Users/samanjatesood/Documents/workspace/JavaParser/ANTLR/MainActivity.java";
		File fileToBeParsed = new File(filePath);
		FileInputStream fis = new FileInputStream(fileToBeParsed);
		Lexer lexer = new Java8Lexer(CharStreams.fromStream(fis));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Java8Parser parser = new Java8Parser(tokens);
		ParserRuleContext tree = parser.compilationUnit(); 
		
		ParseTreeWalker walker = new ParseTreeWalker();
		Set<String> methodNames = new HashSet<String>();
		Java8Listener extractor = new MyListener(parser, methodNames);
		walker.walk(extractor, tree);

		Map<String, List<String>> methods = new HashMap<String, List<String>>();
		Java8Listener extrac = new DependencyListener(methodNames, methods);
		walker.walk(extrac, tree);
	}
}
