package com.geekbang.web;

import com.geekbang.web.filter.EncodingFilter;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class CustomServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("-----------------------------------------");
        System.out.println("custom servlet container initializer...");

        // 增加过滤器
        ctx.addFilter("encoding-filter", EncodingFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");

        // TODO: 增加监听器

        // 增加 custom servlet
        ctx.addServlet("week1", "com.geekbang.web.servlet.CustomServlet")
                .addMapping("/week-1");

        // 增加 index servlet
        ctx.addServlet("index", "com.geekbang.web.servlet.IndexServlet")
                .addMapping("/index");

        System.out.println("-----------------------------------------");
    }
}
