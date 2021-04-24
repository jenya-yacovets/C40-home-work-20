package by.tms.authCalculation.servlet;

import by.tms.authCalculation.config.TypeMessageEnum;
import by.tms.authCalculation.entity.FrontMessage;
import by.tms.authCalculation.entity.User;
import by.tms.authCalculation.exception.LoginIsBusy;
import by.tms.authCalculation.exception.ParametersNotPassedException;
import by.tms.authCalculation.servise.UserService;
import by.tms.authCalculation.util.Servlets;
import by.tms.authCalculation.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("user") != null) {
            req.getSession().setAttribute("message", new FrontMessage(TypeMessageEnum.WARN, "Ты уже зарегистрирован и авторизован."));
            resp.sendRedirect("/");
        } else {
            Servlets.messageMoving(req);
            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        FrontMessage message;

        try {
            User user = Validation.register(name, login, password);
            userService.addUser(user);
            message = new FrontMessage(TypeMessageEnum.INFO, "Аккаунт успешно зарегестрирован");
        } catch (ParametersNotPassedException e) {
            message = new FrontMessage(TypeMessageEnum.WARN, "Не переданы обязательные параметры");

        } catch (LoginIsBusy loginIsBusy) {
            message = new FrontMessage(TypeMessageEnum.WARN, "Логин уже занят, попробуй другой");

        }
        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
