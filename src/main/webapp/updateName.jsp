<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Редактирование имени</title>
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
              <input type="text" name="name" class="form-control" required id="floatingInputGrid" placeholder="10">
              <label for="floatingInputGrid">Новое имя</label>
            </div>
          </div>
            <div class="d-grid gap-2 mt-2">
              <button type="submit" width="100%" class="btn btn-info btn-lg">Изменить имя</button>
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