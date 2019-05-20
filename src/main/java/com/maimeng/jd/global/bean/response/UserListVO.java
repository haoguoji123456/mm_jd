package com.maimeng.jd.global.bean.response;

/**
 * @author wuweifeng wrote on 2018/11/26.
 */
public class UserListVO {
    private Long id;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户名称
     */
    private String name;
    private String roleName;
    private Long roleId;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 校区ID
     */
    private Long schoolId;
    /**
     * 班级ID
     */
    private Long classId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 备注
     */
    private String memo;
    
    private String className;
    private String schoolName;
    private String teacherName;

    @Override
    public String toString() {
        return "UserListVO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleId=" + roleId +
                ", state=" + state +
                ", mobile='" + mobile + '\'' +
                ", schoolId=" + schoolId +
                ", classId=" + classId +
                ", email='" + email + '\'' +
                ", memo='" + memo + '\'' +
                ", className='" + className + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
