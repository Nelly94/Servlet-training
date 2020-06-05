package com.myapp.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if(path.contains("/error")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            if(servletRequest instanceof HttpServletRequest){
                HttpSession session = ((HttpServletRequest) servletRequest).getSession();
                if(session.getAttribute("logged") != null){
                    filterChain.doFilter(servletRequest,servletResponse);
                }else{
                    ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/error");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
