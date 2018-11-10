package com.robot.servlet;

import com.robot.bean.Message;
import com.robot.dao.MessageDao;
import com.robot.service.CtrlService;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@WebServlet("/List.action")
public class ListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CtrlService listService = new CtrlService();
        List<Message> messagesList = null;
        String command = request.getParameter("command");
        String description = request.getParameter("description");
        if ((command == null || "".equals(command.trim())) && (description == null || "".equals(description.trim()))) {
            try {
                messagesList = listService.selectAll();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if ("".equals(command.trim()) && !"".equals(description.trim()))
            messagesList = listService.selectLikedescription(description);
        else if (!"".equals(command.trim()) && "".equals(description.trim()))
            messagesList = listService.selectBycommand(command);

        request.setAttribute("messageList", messagesList);
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
