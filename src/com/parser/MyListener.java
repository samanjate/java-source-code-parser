package com.parser;

import java.util.Set;

public class MyListener extends Java8BaseListener {

	Java8Parser parser;
	Set<String> methodNames;
	
	public MyListener(Java8Parser parser, Set<String> methodNames) {
		this.parser = parser;
		this.methodNames = methodNames;
	}
	
	@Override 
	public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
		methodNames.add(ctx.getChild(0).getText());
	}
}
