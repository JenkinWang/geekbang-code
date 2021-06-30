package com.geekbang.spring;

import com.geekbang.spring.entity.User;
import com.geekbang.spring.service.impl.AccountService;
import com.geekbang.spring.service.impl.di.A;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class SpringDemo {

    /**
     * {@link org.springframework.context.annotation.Configuration}
     * {@link org.springframework.context.annotation.Bean}
     * {@link org.springframework.context.annotation.Import}
     * {@link org.springframework.context.annotation.DependsOn}
     *  Beans that are singleton-scoped and set to be pre-instantiated (the default) are created when the container is created
     */


    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:user.xml");
        User user = (User) classPathXmlApplicationContext.getBean("user");
        System.out.println(user);

        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(genericApplicationContext).loadBeanDefinitions("factory-service.xml");
        genericApplicationContext.refresh();

        AccountService accountSerice = (AccountService) genericApplicationContext.getBean("accountService");
        System.out.println(accountSerice);

        // test circular dependencies
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("circular-dependencies.xml");
        A a = (A) context.getBean("a");

        // register shutdown hook
        ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("user.xml");
        configurableApplicationContext.registerShutdownHook();
    }
}
