package com.geekbang.web.entity;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 2021-07-07
 */
public class UserInfo {

    private String userName;

    private String location;

    public UserInfo(String userName, String location) {
        this.userName = userName;
        this.location = location;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "I'm " + userName + ". I'm from " + location;
    }
}
