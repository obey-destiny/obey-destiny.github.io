package com.haha.controller;

import com.haha.entity.User;
import com.haha.service.UserService;
import com.haha.utils.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    /**
     * 用户注册
     */
    @RequestMapping("register")
    public String register(User user, String code, HttpSession session) throws UnsupportedEncodingException {
        log.debug("接收到的验证码：{}", code);
        log.debug("用户名：{},真实姓名：{},密码：{},性别：{}", user.getUsername(), user.getRealname(), user.getPassword(),user.getGender());

        try {
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误！");
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/register.jsp?msg="+ URLEncoder.encode(e.getMessage(), "utf-8");
        }

        return "redirect:/login.jsp";
    }


    /**
     * 用来生成验证码
     */
    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException {
        String code = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute("code", code);
        response.setContentType("image/png");
        ServletOutputStream outputStream = response.getOutputStream();
        VerifyCodeUtils.outputImage(220, 60, outputStream, code);
    }
}
