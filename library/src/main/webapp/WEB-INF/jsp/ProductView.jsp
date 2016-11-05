<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/5
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Product</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css"/>");
        /*
        上述将解析为两种情况：
        @import url("/css/main.css");
        @import url("/applicationContext/css/main.css");
        */

    </style>
</head>
<body>
    <div>
        <h5>${message}</h5>
    </div>
    <div id="global">
        <h4>The product has been saved.</h4>
        <p>
            <h5>Details:</h5>
            Product Name: ${product.name} <br/>
            Description: ${product.description} <br/>
            Price: ${product.price}
        </p>
    </div>
</body>
</html>
