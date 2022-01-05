package com.dragonlin.hanashopapi.handlers;

import com.dragonlin.hanashopapi.beans.JwtCustomBean;
import com.dragonlin.hanashopapi.constants.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestHandler implements HandlerInterceptor {
    @Autowired
    JwtCustomBean jwtCustomBean;
    @Value("${host.frontend.uri}")
    String hostFrontend;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", hostFrontend);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.addHeader("Access-Control-Expose-Headers", StringConstant.AUTH_TOKEN);

        // localhost:8080/authen/login
        if (!request.getServletPath().contains("auth")) {
            return true;
        }
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        if (!StringUtils.hasLength(request.getHeader(StringConstant.AUTH_TOKEN))) {
            response.sendError(403);
            return false;
        }
        String token = request.getHeader(StringConstant.AUTH_TOKEN);
        boolean isValidToken = jwtCustomBean.validateJwtToken(token);
        if (!isValidToken) {
            response.sendError(403);
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
    }
}
