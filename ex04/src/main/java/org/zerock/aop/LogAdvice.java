package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component // bean용
public class LogAdvice {

    @Before("execution(* org.zerock.service.SampleService*.*(..))")
    //Before Advice : target의 joinPoint를 호출하기 전에 실행
    //괄호 안은 aspectJ의 표현식이다. execution은 접근자와 클래스,메서드를 지정할 수 있다.
    public void logBefore() {

        log.info("========================");
    }

    @Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
    //SampleService(Impl)의 doAdd메서드 실행하기 전에 하는 행위이며, 뒤의 && args를 통해 아래 메서드의 파람으로 줄 수 있다.
    //이처럼 간단한 경우에는 유용하지만 나중에는 쉽지 않을 수 있다.
    public void logBeforeWithParam(String str1, String str2) {

        log.info("str1: " + str1);
        log.info("str2: " + str2);
    }

    @AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {

        log.info("Exception....!!!!");
        log.info("exception: " + exception);

    }

    @Around("execution(* org.zerock.service.SampleService*.*(..))")
    //Service~클래스의 어떤 메서드를 실행하던 다 될 수 있게 해놓음
    //@Around와 ProceedingJoinPoint을 결합하여 처리한다.
    //@Before등과 달리 @Around로 처리하는 경우에는 void반환은 안된다.
    //메서드 invoke과 사전/사후처리를 직접 제어할 수 있는 강력한 기능이다.
    public Object logTime(ProceedingJoinPoint pjp) {

        //1.전처리
        long start = System.currentTimeMillis();

        log.info("Target: " + pjp.getTarget());
        log.info("Param: " + Arrays.toString(pjp.getArgs()));

        //2.집행(invoke method)
        Object result = null;

        try {
            result = pjp.proceed();//'어떤'메서드 실행
        } catch (Throwable e) {
            e.printStackTrace();
        }

        //3.사후처리
        long end = System.currentTimeMillis();

        log.info("TIME: " + (end - start));

        return result;
    }
}