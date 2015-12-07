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
<h4>${requestScope.nbOfAccounts} accounts created </h4>
<h4>${requestScope.nbOfApplications} applications managed </h4>
<h2>${requestScope.validation}</h2>

<%@include file="includes/footer.jsp" %>
