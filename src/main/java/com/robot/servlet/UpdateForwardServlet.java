package com.robot.servlet;

import com.robot.bean.Message;
import com.robot.service.CtrlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.action")
public class UpdateForwardServlet extends HttpServlet {

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req,resp);
        }

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           req.setCharacterEncoding("utf-8");
            String id = req.getParameter("id");
            CtrlService ctrlService = new CtrlService();
            Message message = ctrlService.selectById(id);
            req.setAttribute("message",message);
            req.getRequestDispatcher("/WEB-INF/update.jsp").forward(req,resp);

        }
    }


