package com.javaweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author :        chali
 * @project :       javaweb
 * @create :        2020/05/12 16:44
 * @description :   测试init()方法的调用时机
 */
public class FirstServlet extends BaseServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("FirstServlet 正在初始化。。。");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
