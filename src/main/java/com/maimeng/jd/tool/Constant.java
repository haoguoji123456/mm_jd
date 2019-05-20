package com.maimeng.jd.tool;

import org.springframework.data.domain.Sort;

/**
 * @author wuweifeng wrote on 2017/10/25.
 */
public interface Constant {
    String USER_ID = "userId";
    /**
     * 正常态
     */
    int STATE_NORMAL = 0;

    String REASON_NEW_CREATE = "新建";
    String REASON_UPDATE = "修改";
    String REASON_DELETE = "下架";
    String REASON_UPLOAD = "上架";


    int SUCCESS = 1;
    int FAILURE = 0;

    //超管
    String ROLE_ADMIN = "admin";
    //行政(发货、输验证码)
    String ROLE_HR = "hr";


    Long MANAGER_COMPANY_ID = 0L;

    String CONTENT_TYPE = "content-type";
    String APP_JSON = "application/json";

    /**
     * 用户访问任何接口header里带的token
     */
    String AUTHORIZATION = "token";
    String USERID = "userId";
    String SYS = "sys";
    String WEBSITE_ID = "webSiteId";
    String USER_AGENT = "userAgent";

    String HEADER_DOMAIN = "domain";

    int PAGE_SIZE = 10;
    int PAGE_NUM = 0;
    Sort.Direction DIRECTION = Sort.Direction.DESC;
}
