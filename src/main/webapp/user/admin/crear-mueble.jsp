
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'ADMIN'}">
    <c:redirect url="/login"></c:redirect>
</c:if>


<jsp:include page="../../includes/header.jsp" />

<div class="container" style="padding-top: 150px; max-width: 1000px;">

    <form class="row g-3" method="POST" action="new-pieza">
        <h1>${edit ? 'Editar Pieza' : 'Registrar Pieza'}</h1>
        <div class="col-md-4">
            <label for="inputTipo" class="form-label">Nombre del Mueble</label>
            <input type="text" class="form-control" name="m_nombre" value="${requestScope.m_nombre}"}>
            <c:if test="${errores != null && not empty errores.m_nombre}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.m_nombre} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-2">
            <label for="inputCosto" class="form-label">Precio</label>
            <div class="input-group mb-3">
                <span class="input-group-text">Q</span>
                <input type="text" class="form-control" id="inputCosto" name="costo" value="${precio}">
            </div>
            <c:if test="${errores != null && not empty errores.precio}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.precio} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-2">
            <label for="inputCantidad" class="form-label">Cantidad</label>
            <input type="number" class="form-control" name="cantidad" value="1">
            <c:if test="${errores != null && not empty errores.cantidad}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.cantidad} </p>
                </div>
            </c:if>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">${edit ? 'Guardar Cambios' : 'Registrar Pieza'}</button>
        </div>
        <input type="hidden" name="edit" value="${edit}">   



    </form>

</div>
<jsp:include page="../../includes/footer.jsp" />