package com.geekbang.spring.service.impl;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class AccountService {
    private static AccountService accountService = new AccountService();

    public static AccountService createInstance() {
        return accountService;
    }
}
