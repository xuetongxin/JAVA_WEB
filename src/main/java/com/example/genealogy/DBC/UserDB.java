package com.example.genealogy.DBC;

import com.example.genealogy.Dao.GetSqlSession;
import com.example.genealogy.Dao.UserDaoImpl;

import com.example.genealogy.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

public class UserDB {
    User user;

    public UserDB(){}

    public UserDB(User user){
        this.user=user;
    }

    public void Insert_Into_User(User user) {
        SqlSession sqlSession=new GetSqlSession().getSqlSession();
        try {
            UserDaoImpl userDao=new UserDaoImpl();
            userDao.InsertUser(user);
            sqlSession.commit();
            System.out.println(" 用户注册成功");
        }catch (SqlSessionException sqlSessionException){
            sqlSessionException.toString();
        } finally {
           sqlSession.close();
        }

    }

    public boolean Update_UserEmail_Statue(String email) {
       SqlSession sqlSession=new GetSqlSession().getSqlSession();
       UserDaoImpl userDao=new UserDaoImpl(sqlSession);
       return false;
    }

    public boolean checkUser(User user) {
        SqlSession sqlSession=new GetSqlSession().getSqlSession();
        UserDaoImpl userDao=new UserDaoImpl(sqlSession);
        if (userDao.QueryUser(user)!=null){
            return true;
        }else
            return false;
    }

    public boolean IsNameExist(User user){
        SqlSession sqlSession=null;
        try {
            sqlSession=new GetSqlSession().getSqlSession();
            UserDaoImpl userDaoImpl=new UserDaoImpl(sqlSession);
            if (userDaoImpl.QueryUser(user)!=null)
                return true;
            else
                return false;
        }catch (SqlSessionException e){
            e.getStackTrace();
        }finally {
            sqlSession.close();
        }
        return false;
    }

    public boolean IsEmailExist(User user){
        SqlSession sqlSession=null;
        try{
            sqlSession=new GetSqlSession().getSqlSession();
            UserDaoImpl userDaoImpl =new UserDaoImpl(sqlSession);
            if (userDaoImpl.QueryUser(user)!=null)
                return true;
            else
                return false;
        }catch (SqlSessionException e){
            e.getStackTrace();
        }finally {
            sqlSession.close();
        }
        return false;
    }


}
