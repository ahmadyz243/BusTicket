package view;

import domain.Passenger;
import domain.Ticket;
import util.AppContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Ticket ticket = AppContext.ticketService.findById(Integer.parseInt(req.getParameter("del-ticket-id")));
        Passenger passenger = (Passenger) req.getSession().getAttribute("currentUser");
        passenger.getTickets().remove(ticket);
        AppContext.ticketService.delete(ticket);
        resp.sendRedirect("DeleteTicket.jsp");
    }
}