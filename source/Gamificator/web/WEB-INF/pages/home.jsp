<%-- 
    Document   : home
    Author     : Bastien Rouiller
--%>

<%@include file="includes/header.jsp" %>

<c:if test="${not empty success}">
    <div class="alert alert-info">
      ${requestScope.success}
    </div>
</c:if>
<h2>Welcome to Gamificator!</h2>
<h2>${requestScope.validation}</h2>
<h2>${requestScope.firstName}</h2>
<h2>${requestScope.lastName}</h2>
<h2>${requestScope.email}</h2>
<h2>${requestScope.password}</h2>
<h2>${requestScope.confirmPwd}</h2>

<%@include file="includes/footer.jsp" %>
