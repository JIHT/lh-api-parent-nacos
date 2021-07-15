package com.lihua.feedcontrollerapi.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MapperAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @AfterReturning("execution(* com.lihua.feedcontrollerapi.dao.*.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
//        logger.info("Completed: " + joinPoint);
    }

    /**
     * 监控com.lsj.xcjfs.dao..*Mapper包及其子包的所有public方法
     */
    @Pointcut("execution(* com.lihua.feedcontrollerapi.dao.*.*(..))")
    private void pointCutMethod() {
    }

    /**
     * 声明环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.nanoTime();
        Object obj = pjp.proceed();
        long end = System.nanoTime();
        long timeUsed =(end - begin) / 1000000;
        if(timeUsed>1000L){
            logger.info("调用Mapper方法：{}，参数：{}，执行耗时：{}纳秒，耗时：{}毫秒", pjp.getSignature().toString(), Arrays.toString(pjp.getArgs()), (end - begin), (end - begin) / 1000000);
        }
        return obj;
    }

}