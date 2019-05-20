package com.maimeng.jd.core.people;


import com.maimeng.jd.global.base.BaseDeleteEntity;

import javax.persistence.Entity;

/**
 * @author wuweifeng wrote on 2017/10/25.
 * 人群
 */
@Entity
public class PtPeople extends BaseDeleteEntity {
    /**
     * 人群名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 总人数
     */
    private Integer totalCount;
    /**
     * 可短信营销人数
     */
    private Integer canSendSmsCount;
    /**
     * 类型，0公域，1私域，
     */
    private Integer type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
