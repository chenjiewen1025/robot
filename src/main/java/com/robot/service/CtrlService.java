package com.robot.service;

import com.robot.bean.Message;
import com.robot.dao.MessageDao;

import java.sql.SQLException;
import java.util.List;

public class CtrlService {
    MessageDao messageDao = new MessageDao();

    public List<Message> selectAll() throws SQLException, ClassNotFoundException {
        return messageDao.selectAll();
    }

    public List<Message> selectBycommand(String command) {
        return messageDao.selectBycommand(command);

    }

    public List<Message> selectLikedescription(String description) {
        return messageDao.selectLikedescription(description);
    }

    public void deleteOne(String id) {
        messageDao.deleteOne(Integer.valueOf(id));
    }

    public boolean addOne(Message message, String command) {
        if (messageDao.selectBycommand(command) == null || messageDao.selectBycommand(command).size() == 0) {
            messageDao.addOne(message);
            return true;
        } else
            return false;
    }


    public void updateById(Message message) {
        messageDao.updateById(message);

    }

    public Message selectById(String id) {
        return messageDao.selectById(Integer.valueOf(id));
    }

}


