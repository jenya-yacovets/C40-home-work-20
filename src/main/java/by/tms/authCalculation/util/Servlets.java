package by.tms.authCalculation.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Servlets {
    public static void messageMoving(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if(session.getAttribute("message") != null && req.getAttribute("message") == null) {
            req.setAttribute("message", session.getAttribute("message"));
            session.removeAttribute("message");
        }
    }
}
