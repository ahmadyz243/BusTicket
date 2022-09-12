package view;
import domain.Company;
import util.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class CompanySignUp extends HttpServlet {
    private final String path = "CompanySignup.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(path);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyName = req.getParameter("companyname"), username = req.getParameter("companyusername")
                , password = req.getParameter("companypassword"), repeat = req.getParameter("companypasswordrepeat");

        if(!Objects.equals(password, repeat)){
            req.setAttribute("wrongRepeat", true);
            req.getRequestDispatcher(path).forward(req, resp);
        }else {
            Company company = AppContext.companyService.signup(companyName, username, password);
            if(company == null){
                req.setAttribute("duplicateUsername", true);
                req.getRequestDispatcher(path).forward(req, resp);
            }else{
                req.setAttribute("signedC" , true);
                req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
            }
        }
    }
}
