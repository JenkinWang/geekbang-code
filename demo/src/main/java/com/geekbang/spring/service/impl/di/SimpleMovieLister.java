package com.geekbang.spring.service.impl.di;

public class SimpleMovieLister {

    private MovieFinder movieFinder;

     // 第一种： 构造器注入方式
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    /*// 第二种： set属性值的方式注入
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }*/
}
