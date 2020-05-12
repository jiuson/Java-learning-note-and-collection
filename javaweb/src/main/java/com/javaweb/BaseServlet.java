package com.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :        chali
 * @project :       javaweb
 * @create :        2020/05/12 22:43
 * @description :   Servlet基类
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应的编码格式为utf-8，避免中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        String method = req.getMethod();
        String requestURI = req.getRequestURI();//获取请求URI
        StringBuffer requestURL = req.getRequestURL();
        String webName = req.getContextPath();//获取应用路径（应用名称）
        String queryString = req.getQueryString();//获取查询字符串

        resp.getWriter().write("<h1>下面是获取的字符串</h1>");
        resp.getWriter().write("<h1>method(HTTP方法)：</h1>");
        resp.getWriter().write("<h1>" + method + "</h1><br>");
        resp.getWriter().write("<h1>requestURI(请求URI）:</h1>");
        resp.getWriter().write("<h1>" + requestURI + "</h1><br>");
        resp.getWriter().write("<h1>webname(应用名称):</h1>");
        resp.getWriter().write("<h1>" + webName + "</h1><br>");
        resp.getWriter().write("<h1>querrystring(查询字符串):</h1>");
        resp.getWriter().write("<h1>" + queryString + "</h1>");
    }
}
