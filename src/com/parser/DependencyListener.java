package com.parser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependencyListener extends Java8BaseListener {
	
	private Set<String> methodNames;
	private Map<String, List<String>> methods;
	
	public DependencyListener(Set<String> methodNames
								,Map<String, List<String>> methods) {
		this.methodNames = methodNames;
		this.methods = methods;
	}
	
	@Override 
	public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx) { 
		System.out.println(ctx.normalClassDeclaration().getChild(2).getText());
	}
	
	@Override 
	public void enterMethodName(Java8Parser.MethodNameContext ctx) { 
		String methodName = ctx.getText();
		if(methodNames.contains(methodName)) {
			System.out.print('\t');
			System.out.print('\t');
			System.out.println(ctx.getText());
		}
	}
}
