<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/6
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%--引入JSTL标签库和表单标签库--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book Form</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css"/>");
    </style>
</head>
<body>
<div id="global">
<%-- commandName 模型属性的名称 --%>
    <%--与BookController中saveBook的参数绑定--%>
<form:form commandName="book" action="book_save" method="post">

    <fieldset>
        <legend>Add a book</legend>
        <p>
            <label for="category">Category:</label>
            <%--categories为后端传递过来的对象List--%>
            <form:select id="category" path="category.id" items="${categories}" itemLabel="name"
            itemValue="id"/>
        </p>
        <p>
            <form:errors path="title"/>
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
            <input id="submit" type="submit" tabindex="5" value="Add Book">
        </p>
    </fieldset>

    <%--以下注释部分为所有表单标签示例--%>
    <%--path 指向的为属性 --%>
<%--    <form:input id="isbn" path="isbn" cssErrorClass="errorBox"/>
    <form:password id="pwd" path="password" cssClass="normal"/>
    <form:hidden id="id" path="id"/>
    <form:textarea path="note" tabindex="4" rows="5" cols="80"/>
    <form:checkbox path="isSellOut" value="Sell Out"/>
    On <form:radiobutton path="status" value="On"/> <br/>
    Off <form:radiobutton path="status" value="Off"/>
    &lt;%&ndash;items input元素对象的Collection, Map, Array&ndash;%&gt;
    <form:checkboxes path="category" items="${categoryList}"/>
    <form:radiobuttons path="language" items="${languageList}"/>
    <form:select id="owner" path="owner" items="${categoryies}" itemLabel="name" itemValue="id">
        <form:option value="0" label="-- Please select --"/>
    </form:select>
    <form:errors path="*"/>
    <form:errors path="isbn"/>--%>
</form:form>
</div>
</body>
</html>
