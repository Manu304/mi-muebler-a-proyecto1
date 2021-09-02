
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole != 'ADMIN'}">
    <c:redirect url="/login"></c:redirect>
</c:if>
<jsp:include page="../../includes/header.jsp" />

