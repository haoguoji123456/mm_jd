package com.maimeng.jd.core.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtPeopleRepository extends JpaRepository<PtPeople, Long>,
        JpaSpecificationExecutor<PtPeople> {

}
