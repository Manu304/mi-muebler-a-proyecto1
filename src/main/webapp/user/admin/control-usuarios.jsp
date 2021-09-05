
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'ADMIN'}">
    <c:redirect url="/login"></c:redirect>
</c:if>
<jsp:include page="../../includes/header.jsp" />

<div class="container" style="padding-top: 150px; max-width: 1000px;">

    <h1>Control de Usuarios Registrados</h1>

    <table class="table table-dark table-striped">
        <thead>
            <tr>
                <th scope="col">Usuario</th>
                <th scope="col">Tipo Area</th>
                <th scope="col">Estado</th>
                <th scope="col">Editar</th>
                <th scope="col">Cancelar</th>
                <th scope="col">Eliminar</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="u">
                <tr>
                    <th scope="row">${u.nombre}</th>
                    <td>${u.rol}</td>
                    <td>${u.activo ? 'ACTIVO' : 'CANCELADO'}</td>


                    <c:choose>
                        <c:when test="${sessionScope.username == u.nombre}">
                            <td><a role="button" class="btn btn-info disabled">EDITAR</a></td>
                            <td><a role="button" class="btn btn-warning disabled">CANCELAR</a></td>
                            <td><a role="button" class="btn btn-danger disabled">ELIMINAR</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a role="button" class="btn btn-info" href="${pageContext.request.contextPath}/user/admin/new-user?username=${u.nombre}&tipo=${u.tipo}&edit=true">EDITAR</a></td>
                            <td><a role="button" class="btn btn-${u.activo ? 'warning' : 'success'}" href="${pageContext.request.contextPath}/user/admin/cancelar?user=${u.nombre}">${u.activo ? 'CANCELAR' : 'ACTIVAR'}</a></td>        
                            <td><a role="button" class="btn btn-danger" href="${pageContext.request.contextPath}/user/admin/delete?user=${u.nombre}">ELIMINAR</a></td>
                        </c:otherwise>
                    </c:choose>


                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
<jsp:include page="../../includes/footer.jsp" />
