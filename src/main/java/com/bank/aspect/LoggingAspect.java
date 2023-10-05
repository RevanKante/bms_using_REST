package com.bank.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
        " || within(@org.springframework.stereotype.Service *)" +
        " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pj) throws Throwable {
        String methodName = pj.getSignature().getName();
        String className = pj.getTarget().getClass().toString();
        Object[] arguments = pj.getArgs();

        logger.info("Method invoked "+className+" : "+methodName+"() arguments : "+ Arrays.toString(arguments));

        Object object = pj.proceed();
        logger.info(className+" : "+methodName+"() Response : "+ Arrays.toString(arguments));
        return object;
    }
}
