<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактирование пароля</title>
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
                    <div class="col-md-12">
                        <div class="form-floating">
                            <input type="password" name="password" class="form-control" required id="floatingInputGrid">
                            <label for="floatingInputGrid">Старый пароль</label>
                        </div>
                    </div>
                    <div class="col-md-12 mt-2">
                        <div class="form-floating">
                            <input type="password" name="newPassword" class="form-control" required id="floatingInputGrid2">
                            <label for="floatingInputGrid2">Новый пароль</label>
                        </div>
                    </div>
                    <div class="d-grid gap-2 mt-2">
                        <button type="submit" width="100%" class="btn btn-warning btn-lg">Изменить пароль</button>
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