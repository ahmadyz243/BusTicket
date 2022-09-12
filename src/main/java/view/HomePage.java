package view;

import domain.Company;
import domain.Passenger;
import util.AppContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomePage extends HttpServlet {
    private final String path = "HomePage.jsp";
    @Override
    public void init(ServletConfig config) throws ServletException {
        AppContext.ticketService.deleteOldTickets();
        AppContext.comServiceService.deleteOldServices();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Boolean isLogin = (Boolean) req.getSession().getAttribute("isLogin");
        if(isLogin != null && isLogin){
            req.getSession().setAttribute("isLogin", false);
            req.getSession().setAttribute("currentUser", null);
            System.out.println(" user logged out");
        }
        resp.sendRedirect(path);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uUsername = req.getParameter("u-username"), password = req.getParameter("password"), cUsername = req.getParameter("c-username");
        if (uUsername != null && cUsername == null) {
            //User Login
            Passenger passenger = AppContext.passengerService.login(uUsername, password);
            if (passenger == null) {
                req.setAttribute("uLoginFail", true);
                req.getRequestDispatcher(path).forward(req, resp);
            }else {
                HttpSession session = req.getSession();
                session.setAttribute("isLogin", true);
                session.setAttribute("currentUser", passenger);
                session.setMaxInactiveInterval(300);
                resp.sendRedirect("http://localhost:8080/OnlineTicketWebApp_war_exploded/passengermenu");
            }
        } else if (uUsername == null && cUsername != null) {
            //login company
            Company company = AppContext.companyService.login(cUsername, password);
            if(company == null){
                req.setAttribute("cLoginFail", true);
                req.getRequestDispatcher(path).forward(req, resp);
            }else {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", company);
                session.setAttribute("isLogin", true);
                session.setMaxInactiveInterval(300);
                resp.sendRedirect("http://localhost:8080/OnlineTicketWebApp_war_exploded/companymenu");
            }
        }
    }
}
