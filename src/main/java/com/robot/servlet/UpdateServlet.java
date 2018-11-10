package com.robot.servlet;

import com.robot.bean.Message;
import com.robot.service.CtrlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        CtrlService ctrlService = new CtrlService();
        String id = req.getParameter("ids");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        Message message = new Message();
        message.setId(Integer.parseInt(id));
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        ctrlService.updateById(message);
        resp.sendRedirect("/List.action");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
