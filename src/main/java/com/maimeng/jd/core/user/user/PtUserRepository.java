package com.maimeng.jd.core.user.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtUserRepository extends JpaRepository<PtUser, Long>,
        JpaSpecificationExecutor<PtUser> {
    PtUser findFirstByAccount(String account);

}
