package com.maimeng.jd.core.user.user.vo;

/**
 * @author wuweifeng wrote on 2019/5/14.
 */
public class UserVO {
    private Long id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * qq
     */
    private String qq;
    /**
     * wx
     */
    private String wx;
    /**
     * 是否是vip。（邀请三个就是vip）0,1,2  非、vip、高级vip
     */
    private Integer vip;
    /**
     * 邀请码
     */
    private String inviteCode;

    private Long webSiteId;
    /**
     * 分站名称
     */
    private String webSiteName;
    /**
     * 偏远预警
     */
    private String farPlace;

    public String getFarPlace() {
        return farPlace;
    }

    public void setFarPlace(String farPlace) {
        this.farPlace = farPlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Long getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(Long webSiteId) {
        this.webSiteId = webSiteId;
    }

    public String getWebSiteName() {
        return webSiteName;
    }

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = webSiteName;
    }
}
