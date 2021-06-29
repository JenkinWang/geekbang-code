package com.geekbang.spring;

import com.geekbang.spring.entity.User;
import com.geekbang.spring.service.impl.AccountService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
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
     *
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
    }
}
