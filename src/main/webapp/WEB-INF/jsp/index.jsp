<%--
  Created by IntelliJ IDEA.
  User: longjinwen
  Date: 2017/2/8
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script  type="text/javascript" src="../js/jquery/jquery-1.8.3.min.js"></script>
    <script>
        function test() {
           $.ajax({
               url:'getTest',
               type:'post',
               success:function (e) {
                   console.log(e);
                   alert(e);
               }

           })
        }

    </script>
</head>
<body>
test JS<br>
 <a href="test">testJs</a>
<hr>
    <form action="login" method="post">
    用户名：<input type="text" value="" name="username">
        密码：<input type="password" value="" name="passwd">
        <input type="submit" value="提交">
    </form>

<form  name="form2" action="login" method="post">
    选择表：
    <select name="" onclick="test()">
        <option>1</option>
        <option>2</option>
    </select>
    <%--<input type="text" value="" name="tableName" >--%>

</form>



</body>
</html>
