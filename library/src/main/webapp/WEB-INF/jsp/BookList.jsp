<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/6
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--部分JSP页面禁用EL表达式--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Book List</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css"/>");
    </style>
</head>
<body>
<div id="global">
    Current Locale: ${pageContext.response.locale}
    <h1>Book List</h1>
    <h1><spring:message code="book.list.title"/></h1>
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

    <div>
        <h2>JSTL Examples:</h2>
        <p><c:out value="${cookie.JSESSIONID.value}" default="defaultValue"/></p>
        <p><c:out value="${cookie.JSESSIONID.path}" default="defaultValue"/></p>
        <p><c:set var="foo" value="Hello World"/></p>
        <p><c:out value="${foo}"/></p>
        <p><c:set var="foo2">Hello World2</c:set></p>
        <p><c:out value="${foo2}"/></p>
        <p><c:set target="${bookForJSTL}" property="author" value="LiuJinlong"/></p>
        <p><c:set target="${bookForJSTL}" property="isbn">11-22-665302-2335</c:set></p>
        <p><c:out value="${bookForJSTL.title}"/></p>
        <p><c:out value="${bookForJSTL.author}"/></p>
        <p><c:out value="${bookForJSTL.isbn}"/></p>
        <p><c:remove var="foo"/></p>
        <p>After foo deleted:<c:out value="${foo}"/></p>

        <p><c:if test="${2>1}" var="testResult"/></p>
        <p><c:out value="${testResult}"/></p>

        <p><c:if test="${testResult}" var="testResult"> The result is true!  </c:if></p>
        <p>
            <%--只有一种选择，各个when相互排斥--%>
            <c:choose>
                <c:when test="${2 > 2}">
                    Case 1
                </c:when>
                <c:when test="${3 > 3}">
                    Case 2
                </c:when>
                <c:otherwise>
                    Other case
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            <%--varStatus count属性用于循环计数 --%>
            <c:forEach var="book" items="${books}" varStatus="status">
                <c:if test="${status.count%2 !=0}">${status.count}</c:if>
                <c:out value="${book.title}"/><br/>
            </c:forEach>
        </p>
        <p>
            <c:forTokens var="item" items="Liu,Tian,Wang,Ma,Zhao" delims=",">
                <c:out value="${item}"/><br/>
            </c:forTokens>
        </p>
        <p><fmt:formatNumber value="0.125" type="percent"/></p>
        <p><fmt:formatDate type="both" value="${bookForJSTL.publishDate}" pattern="yyyy-MM-dd"/></p>
        <fmt:timeZone value="GMT+12:00">
            <p><fmt:formatDate type="both" value="${bookForJSTL.publishDate}" pattern="yyyy-MM-dd"/></p>
        </fmt:timeZone>
        <p><c:set var="myDate" value="2016/12/12"/></p>
        <p><fmt:parseDate var="formattedDate" type="date" pattern="yyyy/MM/dd" value="${myDate}"/></p>

        <p>${fn:contains(bookForJSTL.title, "Test")}</p>
        <p>${fn:containsIgnoreCase(bookForJSTL.title, "TEST")}</p>
        <p>${fn:endsWith(bookForJSTL.title, "TEST")}</p>
        <p>${fn:endsWith(bookForJSTL.title, "Test")}</p>
        <p>${fn:length(bookForJSTL.title)}</p>
        <p>${fn:replace(bookForJSTL.title, "Test", "TEST")}</p>
        <p>${fn:toLowerCase(bookForJSTL.title)}</p>
        <p>${fn:toUpperCase(bookForJSTL.title)}</p>
        <p>${fn:trim("    Hello World!    ")}</p>
    </div>
</div>
<script type="text/javascript">
    console.log("Hello World");
</script>
</body>
</html>
