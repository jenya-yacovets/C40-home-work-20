<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Калькулятор</title>
    <jsp:include page="_includeLibsCss.jsp" />
</head>
<body>

<jsp:include page="_header.jsp" />

<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <br>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Число 1</th>
                    <th scope="col">Число 2</th>
                    <th scope="col">Операция</th>
                    <th scope="col">Результат</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="operation" items="${requestScope.allOperationUser}" >
                    <tr>
                        <th scope="row"><c:out value="${operation.id}" /></th>
                        <th scope="row"><c:out value="${operation.num1}" /></th>
                        <th scope="row"><c:out value="${operation.num2}" /></th>
                        <th scope="row"><c:out value="${operation.operation.nameUser}" /></th>
                        <th scope="row"><c:out value="${operation.result()}" /></th>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="_alert.jsp" />
<jsp:include page="_includeLibsJs.jsp" />
</body>
</html>