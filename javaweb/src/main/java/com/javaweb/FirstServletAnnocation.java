package com.javaweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :        chali
 * @project :       javaweb
 * @create :        2020/05/12 22:38
 * @description :   通过注解的方式测试init()方法调用的时机
 */

@WebServlet(urlPatterns = "/FirstServletAnnocation", loadOnStartup = 1)
public class FirstServletAnnocation extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("FirstServletAnnocation 正在初始化。。。");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
