package com.example.genealogy.Dao;

import com.example.genealogy.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDaoMapper {
    public User QueryUser(User user);
    public List<User> QueryAllUser();
    public void InsertUser(User user);

    public void UpdatePassword(String password);

    public void DeleteUser(String username);
}
