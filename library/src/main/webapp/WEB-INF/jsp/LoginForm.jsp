<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/7
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <form:form commandName="login" action="login" method="post">
        <fieldset>
            <legend><spring:message code="login.title"/></legend>
            <p>
                <label for="userName"><spring:message
                        code="login.label.username"/></label>
                <form:input path="userName" id="userName"
                            cssErrorClass="error"/>
            </p>
            <p>
                <label for="password"><spring:message
                        code="login.label.password"/></label>
                <form:password path="password" id="password"
                               cssErrorClass="error"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="<spring:message code="login.label.btn.submit"/>">
            </p>
        </fieldset>
    </form:form>
</div>

</body>
</html>
