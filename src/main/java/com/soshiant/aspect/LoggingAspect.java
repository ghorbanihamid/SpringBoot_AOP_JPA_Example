package com.soshiant.aspect;


import com.soshiant.SpringBootAppExample;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SpringBootAppExample.class);


    @Before(value = "execution(* com.soshiant.controller.WelcomeController.welcome(..))")
    public void logBeforeWelcome(JoinPoint joinPoint) {

        logger.info("=== LoggingAspect,WelcomeService, @Before: Before Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @After(value = "execution(* com.soshiant.controller.WelcomeController.welcome(..))")
    public void logAfterWelcome(JoinPoint joinPoint) {

        logger.info("=== LoggingAspect,WelcomeService, @After: After Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @Around("execution(* com.soshiant.controller.WelcomeController.*.*(..))")
    public Object logAroundWelcome(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info(" LoggingAspect,WelcomeService, @Around: Before Running Method "+ joinPoint.getSignature().getName() + "===");
        Object resultObj = joinPoint.proceed();
        logger.info("=== LoggingAspect,WelcomeService, @Around: After Running Method "+ joinPoint.getSignature().getName() + "===");
        return resultObj;
    }

    @AfterReturning("execution(* com.soshiant.controller.WelcomeController.*.*(..))")
    public void logAfterReturningWelcome(JoinPoint joinPoint) throws Throwable{

        logger.info("=== LoggingAspect,WelcomeService, @AfterReturning: Running Method "+ joinPoint.getSignature().getName() + "===");
    }


    @Before(value = "execution(* com.soshiant.service.users.UserService.login(..))")
    public void logBeforeUsers(JoinPoint joinPoint) {

        logger.info("=== LoggingAspect,UsersService, @Before: Before Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @After(value = "execution(* com.soshiant.service.users.UserService.login(..))")
    public void logAfterUsers(JoinPoint joinPoint) {

        logger.info("=== LoggingAspect,UsersService, @After: After Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @Around("execution(* com.soshiant.service.users.*.*(..))")
    public Object logAroundUsers(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info(" LoggingAspect,UsersService, @Around: Before Running Method "+ joinPoint.getSignature().getName() + "===");
        Object resultObj = joinPoint.proceed();
        logger.info("=== LoggingAspect,UsersService, @Around: After Running Method "+ joinPoint.getSignature().getName() + "===");
        logger.info("=========================================================================");
        return resultObj;
    }

    @AfterReturning(pointcut = "execution(* com.soshiant.service.users.*.*(..))",returning= "result")
    public void logAfterReturningUsers(JoinPoint joinPoint, Object result) throws Throwable{

        logger.info("=== LoggingAspect,UsersService, @AfterReturning: Running Method "+ joinPoint.getSignature().getName() + "===");
        logger.info("Method returned value is : " + result);
        logger.info("=========================================================================");

    }
    //==================================================================================================================
    @Around("execution(* com.soshiant.service.customer.*.*(..))")
    public Object logAroundCustomer(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info(" LoggingAspect,CustomerService, @Around: Before Running Method "+ joinPoint.getSignature().getName() + "===");
         Object resultObj = joinPoint.proceed();
        logger.info("=== LoggingAspect,CustomerService, @Around: After Running Method "+ joinPoint.getSignature().getName() + "===");
        logger.info("=========================================================================");
        return resultObj;
    }

    @AfterReturning(pointcut = "execution(* com.soshiant.service.customer.*.*(..))",returning= "result")
    public void logAfterReturningCustomer(JoinPoint joinPoint, Object result) throws Throwable{

        logger.info("=== LoggingAspect,CustomerService, @AfterReturning Aspect: ");
        logger.info("Method Name : "+ joinPoint.getSignature().getName() + ", Method value : " + result);
        logger.info("=========================================================================");

    }


}
