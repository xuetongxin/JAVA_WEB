package com.example.genealogy;

import com.example.genealogy.DBC.UserDB;
import com.example.genealogy.EMAIL.SendEmail;
import com.example.genealogy.bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SingUpTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;
    @Test
    public void testDoPost() throws Exception {
        // 设置模拟请求参数
        when(request.getParameter("email")).thenReturn("test2@example.com");
        when(request.getParameter("username")).thenReturn("testuser2");
        when(request.getParameter("password")).thenReturn("testpassword2");

        // 模拟数据库操作
        UserDB userDB = mock(UserDB.class);
        doNothing().when(userDB).Insert_Into_User(any(User.class));

        // 模拟发送邮件
        SendEmail sendEmail = mock(SendEmail.class);
        doNothing().when(sendEmail).start();

        // 模拟请求转发
        when(request.getRequestDispatcher("Register_After.jsp")).thenReturn(requestDispatcher);

        // 执行 doPost() 方法
        SingUp signUp = new SingUp();
        signUp.doPost(request, response);

        // 验证请求转发是否发生
        verify(requestDispatcher).forward(request, response);

        // 验证请求属性是否设置正确
        verify(request).setAttribute(eq("username"), eq("testuser2"));
    }
}
