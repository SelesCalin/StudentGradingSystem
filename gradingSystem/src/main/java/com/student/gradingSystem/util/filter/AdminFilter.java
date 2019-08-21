package com.student.gradingSystem.util.filter;

import com.student.gradingSystem.domain.entity.enumeration.RoleType;
import com.student.gradingSystem.service.session.Session;
import com.student.gradingSystem.util.SessionUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String token = httpServletRequest.getHeader("token");
        Session session = SessionUtil.getSession(token);
        if (session == null ) {
            httpServletResponse.sendError(401);
            return;
        } else if(session.isExpired()) {
            httpServletResponse.sendError(401);
            return;
        }else if (session.getUserRole() != RoleType.ADMIN) {
                 SessionUtil.invalidateSession(token);
                httpServletResponse.sendError(403);
                return;
            }
        else{
            filterChain.doFilter(request,response);}

    }
}
