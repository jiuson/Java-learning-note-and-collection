package com.springweb;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :
 * @project :       springweb-no-annocation
 * @create :        2020/05/14 15:52
 * @description :   在浏览器地址栏输入：http://localhost:8080/springweb/simpleController.action
 */
public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        //ClassPathXmlApplicationContext
        modelAndView.addObject("data",list);
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }
}
