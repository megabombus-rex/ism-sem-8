package jczech.pwr.ism.ism_lab02.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

@Aspect
@Component
public class StatisticAspect {
    private final Dictionary<String, Integer> methodCallCountDict;

    public StatisticAspect() {
        methodCallCountDict = new Hashtable<>();
    }

    public Dictionary<String, Integer> getMethodCallCountDict() {
        return methodCallCountDict;
    }

    @Pointcut("execution(public * jczech.pwr.ism.ism_lab02.services.*.*(..)) ")
    public void myPointcut(){}

    @Around("myPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("In Around Aspect");
        System.out.println("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));

        var countStr = methodCallCountDict.get(joinPoint.getSignature().toShortString());

        if (countStr == null)
        {
            methodCallCountDict.put(joinPoint.getSignature().toShortString(), 0);
        }
        else
        {
            countStr += 1;
            methodCallCountDict.put(joinPoint.getSignature().toShortString(), countStr);
        }

        Object value = joinPoint.proceed();
        return value;
    }
}