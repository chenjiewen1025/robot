package com.robot.servlet;

import com.robot.service.CtrlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOneServlet.do")
public class DeleteOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        CtrlService listService = new CtrlService();
        listService.deleteOne(id);
        req.getRequestDispatcher("/List.action").forward(req,resp);
    }
}
