package com.geekbang.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 2021-07-07
 */
public class SetEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("encoding filter init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("encoding filter destroy...");
    }
}
