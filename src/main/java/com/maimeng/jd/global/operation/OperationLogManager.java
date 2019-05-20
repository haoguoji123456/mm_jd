package com.maimeng.jd.global.operation;

import com.maimeng.jd.global.annotation.CompleteAnnotation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 操作日志
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class OperationLogManager {
    @Resource
    private OperationLogRepository operationLogRepository;

    @CompleteAnnotation
    public OperationLog addLog(OperationLog mOperationLog) {
        return operationLogRepository.save(mOperationLog);
    }

}
