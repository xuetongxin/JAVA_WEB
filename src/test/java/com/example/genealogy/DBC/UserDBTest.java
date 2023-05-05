package com.example.genealogy.DBC;

import com.example.genealogy.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDBTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void insert_Into_User() {
        User user=new User();
        user.setUsername("hdjas");
        user.setPassword("vuxvd");
        user.setEmail("vnoijowefw");
        UserDB userDB=new UserDB();
        userDB.Insert_Into_User(user);
    }

    @Test
    void update_UserEmail_Statue() {
    }

    @Test
    void checkUser() {
    }

    @Test
    void isNameExist() {
    }

    @Test
    void isEmailExist() {
    }
}