package view;


import comprators.SortByDate;
import domain.ComService;
import domain.Passenger;
import util.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PassengerMenu extends HttpServlet {
    private final String path = "PassengerMenu.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(path);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origin = req.getParameter("origin"), destination = req.getParameter("destination");
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<ComService> services = AppContext.comServiceService.searchServiceByOriginAndDestinationAndDate(origin, destination, date);
        if (services == null || services.size() == 0) {
            req.setAttribute("notFound", true);
            req.getRequestDispatcher(path).forward(req, resp);
        } else {
            Passenger passenger = (Passenger) req.getSession().getAttribute("currentUser");
            services.sort(new SortByDate());
            req.setAttribute("services", services);
            req.setAttribute("userId", passenger.getId());
            req.getRequestDispatcher(path).forward(req, resp);
        }
    }
}