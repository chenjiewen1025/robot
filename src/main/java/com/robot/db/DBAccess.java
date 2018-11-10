package com.robot.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;

/**
 * @program: chenjiewen
 * @description:数据库接口类，返回sqlsession
 * @author: Mr.cjw
 * @create: 2018-11-06 21:29
 **/
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        //读取配置文件获取连接信息
        Reader reader = Resources.getResourceAsReader("DBconfig/Configuration.xml");
        //通过配置信息reader构建sqlsessionfactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //打开数据库会话，返回sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return  sqlSession;
    }

}
