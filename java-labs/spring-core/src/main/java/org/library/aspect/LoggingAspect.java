package org.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method execution: " + joinPoint.getSignature().getName() + " with arguments: " + java.util.Arrays.toString(joinPoint.getArgs()) + " on target: " + joinPoint.getTarget());
    }
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method execution: " + joinPoint.getSignature().getName() + " on target: " + joinPoint.getTarget());
    }
}
