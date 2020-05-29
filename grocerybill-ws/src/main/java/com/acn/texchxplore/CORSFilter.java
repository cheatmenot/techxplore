package com.acn.texchxplore;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader(
                "Access-Control-Allow-Headers",
                "Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Content-Type, userID, Access-Control-Request-Method, Access-Control-Request-Headers");
        response.setHeader("Content-Type", "application/json");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //no implementation yet
        //must be studied first
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        //no implementation yet
        //must be studied first
    }


}
