package org.hackathon.aidtracker.auth.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    //(httpServletRequest, httpServletResponse, e) -> {
    //                    httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
    //                    PrintWriter writer = httpServletResponse.getWriter();
    //                    writer.println(e.getMessage());}
    //todo
    // log the ip and user of all forbidden request
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        accessDeniedException = new AccessDeniedException("Sorry you don not enough permissions to access it!");
        response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
    }
}
