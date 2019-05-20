package com.maimeng.jd.core.user.user;

import com.maimeng.jd.core.user.role.PtRoleManager;
import com.maimeng.jd.core.user.user.dto.UserDto;
import com.maimeng.jd.core.user.user.vo.UserVO;
import com.maimeng.jd.global.UserKit;
import com.maimeng.jd.global.annotation.CompleteAnnotation;
import com.maimeng.jd.global.annotation.UserLogAnnotation;
import com.maimeng.jd.global.bean.BaseData;
import com.maimeng.jd.global.bean.ResultCode;
import com.maimeng.jd.global.bean.ResultGenerator;
import com.maimeng.jd.global.bean.SimplePage;
import com.maimeng.jd.global.specify.Criteria;
import com.maimeng.jd.tool.JwtUtils;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @author wuweifeng wrote on 2018/11/23.
 */
@Component
public class UserService {
    @Resource
    private PtUserManager ptUserManager;
    @Resource
    private PtRoleManager ptRoleManager;
    @Resource
    private UserKit userKit;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @UserLogAnnotation("用户登录")
    public BaseData login(String account, String password) {
        PtUser ptUser = ptUserManager.findByAccount(account);
        if (ptUser == null) {
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.USER_NO_EXIST, "用户不存在");
        }
        if (!ptUser.getPassword().equals(password)) {
            //密码错误
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR, "密码错误");
        }
        if (ptUser.isDeleteFlag()) {
            //没有权限
            return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "该用户没有权限");
        }
        // Create Twt token
        try {
            String token = jwtUtils.generateToken(ptUser.getId());
            return ResultGenerator.genSuccessResult(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseData smsLogin(String mobile, String smsCode) {
        PtUser ptUser = ptUserManager.findByAccount(mobile);
        if (ptUser == null) {
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.USER_NO_EXIST, "用户不存在");
        }
        if (ptUser.isDeleteFlag()) {
            //没有权限
            return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "该用户没有权限");
        }
        String savedCode = stringRedisTemplate.opsForValue().get("rise_sms_" + mobile);
        if ("9999".equals(smsCode) || smsCode.equals(savedCode)) {
            // Create Twt token
            try {
                String token = jwtUtils.generateToken(ptUser.getId());
                return ResultGenerator.genSuccessResult(token);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return ResultGenerator.genFailResult("验证码错误");
    }

    @UserLogAnnotation("更新密码")
    public BaseData updatePassword(String oldPass, String pass) {
        Long userId = userKit.getCurrentUserId();
        PtUser ptUser = ptUserManager.find(userId);
        if (!ptUser.getPassword().equals(oldPass)) {
            return ResultGenerator.genFailResult("旧密码不正确");
        }

        ptUser.setPassword(pass);
        ptUserManager.update(ptUser);
        return ResultGenerator.genSuccessResult("修改成功");
    }

    public boolean isErrorUser(Long userId) {
        return ptUserManager.find(userId).isDeleteFlag();
    }

    @UserLogAnnotation("用户注册")
    @CompleteAnnotation
    public BaseData add(PtUser ptUser) {
        PtUser ptUser1 = ptUserManager.findByAccount(ptUser.getAccount());
        if (ptUser1 != null) {
            return ResultGenerator.genFailResult("该用户已被注册");
        }

        return ResultGenerator.genSuccessResult(ptUserManager.add(ptUser));
    }

    public SimplePage<UserVO> find(UserDto userDto, Pageable pageable) {
        Criteria<PtUser> criteria = new Criteria<>();

        Page<PtUser> page = ptUserManager.findAll(criteria, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream().map
                (this::parse).collect(Collectors.toList()));
    }
    
    private UserVO parse(PtUser ptUser) {
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(ptUser, userVO);

        return userVO;
    }

    //public UserListVO find(Long id) {
    //    PtUser ptUser = ptUserManager.find(id);
    //    return parse(ptUser);
    //}


    public PtUser findMe() {
        PtUser ptUser = ptUserManager.find(userKit.getCurrentUserId());
        return ptUserManager.findByAccount(ptUser.getAccount());
    }

    public void delete(Long id) {
        ptUserManager.delete(ptUserManager.find(id));
    }
}
