package com.maimeng.jd.global.aop;

import com.maimeng.jd.global.UserKit;
import com.maimeng.jd.global.annotation.UserLogAnnotation;
import com.maimeng.jd.global.operation.OperationLog;
import com.maimeng.jd.global.operation.OperationLogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2017/10/23.
 */
@Aspect
@Component
@Order(4)
public class SavePointAspect {
    @Resource
    private UserKit userKit;
    @Resource
    private OperationLogManager operationLogManager;

    @Around("@annotation(userLogAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint, UserLogAnnotation userLogAnnotation) throws Throwable {
        //标记的日志内容，如"添加user"
        String title = userLogAnnotation.value();
        //当前操作的用户id
        Long userId = userKit.getCurrentUserId();
        //方法内的所有参数
        Object[] params = joinPoint.getArgs();

        //添加系统日志
        OperationLog operationLog = new OperationLog();
        operationLog.setUserAgent(userKit.getUserAgent());

        String content = "";
        for (Object o : params) {
            content += o.toString() + ";";
        }
        operationLog.setContent(content);
        operationLog.setSucceed(true);
        operationLog.setTitle(title);
        operationLog.setUserId(userId);

        try {
            Object o1 = joinPoint.proceed();

            operationLogManager.addLog(operationLog);
            return o1;
        } catch (Throwable throwable) {
            operationLog.setSucceed(false);
            operationLogManager.addLog(operationLog);
            throw throwable;
        }
    }
}
