package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        List<String> noNeedToLoginURLs = Arrays.asList("companysignup", "CompanySignup.jsp", "passengersignup",
                "PassengerSignup.jsp", "HomePage", "HomePage.jsp", "exploded/");
        boolean needLogin = true;
        Boolean isLogin = (Boolean) request.getSession().getAttribute("isLogin");
        for (String url: noNeedToLoginURLs) {
            if(request.getRequestURI().endsWith(url)){
                needLogin = false;
                break;
            }
        }
        if((isLogin != null && isLogin) || !needLogin){
            filterChain.doFilter(request, response);
        }else {
            response.sendRedirect("http://localhost:8080/OnlineTicketWebApp_war_exploded/HomePage");
        }
    }
    @Override
    public void destroy() {

    }
}
