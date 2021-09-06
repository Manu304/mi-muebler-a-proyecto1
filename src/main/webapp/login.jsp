<%-- Document : login.jsp Created on : 24/08/2021, 23:39:05 Author : Manu --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<c:if test="${sessionScope.username != null && sessionScope.userState == true}">
    <c:redirect url="/login"></c:redirect>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/includes/resources.jsp" />
        <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
        <title>Inicio de Sesión</title>    
    </head>

    <body class="text-center">
        <div class="contenedor">
            <form action="login" method="POST">
                <img class="mb-4" src="${pageContext.request.contextPath}/resources/images/login.png" alt="" width="90" height="90">
                <h1 class="h3 mb-3 fw-normal">Inicio de Sesión</h1>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="admin" name="username">
                    <label for="floatingInput">Usuario</label>

                </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Contraseña"
                           name="password">
                    <label for="floatingPassword">Contraseña</label>
                </div>

                <button class="w-100 btn btn-lg btn-primary" type="submit" value="iniciar-sesion">
                    Iniciar Sesión
                </button>

                <c:if test="${requestScope.error != null}">
                    <div class="fs-6" style="color: red;">
                        <p style="font-size: 14px"> ${error} </p>
                    </div>
                </c:if>
            </form>
        </div>
    </body>
</html>