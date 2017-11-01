package com.action.www;

import com.serviceImpl.www.MailCheckImp;
import com.serviceImpl.www.UserManagerServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/10/31.
 */
@javax.servlet.annotation.WebServlet(name = "ServletRegister",urlPatterns = {"/registerServlet"})
public class ServletRegister extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
//邮箱验证
        MailCheckImp mailCheckImp = new MailCheckImp();
        boolean b = mailCheckImp.checkEmail(email);
        System.out.println("A");

        if (b) {
            System.out.println("B");

            UserManagerServiceImpl userManagerService = new UserManagerServiceImpl();
            boolean b1 = userManagerService.registerUser(username, password, email);

                System.out.println("C");
            if (b1) {
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }

//
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request, response);

    }
}
