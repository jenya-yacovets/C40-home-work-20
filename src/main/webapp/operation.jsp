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
                <form action="" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="number" name="num1" class="form-control" required id="floatingInputGrid" placeholder="10">
                                <label for="floatingInputGrid">Число 1</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="number" name="num2" class="form-control" required id="floatingInputGrid2" placeholder="5">
                                <label for="floatingInputGrid2">Число 2</label>
                            </div>
                        </div>
                        <div class="col-md-12 mt-2">
                            <div class="form-floating">
                                <select name="method" class="form-select" id="floatingSelectGrid" required>
                                    <c:forEach var="operation" items="${requestScope.operations}" >
                                        <option value="<c:out value="${operation.nameParam}" />"><c:out value="${operation.nameUser}" /></option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelectGrid">Операция с числами</label>
                            </div>
                            <div class="d-grid gap-2 mt-2">
                                <button type="submit" width="100%" class="btn btn-success btn-lg">Посчитать</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="_alert.jsp" />
    <jsp:include page="_includeLibsJs.jsp" />
</body>
</html>