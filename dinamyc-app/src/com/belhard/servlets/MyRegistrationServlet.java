package com.belhard.servlets;

import com.belhard.utils.DatabaseUsers;
import com.belhard.utils.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration.do")
public class MyRegistrationServlet extends HttpServlet {

    private static final String LOGIN_PARAM ="txt_user_login";
    private static final String PASSWORD_PARAM ="txt_user_password";
    private static final String FULLNAME_PARAM ="txt_user_fullName";
    private static final String BIRTHDATE_PARAM ="txt_user_birthDate";

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        String fullName = req.getParameter(FULLNAME_PARAM);
        String birthDate = req.getParameter(BIRTHDATE_PARAM);

        User user = new User(password, fullName, birthDate);
        DatabaseUsers.usersMap.put(login, user);




        req.setAttribute("login", login);
        req.getServletContext().getRequestDispatcher("/afterRegistration.jsp").forward(req,resp);

        Cookie logCook = new Cookie("login", login);
        Cookie passCook = new Cookie("password", password);
        resp.addCookie(logCook);
        resp.addCookie(passCook);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
