package com.action.www;

import com.serviceImpl.www.UserManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/11/1.
 */
@WebServlet(name = "Servletaction",urlPatterns = {"/activeServlet"})
public class Servletaction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   request.setCharacterEncoding("utf-8");
   response.setContentType("text/html;charset=UTF-8");
   response.setCharacterEncoding("utf-8");
        String uuid = request.getParameter("uuid");
        UserManagerServiceImpl userManagerService = new UserManagerServiceImpl();
        boolean b = userManagerService.activeUser(uuid);
        if (b) {
            PrintWriter writer = response.getWriter();
            writer.write("激活成功！");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
