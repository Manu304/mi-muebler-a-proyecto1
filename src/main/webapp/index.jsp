<%-- 
    Document   : index
    Created on : 27/08/2021, 15:23:10
    Author     : Manu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/includes/resources.jsp" />
        <title>Mi Mueblería</title>
    </head>
    <body class="container ">
        <div class="card mb-3">
            <img src="${pageContext.request.contextPath}/resources/images/madera.jpg" class="card-img-top" alt="Mi Muebleria" width="720" height="480">
            <div class="card-body">
                <h3 class="card-title">Bienvenido a Mi Mueblería</h3>
                <p class="card-text">Para ingresar al sistema, por favor inicie sesión primero</p>
                <a role="button" class="btn btn-info" href="${pageContext.request.contextPath}/login.jsp"><h3> Iniciar Sesión</h3></a>
            </div>
        </div>
        


    </body>

</html>