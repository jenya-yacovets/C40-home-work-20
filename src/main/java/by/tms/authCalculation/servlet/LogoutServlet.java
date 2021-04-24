package by.tms.authCalculation.servlet;

import by.tms.authCalculation.config.TypeMessageEnum;
import by.tms.authCalculation.entity.FrontMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        FrontMessage message;

        if(user != null) {
            session.removeAttribute("user");
            message = new FrontMessage(TypeMessageEnum.INFO, "Вы успешно вышли из аккаунта");
        } else {
            message = new FrontMessage(TypeMessageEnum.WARN, "Вы не авторизованы, чтобы выйти из аккаунта");
        }

        session.setAttribute("message", message);
        resp.sendRedirect("/authorization");
    }
}
