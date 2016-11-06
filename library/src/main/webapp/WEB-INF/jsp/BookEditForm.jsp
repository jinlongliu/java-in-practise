<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/6
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book Form</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css"/>");
    </style>
</head>
<body>
<div id="global">
    <%-- commandName 模型属性的名称 --%>
    <%--action的值得相对路径位置需要注意--%>
    <form:form commandName="book" action="/book_update" method="post">

        <fieldset>
            <legend>Edit a book</legend>
            <%--隐藏参数作为控制器查询的依据--%>
            <form:hidden path="id"/>
            <p>
                <label for="category">Category:</label>
                <form:select id="category" path="category.id" items="${categories}" itemLabel="name"
                             itemValue="id"/>
            </p>
            <p>
                <label for="title">Title:</label>
                <form:input id="title" path="title"/>
            </p>
            <p>
                <label for="author">Author:</label>
                <form:input id="author" path="author"/>
            </p>
            <p>
                <label for="isbn">ISBN:</label>
                <form:input id="isbn" path="isbn"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Update Book">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
