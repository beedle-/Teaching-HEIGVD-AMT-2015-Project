<%-- 
    Document   : home
    Author     : Bastien Rouiller
--%>

<%@include file="includes/header.jsp" %>

<div class="alert alert-info">
  ${requestScope.success}
</div>

<h2>${requestScope.validation}</h2>




<%@include file="includes/footer.jsp" %>
