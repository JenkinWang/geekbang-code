package com.geekbang.web.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 2021-07-14
 */
public class ServletRequestConfigSource implements ConfigSource {

    private final ServletRequest servletRequest;

    private final String name;

    public ServletRequestConfigSource(ServletRequest servletRequest, String name) {
        this.servletRequest = servletRequest;
        this.name = name;
    }

    @Override
    public Map<String, String> getProperties() {
        return ConfigSource.super.getProperties();
    }

    @Override
    public Set<String> getPropertyNames() {
        return servletRequest.getParameterMap().keySet();
    }

    @Override
    public int getOrdinal() {
        return ConfigSource.super.getOrdinal();
    }

    @Override
    public String getValue(String s) {
        return servletRequest.getParameter(s);
    }

    @Override
    public String getName() {
        return name;
    }
}
