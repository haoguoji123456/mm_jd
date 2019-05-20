package com.maimeng.jd.core.user.user;


import com.maimeng.jd.global.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2017/10/25.
 * 用户
 */
@Entity
@Table(name = "pt_user", indexes = {@Index(name = "account", columnList =
        "account")})
public class PtUser extends BaseDeleteEntity {
    /**
     * 用户名称
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码（md5加密小写）
     */
    private String password;

    @Override
    public String toString() {
        return "PtUser{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
