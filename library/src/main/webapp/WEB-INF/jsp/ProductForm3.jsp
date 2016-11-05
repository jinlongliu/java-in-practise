<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/5
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>保存产品</title>
    <style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div>
    <c:if test="${requestScope.errors != null}">
        <p id="errors">
            <h4>Errors!</h4>
            <ul>
                <c:forEach var="error" items="${requestScope.errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </p>
    </c:if>
    <form action="product_save" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name:</label>
                <input type="text" id="name" name="name" tabindex="1" value="${product.name}">
            </p>
            <p>
                <label for="description">Description:</label>
                <input type="text" id="description" name="description"
                       tabindex="2" value="${product.description}">
            </p>
            <p>
                <label for="price">Price</label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>