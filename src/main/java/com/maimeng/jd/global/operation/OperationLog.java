package com.maimeng.jd.global.operation;


import com.maimeng.jd.global.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 操作日志，包括android ios web
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
public class OperationLog extends BaseEntity {
    private String operationType;
    private String userAgent;
    private String keyword;
    private String title;
    private String content;
    private Boolean isSucceed;
    private Boolean sys;
    private Long userId;

    @Override
    public String toString() {
        return "OperationLog{" +
                "operationType='" + operationType + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", keyword='" + keyword + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isSucceed=" + isSucceed +
                ", sys=" + sys +
                ", userId=" + userId +
                '}';
    }

    public Boolean getSys() {
        return sys;
    }

    public void setSys(Boolean sys) {
        this.sys = sys;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getSucceed() {
        return isSucceed;
    }

    public void setSucceed(Boolean succeed) {
        isSucceed = succeed;
    }
}
