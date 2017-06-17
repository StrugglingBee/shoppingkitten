
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <div style="display: flex;justify-content: center;">
    <form action="login.do" method="post">
      <label>账号：</label>
      <input type="text" name="account">
      <br/>
      <label>密码：</label>
      <input type="password" name="pwd">
      <br/>
      <input type="submit" value="登录">
    </form>

  </div>
  </body>
</html>
