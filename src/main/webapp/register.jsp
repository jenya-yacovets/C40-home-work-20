<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Авторизация</title>
    <jsp:include page="_includeLibsCss.jsp" />
</head>
<body class="text-center">
<style>
    html,
    body {
        height: 100%;
    }

    body {
        display: flex;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }

    .form-signin {
        width: 100%;
        max-width: 330px;
        padding: 15px;
        margin: auto;
    }

    .form-signin .checkbox {
        font-weight: 400;
    }

    .form-signin .form-floating:focus-within {
        z-index: 2;
    }
    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
    }

    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
</style>

<main class="form-signin">
    <form method="post">

        <h1 class="h3 mb-3 fw-normal">Регистрация</h1>

        <div class="form-floating mb-1">
            <input type="text" class="form-control" id="nameInput" placeholder="Boris" name="name">
            <label for="nameInput">Имя</label>
        </div>
        <div class="form-floating mb-1">
            <input type="text" class="form-control" id="floatingInput" placeholder="Boris88" name="login">
            <label for="floatingInput">Логин</label>
        </div>
        <div class="form-floating mb-1">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Пароль" name="password">
            <label for="floatingPassword">Пароль</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Регистрация</button>
        <p class="mt-5 mb-3 text-muted">Есть аккаунт? <a href="/authorization">Авторизация</a> </p>
    </form>

    <p class="mt-5 mb-3 text-muted">© 2021</p>
</main>

<jsp:include page="_alert.jsp" />
<jsp:include page="_includeLibsJs.jsp" />
</body>
</html>
