package com.maimeng.jd.core.user.user;

import com.maimeng.jd.core.user.user.dto.UserDto;
import com.maimeng.jd.global.bean.BaseData;
import com.maimeng.jd.global.bean.ResultGenerator;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/23.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("")
    public BaseData add(PtUser ptUser) {
        return ResultGenerator.genSuccessResult(userService.add(ptUser));
    }

    @GetMapping("")
    public BaseData list(UserDto userDto, @PageableDefault
          (sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResultGenerator.genSuccessResult(userService.find(userDto, pageable));
    }


    @GetMapping("/me")
    public BaseData me() {
        return ResultGenerator.genSuccessResult(userService.findMe());
    }

    //@GetMapping("/{id}")
    //public BaseData one(@PathVariable Long id) {
    //    return ResultGenerator.genSuccessResult(userService.find(id));
    //}

    //@GetMapping("/menu")
    //public BaseData menu() {
    //    return ResultGenerator.genSuccessResult(userService.menu());
    //}

    @PutMapping("/password")
    public BaseData password(String oldPassword, String password) {
        return userService.updatePassword(oldPassword, password);
    }

    @PostMapping("/login")
    public BaseData login(String account, String password) {
        return userService.login(account, password);
    }

    /**
     * 注册
     */
    @PostMapping("/regist")
    public BaseData regist(PtUser ptUser) {
        return userService.add(ptUser);
    }

    @PostMapping("/smsLogin")
    public BaseData smsLogin(String account, String smsCode) {
        return userService.smsLogin(account, smsCode);
    }

    @DeleteMapping("/{id}")
    public BaseData delete(@PathVariable Long id) {
        userService.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
