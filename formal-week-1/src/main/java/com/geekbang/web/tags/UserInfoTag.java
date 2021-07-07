package com.geekbang.web.tags;

import com.geekbang.web.entity.UserInfo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 2021-07-07
 */
public class UserInfoTag extends SimpleTagSupport {

    private UserInfo user;

    // setter 方法不能少
    public void setUser(UserInfo user) {
        this.user = user;
    }

    @Override
    public void doTag() throws JspException, IOException {
        user = new UserInfo("jenkin", "中国安徽省");

        JspWriter out = getJspContext().getOut();
        out.print(user);
        super.doTag();
    }
}
