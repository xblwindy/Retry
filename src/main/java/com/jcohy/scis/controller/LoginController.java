package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.model.Admin;
import com.jcohy.scis.service.AdminService;
import com.jcohy.scis.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName  : LoginController
 * Description  :登录模块处理
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AdminService adminService;

    @Autowired
    private IndexService studentService;


    /**
     * 登录处理
     *
     * @param num
     * @param password
     * @param role
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public JsonResult login(Long num, String password,
                            @RequestParam(required = false) String role, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        session.setAttribute("role", role);

        Admin login = adminService.login(num, password);
        session.setAttribute("user", login);
        return JsonResult.ok().set("returnUrl", "/admin/main");


    }


    /**
     * 注销用户
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/";
    }



}
