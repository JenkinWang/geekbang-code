package com.geekbang.spring.bean;

import org.springframework.beans.factory.InitializingBean;

public class AnotherExampleBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // do some initialization work
    }
}
