<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
  .fixedAlert {
    position: fixed;
    bottom: 0;
    right: 15px;
  }
</style>

<c:if test="${requestScope.message != null && requestScope.message.type.name() == 'WARN'}">
  <div class="alert alert-warning alert-dismissible fade show fixedAlert" role="alert">
    <strong>Ошибка!</strong> ${requestScope.message.message}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</c:if>

<c:if test="${requestScope.message != null && requestScope.message.type.name() == 'INFO'}">
  <div class="alert alert-info alert-dismissible fade show fixedAlert" role="alert">
    <strong>Успешно!</strong> ${requestScope.message.message}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</c:if>