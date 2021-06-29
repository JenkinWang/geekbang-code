package com.geekbang.spring.service.impl.di;

import java.beans.ConstructorProperties;

public class ExampleBean {

    private final int years;

    private final String ultimateAnswer;

    @ConstructorProperties({"years", "ultimateAnswer"})
    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
