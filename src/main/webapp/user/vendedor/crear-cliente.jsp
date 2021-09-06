
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'VENDEDOR'}">
    <c:redirect url="/login"></c:redirect>
</c:if>


<jsp:include page="../../includes/header.jsp" />

<div class="container" style="padding-top: 150px; max-width: 1000px;">

    <form class="row g-3" method="POST" action="new-cliente">
        <h1>${edit ? 'Editar Cliente' : 'Crear Cliente'}</h1>
        <div class="col-md-4">
            <label for="inputNit" class="form-label">NIT</label>
            <input type="text" class="form-control" name="nit" value="${requestScope.nit}" ${edit ? 'readonly' : ''}>
            <c:if test="${errores != null && not empty errores.nit}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.nit} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-8">
            <label for="inputNombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="inputNombre" name="c_nombre">
            <c:if test="${errores != null && not empty errores.c_nombre}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.c_nombre} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-12">
            <label for="inputDireccion" class="form-label">Dirección</label>
            <input type="text" class="form-control" id="inputDireccion" name="direccion">
            <c:if test="${errores != null && not empty errores.direccion}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.direccion} </p>
                </div>
            </c:if>
        </div>

        <div class="col-md-6">
            <label for="inputDireccion" class="form-label">Municipio</label>
            <input type="text" class="form-control" id="inputDireccion" name="direccion">
            <c:if test="${errores != null && not empty errores.direccion}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.direccion} </p>
                </div>
            </c:if>
        </div>

        <div class="col-md-6">
            <label for="inputDireccion" class="form-label">Departamento</label>
            <input type="text" class="form-control" id="inputDireccion" name="direccion">
            <c:if test="${errores != null && not empty errores.direccion}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.direccion} </p>
                </div>
            </c:if>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">${edit ? 'Guardar Cambios' : 'Registrar Cliente'}</button>
        </div>
        <c:if test="${edit}">
            <input type="hidden" name="edit" value="${edit}">

        </c:if>


    </form>

</div>
<jsp:include page="../../includes/footer.jsp" />
