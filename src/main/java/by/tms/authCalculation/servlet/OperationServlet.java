package by.tms.authCalculation.servlet;

import by.tms.authCalculation.config.OperationEnum;
import by.tms.authCalculation.config.TypeMessageEnum;
import by.tms.authCalculation.entity.FrontMessage;
import by.tms.authCalculation.entity.Operation;
import by.tms.authCalculation.entity.User;
import by.tms.authCalculation.exception.ParametersNotPassedException;
import by.tms.authCalculation.servise.OperationService;
import by.tms.authCalculation.util.Servlets;
import by.tms.authCalculation.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class OperationServlet extends HttpServlet {
    private OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if(user == null) {
            req.getSession().setAttribute("message", new FrontMessage(TypeMessageEnum.WARN, "Вы не авторизованы. Для работы с данной страницей необходима авторизация"));
            resp.sendRedirect("/authorization");
        } else {
            Servlets.messageMoving(req);
            req.setAttribute("operations", OperationEnum.values());
            getServletContext().getRequestDispatcher("/operation.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        FrontMessage message = null;

        if(user != null) {

            String num1 = req.getParameter("num1");
            String num2 = req.getParameter("num2");
            String method = req.getParameter("method");

            try {
                Operation operation = Validation.operation(num1, num2, method);
                operation.setUser((User) user);
                operationService.addOperation(operation);
                message = new FrontMessage(TypeMessageEnum.INFO, String.format("Результат: %f", operation.result()));
            } catch (ParametersNotPassedException e) {
                message = new FrontMessage(TypeMessageEnum.WARN, "Не переданы обязательные параметры или указаны не верно");
            }
        }

//      делаю через редирект, так как в JSP нужно выводить список доступных операций из config/OperationEnum
        session.setAttribute("message", message);
        resp.sendRedirect("/");
    }
}
