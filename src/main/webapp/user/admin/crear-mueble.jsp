
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'ADMIN'}">
    <c:redirect url="/login"></c:redirect>
</c:if>


<jsp:include page="../../includes/header.jsp" />

<div class="container" style="padding-top: 150px; max-width: 1000px;">

    <form class="row g-3" method="POST" action="new-mueble">
        <h1>${edit ? 'Editar Mueble' : 'Crear Mueble'}</h1>
        <div class="col-md-4">
            <label for="inputNombre" class="form-label">Nombre del Mueble</label>
            <input type="text" class="form-control" name="m_nombre" value="${requestScope.m_nombre}"}>
            <c:if test="${errores != null && not empty errores.m_nombre}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.m_nombre} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-2">
            <label for="inputPrecio" class="form-label">Precio</label>
            <div class="input-group mb-3">
                <span class="input-group-text">Q</span>
                <input type="text" class="form-control" id="inputCosto" name="precio" value="${precio}">
            </div>
            <c:if test="${errores != null && not empty errores.precio}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.precio} </p>
                </div>
            </c:if>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">${edit ? 'Guardar Cambios' : 'Crear Mueble'}</button>
        </div>
        <input type="hidden" name="edit" value="${edit}">   



    </form>

</div>
<jsp:include page="../../includes/footer.jsp" />