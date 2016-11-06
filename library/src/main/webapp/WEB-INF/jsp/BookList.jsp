<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/6
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css"/>");
    </style>
</head>
<body>
<div id="global">
    <h1>Book List</h1>
    <a href="<c:url value="/book_input"/> ">Add Book</a>
    <table>
        <tr>
            <th>Category</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Author</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.category.name}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td><a href="book_edit/${book.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <h2>EL Examples：</h2>
        <p>${pageContext.request}</p>
        <p>${initParam}</p>
        <p>${pageContext.request.method}</p>
        <p>${param}</p>
        <p>${paramValues}</p>
        <p>${paramValues.param1[1]}</p>
        <p>${header}</p>
        <p>${cookie}</p>
        <p>${cookie.JSESSIONID.value}</p>
        <p>${3>1?cookie:cookie.JSESSIONID.value}</p>
        <p>${3>5?cookie:cookie.JSESSIONID.value}</p>
        <p>${empty cookie}</p>
        <p>${empty initParam}</p>
    </div>
    <%--JSP脚本元素--%>
    <%! String color[] = {"red", "green", "blue"}; %>
</div>
<script type="text/javascript">
    console.log("Hello World");
</script>
</body>
</html>
