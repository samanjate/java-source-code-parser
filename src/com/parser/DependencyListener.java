package com.parser;

import java.util.Set;

public class DependencyListener extends Java8BaseListener {
	
	private Set<String> methodNames;
	
	public DependencyListener(Set<String> methodNames) {
		this.methodNames = methodNames;
	}
	
	@Override 
	public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx) { 
		System.out.println(ctx.normalClassDeclaration().depth());
	}
	
	@Override 
	public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) { 
		if(ctx.methodName() != null) {
			String methodName = ctx.methodName().getText();
			if(methodNames.contains(methodName)){
				System.out.print('\t');
				System.out.print('\t');
				System.out.println(ctx.getText());
			}
		}
	}
	
	@Override 
	public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) { 
		System.out.print('\t');
		System.out.println(ctx.getText());
	}
}
