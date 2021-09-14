package com.shayaan.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.shayaan.springaop.dao.*.*())")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.shayaan.springaop..dao.*.get*())")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.shayaan.springaop..dao.*.set*())")
	public void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
