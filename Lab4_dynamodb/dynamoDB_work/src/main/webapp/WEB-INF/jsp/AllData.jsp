<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 04.11.2020
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список сообщений</title>
</head>
<body>

    <p>Список сообщений</p>
        <c:forEach var="d" items="${allData}">
            <p></p><c:out value="${d.getTextMessage()}"/></p>
        </c:forEach>


</body>
</html>
