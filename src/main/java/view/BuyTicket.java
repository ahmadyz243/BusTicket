package view;

import domain.Passenger;
import enumiration.Gender;
import util.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class BuyTicket extends HttpServlet {
    private String tickeCode;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setTickeCode(req.getParameter("buy"));
        Passenger passenger = (Passenger) req.getSession().getAttribute("currentUser");
        String fname = passenger.getFirstName(), lname = passenger.getLastName();
        Gender gender = passenger.getGender();
        req.setAttribute("fname", fname);
        req.setAttribute("lname", lname);
        req.setAttribute("gender", gender);
        req.getRequestDispatcher("BuyTicket.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Passenger passenger = (Passenger) req.getSession().getAttribute("currentUser");
        String gen = passenger.getGender() == Gender.MALE ? "Mr ":"MRS ";
        String fname = passenger.getFirstName(), lname = passenger.getLastName();
        AppContext.ticketService.createTicketByServiceIdAndUserId(getTickeCode());
        req.setAttribute("fname", fname);
        req.setAttribute("lname", lname);
        req.setAttribute("gen", gen);
        req.getRequestDispatcher("SuccessPayment.jsp").forward(req, resp);
    }
    public String getTickeCode() {
        return tickeCode;
    }
    public void setTickeCode(String tickeCode) {
        this.tickeCode = tickeCode;
    }
}