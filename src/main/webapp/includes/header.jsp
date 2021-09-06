<%-- 
    Document   : sidebar
    Created on : 31/08/2021, 00:23:30
    Author     : Manu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${sessionScope.username == null}">
    <c:redirect url="/index.jsp"></c:redirect>
</c:if>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/includes/resources.jsp" />
        <title>Mi Mueblería</title>
    </head>

    <style>

        .barra {
            display: flex;
            flex-wrap: nowrap;
            height: 100vh;
            height: -webkit-fill-available;
            max-height: 100vh;
            overflow-x: auto;
            overflow-y: hidden;
        }
    </style>
    <body>
        <div class="barra">
            <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
                <a href="${pageContext.request.contextPath}/login" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <span class="fs-4">Mi Mueblería</span>
                </a>
                <hr>
                <!-- OPCIONES PARA EL ADMINISTRADOR -->
                <c:if test="${sessionScope.userRole == 'ADMIN'}">
                    <ul class="nav nav-pills flex-column mb-auto">
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/user/admin/crear-usuario.jsp" class="nav-link text-white">
                                Crear Usuario
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/admin/crear-mueble.jsp" class="nav-link text-white">
                                Crear Mueble
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/admin/control" class="nav-link text-white">
                                Control de Usuarios
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-white">
                                Reportes
                            </a>
                        </li>
                    </ul> 
                </c:if>

                <!-- OPCIONES PARA EL FABRICANTE -->
                <c:if test="${sessionScope.userRole == 'FABRICANTE'}">
                    <ul class="nav nav-pills flex-column mb-auto">
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/user/fabricante/crear-pieza.jsp" class="nav-link text-white">
                                Registrar Pieza
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas" class="nav-link text-white">
                                Inventario de Piezas
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-white">
                                Inventario de Muebles
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-white">
                                Ensamble de Muebles
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-white">
                                Registrar Muebles
                            </a>
                        </li>
                    </ul> 
                </c:if>

                <!-- OPCIONES PARA EL VENDEDOR -->
                <c:if test="${sessionScope.userRole == 'VENDEDOR'}">
                    <ul class="nav nav-pills flex-column mb-auto">
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/user/admin/crear-usuario.jsp" class="nav-link text-white">
                                Crear Usuario
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-white">
                                Crear Mueble
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-white">
                                Control de Usuarios
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-white">
                                Reportes
                            </a>
                        </li>
                    </ul> 
                </c:if>

                <hr>
                <div class="dropdown">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="${pageContext.request.contextPath}/resources/images/login.png" alt="" width="32" height="32" class="rounded-circle me-2">
                        <strong>${sessionScope.username}</strong>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                        <li class="dropdown-item">Rol: ${sessionScope.userRole}</li>
                        <li class="dropdown-item">Estado: ${sessionScope.userState ? "ACTIVO" : "CANCELADO"}</li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a></li>
                    </ul>
                </div>
            </div>
            <div class="col py-3">