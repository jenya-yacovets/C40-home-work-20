package by.tms.authCalculation.servlet;

import by.tms.authCalculation.config.TypeMessageEnum;
import by.tms.authCalculation.entity.FrontMessage;
import by.tms.authCalculation.entity.Operation;
import by.tms.authCalculation.entity.User;
import by.tms.authCalculation.exception.FieldNotChangedException;
import by.tms.authCalculation.exception.ParametersNotPassedException;
import by.tms.authCalculation.exception.UserNotFoundException;
import by.tms.authCalculation.servise.UserService;
import by.tms.authCalculation.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/update-name")
public class UpdateNameUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user == null) {
            req.getSession().setAttribute("message", new FrontMessage(TypeMessageEnum.WARN, "Вы не авторизованы. Для работы с данной страницей необходима авторизация"));
            resp.sendRedirect("/authorization");
        } else {
            getServletContext().getRequestDispatcher("/updateName.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        FrontMessage message;

        if(user != null) {

            String name = req.getParameter("name");

            try {
                User user1 = userService.updateName((User) user, Validation.updateName(name));

                // Изменяем данные в сеессии после редактирования данных пользователя в DAO
                session.setAttribute("user", user1);
                message = new FrontMessage(TypeMessageEnum.INFO, "Имя успешно изменено");
            } catch (FieldNotChangedException e) {
                message = new FrontMessage(TypeMessageEnum.WARN, "Имя введено старое");
            } catch (ParametersNotPassedException e) {
                message = new FrontMessage(TypeMessageEnum.WARN, "Параметр не передан");
            } catch (UserNotFoundException e) {
                message = new FrontMessage(TypeMessageEnum.WARN, "Пользователь не найден");
            }

            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/updateName.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("message", new FrontMessage(TypeMessageEnum.WARN, "Вы не авторизованы. Для работы с данной страницей необходима авторизация"));
            resp.sendRedirect("/authorization");
        }
    }
}
