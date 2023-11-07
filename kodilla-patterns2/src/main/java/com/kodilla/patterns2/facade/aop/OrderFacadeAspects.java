package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeAspects {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeAspects.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId)")
    public void logEvent(OrderDto order, Long userId) {
        LOGGER.info("Calling processOrder method with userID: " + userId);
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logAfterExecution(JoinPoint joinPoint) {
        LOGGER.info("Method executed " + joinPoint.getSignature().toShortString());
    }
}
