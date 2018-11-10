package com.robot.servlet;

import com.robot.bean.Message;
import com.robot.service.CtrlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Add.do")
public class AddOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String command = req.getParameter("command");
        String description  = req.getParameter("description");
        String content  = req.getParameter("content");
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        CtrlService ctrlService = new CtrlService();
        boolean exist = ctrlService.addOne(message,command);
       if (exist){
           resp.sendRedirect("/List.action");
       }
       else {
            req.setAttribute("error","该描述已经存在！！");
           req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req,resp);
       }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req,resp);
    }
}
