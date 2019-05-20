package com.maimeng.jd.core.dict;


import com.maimeng.jd.global.base.BaseEntity;

import javax.persistence.Entity;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
public class PtDict extends BaseEntity {
    /**
     * 用户婚姻状况（分组的中文名）
     */
    private String groupDesc;
    /**
     * cpp_base_marriage （分组的英文名）
     */
    private String groupName;
    /**
     * 父级groupID
     */
    private Long parentId;
    /**
     * 排序
     */
    private int sortId;
    /**
     * 
     */
    private String key;
    /**
     * 15岁以下、16-25岁
     */
    private String value;


    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

}
