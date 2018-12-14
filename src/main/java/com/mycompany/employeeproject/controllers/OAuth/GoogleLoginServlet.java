package com.mycompany.employeeproject.controllers.OAuth;

import com.mycompany.employeeproject.model.Google2Api;
import com.mycompany.employeeproject.util.PropertiesReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

@WebServlet(name = "GoogleLoginServlet", urlPatterns = {"/googleLogin"})
public class GoogleLoginServlet extends HttpServlet {
    
   private static final String CLIENT_ID = PropertiesReader.getProperty("client_identifier"); 
   private static final String CLIENT_SECRET = PropertiesReader.getProperty("client_secret"); 

   @Override 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

      ServiceBuilder builder= new ServiceBuilder(); 
      OAuthService service = builder.provider(Google2Api.class) 
         .apiKey(CLIENT_ID) 
         .apiSecret(CLIENT_SECRET) 
         .callback("http://localhost:8080/EmployeeProject/oAuthCallback") 
         .scope("https://www.googleapis.com/auth/plus.login " + 
               "https://www.googleapis.com/auth/plus.me " +
               "https://www.googleapis.com/auth/userinfo.email")
         .build();
      

      HttpSession session = request.getSession(); 
      session.setAttribute("oauth2Service", service);

      response.sendRedirect(service.getAuthorizationUrl(null)); 
   }  
}
