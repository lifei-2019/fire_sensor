package com.l.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.l.bean.UserInfo;
import com.l.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("user")
@Api(description = "用户操作")
@Controller
public class UserController {

    @Resource(name = "userInfoServiceImpl")
    private IUserInfoService userInfoService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登录")
    public boolean login(UserInfo user, HttpServletRequest request) {

        EntityWrapper<UserInfo> wp = new EntityWrapper(user);
        List<UserInfo> userInfos = userInfoService.selectList(wp);

        if (userInfos != null && !userInfos.isEmpty()) {
            UserInfo userInfo = userInfos.get(0);
            request.getSession().setAttribute("user_key", userInfo);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "注册用户")
    public String addUser(UserInfo user) {
        boolean insert = userInfoService.insert(user);
        if (insert) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更改密码")
    public boolean updateUser(UserInfo user, HttpSession session) {
        user.setPassword(user.getNewPassword());
        boolean update = userInfoService.updateById(user);
        if (update) {
            session.removeAttribute("user_key");
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping(value = "sessionUser", method = RequestMethod.GET)
    @ResponseBody
    public UserInfo updateUser(HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user_key");
        return userInfo;
    }

    @RequestMapping(value = "exit", method = RequestMethod.GET)
    @ApiOperation(value = "退出系统")
    public ModelAndView exit(HttpSession session) {
        session.removeAttribute("user_key");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:loginPage");
        return mv;
    }

}
