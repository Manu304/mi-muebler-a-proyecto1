
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'FABRICANTE'}">
    <c:redirect url="/login"></c:redirect>
</c:if>


<jsp:include page="../../includes/header.jsp" />
<div class="container" style="padding-top: 150px; max-width: 1000px;">

    <h1>Inventario de piezas</h1>
    <c:choose>
        <c:when test="${not empty piezas}">

            <div class="dropdown text-lg-end">
                <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    Ordenar piezas por
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=1&asc=true">Tipo: Ascendente (A-Z)</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=1&asc=false">Tipo: Descendente (Z-A)</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=2&asc=true">Costo: de más bajo a más alto</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=2&asc=false">Costo: de más alto a más bajo</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=3&asc=true">Cantidad: de más bajo a más alto</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=3&asc=false">Cantidad: de más alto a más bajo</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=4&asc=true">ID: de más bajo a más alto</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/fabricante/inventario-piezas?col=4&asc=false">ID: de más alto a más bajo</a></li>
                </ul>
            </div>

            <table class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Tipo de Pieza</th>
                        <th scope="col">Costo</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${piezas}" var="u">
                        <tr style="${u.cantidad == 0 ? 'color: #dc3545;':''} ${u.cantidad > 0 and u.cantidad < 11 ? 'color: #fd7e14;':''}">
                            <th scope="row">${u.id}</th>
                            <td>${u.tipo}</td>
                            <td>Q. ${u.costo}</td>
                            <td>${u.cantidad}</td>
                            <td><a role="button" class="btn btn-info" href="${pageContext.request.contextPath}/user/fabricante/new-pieza?id=${u.id}&edit=true">EDITAR</a></td>
                            <td><a role="button" class="btn btn-danger" href="${pageContext.request.contextPath}/user/fabricante/eliminar-pieza?id=${u.id}">ELIMINAR</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h2>No hay piezas registradas</h2>
            <p>Si desea registrar una pieza haga
                <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/user/fabricante/crear-pieza.jsp">Click Aquí</a>
            </p>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="../../includes/footer.jsp" />
