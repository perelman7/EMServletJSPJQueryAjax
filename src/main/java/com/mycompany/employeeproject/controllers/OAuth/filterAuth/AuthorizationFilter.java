package com.mycompany.employeeproject.controllers.OAuth.filterAuth;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.scribe.model.Token;

@WebFilter(filterName ="AuthorizationFilter", 
        urlPatterns = {"/forms/*", 
            "/index.jsp",
            "/readAddEmployee"})
public class AuthorizationFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.print("init auth filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String name = "";
        String email = "";
        Token token = null;
        try{
            name = String.valueOf(session.getAttribute("name")); 
            email = String.valueOf(session.getAttribute("email"));
            token = (Token)session.getAttribute("token");
        }catch(Exception ex){}
        
        if(name.isEmpty() || email.isEmpty() || token == null){
            resp.sendRedirect("login.jsp");
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.print("destroy auth filter");
    }
}
