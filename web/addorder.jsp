<%--
  Created by IntelliJ IDEA.
  User: coldplay
  Date: 17-4-19
  Time: 上午8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>add order</title>
    <meta charset="utf-8">
</head>
<body>
<center>
    <h1>add order</h1>
    <form onsubmit="return checkall(this)" action="/HandlersAbout" name="addorder" method="POST">
        fromuser: <input type="text" name="fromuser">
        <br>
        fromphonenum: <input type="text" name="fromphonenum">
        <br>
        fromaddress: <input type="text" name="fromaddress">
        <br>
        touser: <input type="text" name="touser">
        <br>
        tophonenum: <input type="text" name="tophonenum">
        <br>
        toaddress: <input type="text" name="toaddress">
        <br>
        <input type="hidden" name="handlers" value="addorder">
        <input type="submit" name="addorder">
    </form>
</center>
<a href="index.html">back</a>

<script type="text/javascript">
    function checkall(f) {
        if (f.fromuser.value == null || f.fromphonenum.value == null || f.fromaddress == null || f.touser.value == null || f.tophonenum == null || f.toaddress == null) {
            alert("please input right!");
            return false;
        }
        return true;
    }
</script>
</body>
</html>