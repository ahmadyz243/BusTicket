package view;

import domain.Company;
import domain.Passenger;
import util.AppContext;
import util.Menu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class CompanyMenu extends HttpServlet {
    private final String path = "CompanyMenu.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(path);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origin = req.getParameter("origincity"), destination = req.getParameter("destionationcity");
        int emptyseats = Integer.parseInt(req.getParameter("emptyseats")), price = Integer.parseInt(req.getParameter("price"));
        Date dateAndTime = Menu.dateAndTimeConvertor(req.getParameter("datetime"));
        if(Objects.equals(origin, destination)){
            req.setAttribute("duplicateCities", true);
            req.getRequestDispatcher(path).forward(req, resp);
        } else {
            assert dateAndTime != null;
            if (dateAndTime.compareTo(new Date()) < 0 || dateAndTime.compareTo(new Date()) == 0) {
                req.setAttribute("invalidDate", true);
                req.getRequestDispatcher(path).forward(req, resp);
            } else {
                Company company = (Company) req.getSession().getAttribute("currentUser");
                AppContext.comServiceService.addNewService(company, origin, destination,
                        emptyseats, price, dateAndTime);
                req.setAttribute("allDone", true);
                req.getRequestDispatcher(path).forward(req, resp);
            }
        }
    }
}
