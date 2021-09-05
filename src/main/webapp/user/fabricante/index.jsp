
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'FABRICANTE'}">
    <c:redirect url="/login"></c:redirect>
</c:if>
<jsp:include page="../../includes/header.jsp" />

<div class="container" style="padding-top: 150px; max-width: 1000px;">
    <h1>Bienvenid@, ${sessionScope.username}</h1>
</div>
<jsp:include page="../../includes/footer.jsp" />