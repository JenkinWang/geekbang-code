package com.geekbang.spring.service.impl;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class DefaultServiceLocator {

    private static ClientService clientService = new ClientService();

    private static AccountService accountService = new AccountService();

    public ClientService createClientServiceInstance() {
        return clientService;
    }

    public AccountService createAccountServiceInstance() {
        return accountService;
    }
}
