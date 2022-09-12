package view;

import domain.Passenger;
import enumiration.Gender;
import util.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class PassengerSignUp extends HttpServlet {
    private final String path = "PassengerSignup.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(path);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstname = req.getParameter("fname"), lastname = req.getParameter("lname"), username = req.getParameter("username"),
                password = req.getParameter("password"), repeatpassword = req.getParameter("repeatpassword");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        if (!Objects.equals(password, repeatpassword)) {
            req.setAttribute("wrongRepeat", true);
            req.getRequestDispatcher(path).forward(req, resp);
        } else {
            Passenger passenger = AppContext.passengerService.signup(firstname, lastname, username, password, gender);
            if (passenger == null) {
                req.setAttribute("duplicateUsername", true);
                req.getRequestDispatcher(path).forward(req, resp);
            } else {
                req.setAttribute("signedU" , true);
                req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
            }
        }
    }
}
