package com.maimeng.jd.global.aop;

import com.maimeng.jd.global.annotation.CompleteAnnotation;
import com.maimeng.jd.global.base.BaseEntity;
import com.maimeng.jd.tool.CommonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 完善操作人、创建、更新时间的切面
 * @author wuweifeng wrote on 2017/10/23.
 */
@Aspect
@Component
@Order(3)
public class CompleteAspect {

    @Around("@annotation(completeAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint, CompleteAnnotation completeAnnotation) throws Throwable {
        //方法内的所有参数
        Object[] params = joinPoint.getArgs();
        Date date = CommonUtil.getNow();
        String method = joinPoint.getSignature().getName();

        for (Object o : params) {
            if (!(o instanceof BaseEntity)) {
                continue;
            }

            BaseEntity baseEntity = (BaseEntity) o;

            if (method.contains("add")) {
                baseEntity.setCreateTime(date);
            } else if (method.contains("update") || method.contains("delete")) {
                baseEntity.setUpdateTime(date);
            }

        }
        return joinPoint.proceed();
    }

}
