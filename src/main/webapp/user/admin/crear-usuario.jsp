
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'ADMIN'}">
    <c:redirect url="/login"></c:redirect>
</c:if>


<jsp:include page="/user/admin/index.jsp" />

<div class="container" style="padding-top: 150px; max-width: 1000px;">

    <form class="row g-3" method="POST" action="new-user">
        <h1 class="display-1">${edit ? 'Editar Usuario' : 'Crear Usuario'}</h1>
        <div class="col-md-4">
            <label for="inputUsername4" class="form-label">Nombre de Usuario</label>
            <input type="text" class="form-control" name="username" value="${requestScope.username}" ${edit ? 'readonly' : ''}>
            <c:if test="${errores != null && not empty errores.username}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.username} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-4">
            <label for="inputPassword4" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="inputPassword4" name="password">
            <c:if test="${errores != null && not empty errores.password}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.password} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-4">
            <label for="inputPassword4" class="form-label">Confirmar Contraseña</label>
            <input type="password" class="form-control" id="inputPassword4" name="passwordConfirm">
            <c:if test="${errores != null && not empty errores.cpassword}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.cpassword} </p>
                </div>
            </c:if>
        </div>
        <div class="col-md-4">
            <label for="inputState" class="form-label">Área</label>
            <select id="inputState" class="form-select text-center" name="role">
                <option selected disabled> Tipo... </option>
                <option value="1" ${tipo == 1 ? 'selected' : ''}> FABRICANTE</option>
                <option value="2" ${tipo == 2 ? 'selected' : ''}> VENDEDOR </option>
                <option value="3" ${tipo == 3 ? 'selected' : ''}> ADMIN </option>
            </select>
            <c:if test="${errores != null && not empty errores.role}">
                <div class="fs-6" style="color: red;">
                    <p style="font-size: 14px"> ${errores.role} </p>
                </div>
            </c:if>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">${edit ? 'Guardar Cambios' : 'Crear Usuario'}</button>
        </div>
        <c:if test="${edit}">
        <input type="hidden" name="edit" value="${edit}">
        <input type="hidden" name="username" value="${requestScope.username}">    
        </c:if>
        
        
    </form>

</div>
<jsp:include page="../../includes/footer.jsp" />
