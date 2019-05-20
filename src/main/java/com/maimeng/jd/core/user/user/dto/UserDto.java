package com.maimeng.jd.core.user.user.dto;

/**
 * @author wuweifeng wrote on 2019/5/14.
 */
public class UserDto {
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
     * 邀请人账号
     */
    private String inviteAccount;
    /**
     * 偏远预警
     */
    private String farPlace;

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

    public String getInviteAccount() {
        return inviteAccount;
    }

    public void setInviteAccount(String inviteAccount) {
        this.inviteAccount = inviteAccount;
    }

    public String getFarPlace() {
        return farPlace;
    }

    public void setFarPlace(String farPlace) {
        this.farPlace = farPlace;
    }
}
