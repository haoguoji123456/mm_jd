package com.maimeng.jd.core.user.role;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色管理
 *
 * @author wuweifeng wrote on 2018/1/18.
 */
@Component
public class RoleService {
    @Resource
    private PtRoleManager ptRoleManager;

    public List<PtRole> findAll() {
        return ptRoleManager.findAll();
    }

    /**
     *
     * @param ptRole
     *         ptRole
     * @return PtRole
     */
    public PtRole add(PtRole ptRole) {
        return ptRoleManager.add(ptRole);
    }

    public PtRole findOne(Long id) {
        return ptRoleManager.find(id);
    }

    public PtRole update(PtRole ptRole) {

        return ptRoleManager.update(ptRole);
    }

    public boolean delete(Long id) {
        ptRoleManager.delete(ptRoleManager.find(id));
        return true;
    }

}
