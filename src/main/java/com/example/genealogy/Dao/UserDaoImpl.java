package com.example.genealogy.Dao;

import com.example.genealogy.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl  {
    private SqlSession sqlSession;
    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public UserDaoImpl(){
        try {
            InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlsession=sqlSessionFactory.openSession(true);
            this.sqlSession=sqlsession;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User QueryUser(User user) {
        UserDaoMapper userDaoMapper=sqlSession.getMapper(UserDaoMapper.class);
        return  userDaoMapper.QueryUser(user);
    }
    public List<User> QueryAllUser() {
        UserDaoMapper userDaoMapper=sqlSession.getMapper(UserDaoMapper.class);
        return userDaoMapper.QueryAllUser();
    }


    public void InsertUser(User user) {
        UserDaoMapper userDaoMapper=sqlSession.getMapper(UserDaoMapper.class);
        userDaoMapper.InsertUser(user);
     }


    public void UpdatePassword(String password) {
        UserDaoMapper userDaoMapper=sqlSession.getMapper(UserDaoMapper.class);
        userDaoMapper.UpdatePassword(password);
    }


    public void DeleteUser(String username) {
        UserDaoMapper userDaoMapper=sqlSession.getMapper(UserDaoMapper.class);
        userDaoMapper.DeleteUser(username);
    }
}
