package com.maimeng.jd.core.people;

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
public class PtPeopleManager {
    @Resource
    private PtPeopleRepository ptPeopleRepository;


    public PtPeople find(Long id) {
        if (ptPeopleRepository.existsById(id)) {
            return ptPeopleRepository.getOne(id);
        }
        return null;
    }

    public void delete(PtPeople ptPeople) {
        ptPeopleRepository.delete(ptPeople);
    }

    public PtPeople add(PtPeople ptPeople) {
        return ptPeopleRepository.save(ptPeople);
    }


    public PtPeople update(PtPeople ptPeople) {
        return ptPeopleRepository.save(ptPeople);
    }

    public List<PtPeople> findAll(Specification<PtPeople> var1) {
        return ptPeopleRepository.findAll(var1);
    }

    public List<PtPeople> findAll() {
        return ptPeopleRepository.findAll();
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
    public Page<PtPeople> findAll(Specification<PtPeople> var1, Pageable var2) {
        return ptPeopleRepository.findAll(var1, var2);
    }


}
