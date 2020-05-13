package com.l.interceptor;

import com.l.bean.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String basePath = request.getContextPath();
        String path = request.getRequestURI();
        //System.out.println("basePath:"+basePath);
        //System.out.println("path:"+path);

        if (!doLoginInterceptor(path, basePath)) {//是否进行登陆拦截
            return true;
        }
        //如果登录了，会把用户信息存进session
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user_key");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/loginPage");
            return false;
        }
        return true;
    }

    /**
     * 是否进行登陆过滤
     *
     * @param path
     * @param basePath
     * @return
     */
    private boolean doLoginInterceptor(String path, String basePath) {
        path = path.substring(basePath.length());
        Set<String> notLoginPaths = new HashSet<String>();
        //设置不进行登录拦截的路径：登录注册和验证码
        notLoginPaths.add("/loginPage");
        notLoginPaths.add("/user/login");
        notLoginPaths.add("/registerPage");
        notLoginPaths.add("/user/addUser");
        if (notLoginPaths.contains(path)) return false;
        return true;
    }

}
