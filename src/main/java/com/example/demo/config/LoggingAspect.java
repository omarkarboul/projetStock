package com.example.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

	@Before("execution(* tn.esprit.esponline.service.*.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	logger.info("In method " + name + " : ");
	}
	
	@Around("execution(* tn.esprit.spring.service.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	//test git
	return obj;
	}

}
