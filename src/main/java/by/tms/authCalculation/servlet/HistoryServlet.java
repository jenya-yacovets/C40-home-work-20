package by.tms.authCalculation.servlet;

import by.tms.authCalculation.config.TypeMessageEnum;
import by.tms.authCalculation.entity.FrontMessage;
import by.tms.authCalculation.entity.Operation;
import by.tms.authCalculation.entity.User;
import by.tms.authCalculation.servise.OperationService;
import by.tms.authCalculation.util.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {
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
            List<Operation> allOperationUser = operationService.getAllOperationUser((User) user);
            req.setAttribute("allOperationUser", allOperationUser);
            getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
        }
    }
}
