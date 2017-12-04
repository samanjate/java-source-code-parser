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
	public void enterMethodName(Java8Parser.MethodNameContext ctx) {
		methodNames.add(ctx.getText());
	}
}
