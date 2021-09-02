<%-- Document : login.jsp Created on : 24/08/2021, 23:39:05 Author : Manu --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <jsp:include page="/includes/resources.jsp" />
            <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
            <title>Inicio de Sesión</title>

        </head>

        <body class="text-center">
            <div class="contenedor">
                <form method="POST">
                    <img class="mb-4" src="../resources/images/login.png" alt="" width="90" height="90">
                    <h1 class="h3 mb-3 fw-normal">Inicio de Sesión</h1>
                    <div class="form-floating">
                        <input type="text" class="form-control" id="floatingInput" placeholder="admin" name="user">
                        <label for="floatingInput">Usuario</label>
                        
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="floatingPassword" placeholder="Contraseña"
                            name="password">
                        <label for="floatingPassword">Contraseña</label>
                    </div>

                    <button class="w-100 btn btn-lg btn-primary" type="submit" value="iniciar-sesion">Iniciar
                        Sesión</button>
                        

                    <!--

                    
                    <div class="form-floating">
                        <input type="email" class="form-control is-invalid" id="floatingInputInvalid"
                            placeholder="name@example.com" value="">
                        <label for="floatingInputInvalid">Usuario</label>
                        <div class="invalid-feedback">
                            Ingrese un usuario válido
                        </div>
                    </div>
                    -->
                </form>

            </div>
        </body>

        </html>