package com.mycompany.employeeproject.controllers.OAuth;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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

@WebServlet(name = "OAuthCallbackServlet", urlPatterns = {"/oAuthCallback"})
public class OAuthCallbackServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String error = req.getParameter("error");
        HttpSession session = req.getSession();
        if (error != null && "access_denied".equals(error.trim())) {
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
            return;
        }
        OAuthService service = (OAuthService) session.getAttribute("oauth2Service");
        String code = req.getParameter("code");

        Token token = service.getAccessToken(null, new Verifier(code));
        session.setAttribute("token", token);

        OAuthRequest oReq = new OAuthRequest(Verb.GET, "https://www.googleapis.com/userinfo/v2/me");
        service.signRequest(token, oReq);
        Response oResp = oReq.send();

        JsonReader reader = Json.createReader(new ByteArrayInputStream(
                oResp.getBody().getBytes()));
        JsonObject profile = reader.readObject();

        session.setAttribute("name", profile.getString("name"));
        session.setAttribute("email", profile.getString("email"));
        resp.sendRedirect("/EmployeeProject/index.jsp");
    }
}