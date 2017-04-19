<%--
  Created by IntelliJ IDEA.
  User: coldplay
  Date: 17-4-18
  Time: 下午11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>signin</title>
    <meta charset="utf-8">
</head>
<body>
<center>
    <form onsubmit="return checkall(this)" action="/SignAbout" name="signin" method="POST">
        username: <input type="text" name="username">
        <br>
        password: <input type="password" name="password">
        <br>
        <input type="hidden" name="method" value="signin">
        <input type="submit">
    </form>
</center>
<a href="index.html">back</a>
<script type="text/javascript">
    function checkall(f) {
        if (f.username.value == null || f.password.value == null) {
            alert("请填写完整！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
