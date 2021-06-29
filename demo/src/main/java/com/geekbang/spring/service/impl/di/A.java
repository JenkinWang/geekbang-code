package com.geekbang.spring.service.impl.di;

import org.springframework.context.annotation.Bean;

public class A {

    private B b;

    public A(B b) {
        this.b = b;
    }
}
