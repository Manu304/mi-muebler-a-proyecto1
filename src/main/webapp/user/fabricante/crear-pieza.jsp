
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'FABRICANTE'}">
    <c:redirect url="/login"></c:redirect>
</c:if>


<jsp:include page="../../includes/header.jsp" />

<div class="container" style="padding-top: 150px; max-width: 1000px;">

    <form class="row g-3" method="POST" action="new-pieza">
        <h1>${edit ? 'Editar Pieza' : 'Registrar Pieza'}</h1>
        <div class="col-md-4">
            <label for="inputTipo" class="form-label">Tipo de Pieza</label>
            <input type="text" class="form-control" name="tipo_pieza" value="${requestScope.tipo_pieza}"}>
            <c:if test="${errores != null && not empty errores.tipo}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.tipo} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-2">
            <label for="inputCosto" class="form-label">Costo</label>
            <div class="input-group mb-3">
                <span class="input-group-text">Q</span>
                <input type="text" class="form-control" id="inputCosto" name="costo" value="${costo}">
            </div>
            <c:if test="${errores != null && not empty errores.costo}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.costo} </p>
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
