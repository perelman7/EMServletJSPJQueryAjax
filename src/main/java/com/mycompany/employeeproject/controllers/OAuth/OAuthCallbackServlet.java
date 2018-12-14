package com.mycompany.employeeproject.controllers.OAuth;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

@WebServlet(name = "OAuthCallbackServlet", urlPatterns = {"/oAuthCallback"}, asyncSupported = true)
public class OAuthCallbackServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws IOException, ServletException {
      
      String error = req.getParameter("error"); 
      if (error != null && "access_denied".equals(error.trim())) { 
         HttpSession sess = req.getSession(); 
         sess.invalidate(); 
         resp.sendRedirect(req.getContextPath()); 
         return; 
      }

      //OK the user have consented so lets find out about the user 
      AsyncContext ctx = req.startAsync(); 
      ctx.start(new GetUserInfo(req, resp, ctx));
      resp.sendRedirect("/EmployeeProject/index.jsp");
   } 
}

class GetUserInfo implements Runnable {
    
   private HttpServletRequest req;
   private HttpServletResponse resp;
   private AsyncContext asyncCtx;
   
   public GetUserInfo(HttpServletRequest req, HttpServletResponse resp, AsyncContext asyncCtx) { 
      this.req = req; 
      this.resp = resp; 
      this.asyncCtx = asyncCtx; 
   }

   @Override 
   public void run() {  
      HttpSession sess = req.getSession(); 
      OAuthService service = (OAuthService)sess.getAttribute("oauth2Service");
      
      //Get the all important authorization code 
      String code = req.getParameter("code");
      
      //Construct the access token
      Token token = service.getAccessToken(null, new Verifier(code)); 

      sess.setAttribute("token", token);
      
      try { 
         req.login("fred", "fredfred"); 
      } catch (ServletException e) {}
      
      OAuthRequest oReq = new OAuthRequest(Verb.GET, "https://www.googleapis.com/userinfo/v2/me");
      service.signRequest(token, oReq); 
      Response oResp = oReq.send(); 

      //Read the result 
      JsonReader reader = Json.createReader(new ByteArrayInputStream( 
            oResp.getBody().getBytes())); 
      JsonObject profile = reader.readObject();
 
      sess.setAttribute("name", profile.getString("name")); 
      sess.setAttribute("email", profile.getString("email")); 

      asyncCtx.complete(); 
   }
}
