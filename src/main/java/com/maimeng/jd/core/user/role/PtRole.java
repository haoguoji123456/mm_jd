package com.maimeng.jd.core.user.role;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maimeng.jd.global.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2017/10/25.
 * 角色表
 */
@Entity
@Table(name = "pt_role")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class PtRole extends BaseDeleteEntity {
    /**
     * 角色名
     */
    private String name;
    /**
     * 角色描述
     */
    private String sign;
    /**
     * 菜单
     */
    private String menus;

    @Override
    public String toString() {
        return "PtRole{" +
                "name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                ", menus='" + menus + '\'' +
                '}';
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
