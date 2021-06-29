package com.geekbang.spring.service.impl;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class ClientService {
    private static ClientService clientService = new ClientService();

    public static ClientService createInstance() {
        return clientService;
    }
}
