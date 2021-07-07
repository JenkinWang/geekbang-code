<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <%@taglib prefix="ct" uri="/WEB-INF/custom-tags.tld" %>

    <body>
        <table>
            <tr>

                <td><ct:UserInfo user="${user}" /></td>
            </tr>
        </table>
    </body>
</html>