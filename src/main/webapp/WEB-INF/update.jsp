<%@ page import="com.robot.bean.Message" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/8
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
    <link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
    <title>增加</title>

    <script type="text/javascript">
        function isNull(str) {
            if ( str == "" ) {
                return true;
            }
            var regu = "^[ ]+$";
            var re = new RegExp(regu);
            return re.test(str);
        }

        function check(){
            var command=window.document.getElementById("command").value;
            var description=window.document.getElementById("description").value;
            var content=window.document.getElementById("content").value;
            if (isNull(command)||isNull(description)||isNull(content)) // 或者是!nameValue
            {
                window.alert("不能为空!");
                return false;
            }
            return true;
        }
    </script>
    <style>
        #content{
            width:400px;
            height: 200px;
        }
    </style>
</head>
<body style="background: #e1e9eb; ">
<div class="cen">
<form action="/update.do" method="post"id="myform"  >

    <input type="text" name="ids" class="allInput"  value= "${message.id}"hidden="hidden" />
    指令： <input type="text" name="command" class="allInput" id="command" value= "${message.command}"/>
    描述： <input type="text" name="description" class="allInput" id="description" value= "${message.description}"/>
    回复：  <textarea  name="content" class="allInput" id="content" rows="10" cols="10">${message.content}</textarea>
    <input type="submit" name="submit" class="allInput" value="确认" onclick="return check()" />
</form>

</div>
</body>
</html>
