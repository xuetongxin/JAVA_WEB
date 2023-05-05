package com.example.genealogy.Dao;

import com.example.genealogy.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void queryUser() {
        String username=null;
        String password=null;
        String email=null;
        username ="ximeng";
        password ="xsl203457";
        //email="xsl203457@163.com";
        SqlSession sqlSession=new GetSqlSession().getSqlSession();
        UserDaoImpl userDao=new UserDaoImpl(sqlSession);
        User user=new User(username);
        User user1= userDao.QueryUser(user);
        System.out.println(user1);
    }

    @Test
    void queryAllUser() {
        SqlSession sqlSession=new GetSqlSession().getSqlSession();
        UserDaoImpl userDao=new UserDaoImpl(sqlSession);
         List<User> user=userDao.QueryAllUser();
         System.out.println(user);

    }

    @Test
    void insertUser() {

        SqlSession sqlSession=new GetSqlSession().getSqlSession();
        UserDaoImpl userDao=new UserDaoImpl(sqlSession);
        User user=new User();
        user.setEmail("fshyereyjs");
        user.setUsername("kjsfrtyrvbd");
        user.setPassword("jiktrhhhj");
        userDao.InsertUser(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    void updatePassword() {
    }

    @Test
    void deleteUser() {
    }
}