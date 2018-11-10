package com.robot.dao;
import com.robot.bean.Message;
import com.robot.db.DBAccess;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * dao层，数据库操作层
 */
public class MessageDao {

    DBAccess dbAccess = new DBAccess();
    SqlSession sqlSession = null;
    //查询数据库所有数据
    public List<Message> selectAll() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/robot?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT","root","chenjiewen");
//        String sql = "select ID,COMMAND,DESCRIPTION,CONTENT from message";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        ResultSet rs  = statement.executeQuery();
//        List<Message> messagesList = new ArrayList<Message>();
//        while (rs.next()){
//            Message message = new Message();
//            message.setId(rs.getString("ID"));
//            message.setCommand(rs.getString("COMMAND"));
//            message.setDescription(rs.getString("DESCRIPTION"));
//            message.setContent(rs.getString("CONTENT"));
//            messagesList.add(message);
//        }
        List<Message> messagesList = new ArrayList<Message>();
        try {
            sqlSession = dbAccess.getSqlSession();
            messagesList = sqlSession.selectList("Message.selectAll");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return messagesList;
    }
    public List<Message> selectBycommand(String command){
        List<Message> messagesList = new ArrayList<Message>();
        try {
            sqlSession = dbAccess.getSqlSession();
            messagesList = sqlSession.selectList("Message.selectBycommand",command );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }


        return messagesList;
    }
    public List<Message> selectLikedescription(String description){
        List<Message> messagesList = new ArrayList<Message>();
        try {
            sqlSession = dbAccess.getSqlSession();
            messagesList = sqlSession.selectList("Message.selectLikedescription",description );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return messagesList;
    }
    public void deleteOne(int id){
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addOne(Message message){
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("Message.addOne",message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void updateById(Message message){
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("Message.updateById",message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Message selectById(int id){
        Message message = null;
        try {
            sqlSession  = dbAccess.getSqlSession();
            message = sqlSession.selectOne("Message.selectById",id);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
    public void deleteSome(List<Integer> ids){
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteSome",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        MessageDao messageDao = new MessageDao();
//        messageDao.queryMessageList();
//    }
}
