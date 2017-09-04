<%--
  Created by IntelliJ IDEA.
  User: longjinwen
  Date: 2017/3/18
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test js</title>
    <script>
//        for(var i = 0 ;i< 5;i++){
//            document.write(i);
//        }
//        alert(i); //print 5 最后还是会+1
(function () {
    window.jw = {
        show :function (name, age) {
            document.write("my name is"+name+",I am "+age);
        }
    }
    
})();
    </script>
</head>
<body>
<h1>HI  This is js test Page</h1>
<a href="test1?method=test1&topid=1">test1</a><br>
<a href="test2?method=test2">test2</a>
</body>
</html>
