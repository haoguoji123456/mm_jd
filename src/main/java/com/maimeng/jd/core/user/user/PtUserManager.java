package com.maimeng.jd.core.user.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author wuweifeng wrote on 2017/10/26.
 */
@Service
public class PtUserManager {
    @Resource
    private PtUserRepository ptUserRepository;

    public String findNameById(Long id) {
        if (id == null) {
            return "不存在";
        }
        PtUser ptUser = find(id);
        if (ptUser == null) {
            return "不存在";
        }
        return ptUser.getName();
    }


    /**
     * 根据account查询User
     *
     * @param account
     *         账号名
     * @return 用户
     */
    public PtUser findByAccount(String account) {
        return ptUserRepository.findFirstByAccount(account);
    }

    public PtUser find(Long id) {
        if (ptUserRepository.existsById(id)) {
            return ptUserRepository.getOne(id);
        }
        return null;
    }

    public void delete(PtUser ptUser) {
        ptUserRepository.delete(ptUser);
    }

    public PtUser add(PtUser ptUser) {
        return ptUserRepository.save(ptUser);
    }


    public PtUser update(PtUser ptUser) {
        return ptUserRepository.save(ptUser);
    }

    public List<PtUser> findAll(Specification<PtUser> var1) {
        return ptUserRepository.findAll(var1);
    }

    public List<PtUser> findAll() {
        return ptUserRepository.findAll();
    }


    /**
     * 分页查找
     *
     * @param var1
     *         var1
     * @param var2
     *         var2
     * @return Page
     */
    public Page<PtUser> findAll(Specification<PtUser> var1, Pageable var2) {
        return ptUserRepository.findAll(var1, var2);
    }


}
