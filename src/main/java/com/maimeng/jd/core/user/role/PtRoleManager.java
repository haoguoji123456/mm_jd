package com.maimeng.jd.core.user.role;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
@Service
public class PtRoleManager {
    @Resource
    private PtRoleRepository ptRoleRepository;

    public PtRole find(Long roleId) {
        return ptRoleRepository.getOne(roleId);
    }

    public String findName(Long roleId) {
        PtRole ptRole = find(roleId);
        if (ptRole == null) {
            return "";
        }
        return ptRole.getSign();
    }

    public List<PtRole> findAll() {
        return ptRoleRepository.findByDeleteFlagFalse();
    }

    /**
     * 添加一个role
     *
     * @param ptRole
     *         ptRole
     * @return ptRole
     */
    public PtRole add(PtRole ptRole) {
        return save(ptRole);
    }

    public PtRole update(PtRole ptRole) {
        return save(ptRole);
    }

    private PtRole save(PtRole ptRole) {
        return ptRoleRepository.save(ptRole);
    }

    /**
     * 删除角色
     *
     * @param ptRole
     *         ptRole
     */
    public void delete(PtRole ptRole) {
        ptRole.setDeleteFlag(true);
        update(ptRole);
    }

    public boolean exists(Long id) {
        return ptRoleRepository.existsById(id);
    }
}
