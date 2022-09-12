package view;

import domain.Passenger;
import domain.Ticket;
import util.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ViewTickets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Passenger passenger = (Passenger) req.getSession().getAttribute("currentUser");
            req.setAttribute("tickets", passenger.getTickets());
        req.getRequestDispatcher("ViewTickets.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ticket ticket = AppContext.ticketService.findById(Integer.parseInt(req.getParameter("ticket-id")));
        req.setAttribute("ticket", ticket);
        req.getRequestDispatcher("ViewTicketInfo.jsp").forward(req, resp);
    }
}
