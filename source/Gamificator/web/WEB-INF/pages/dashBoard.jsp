<%-- 
    Document   : home
    Author     : Bastien Rouiller
--%>

<%@include file="includes/header.jsp" %>


<h2>${requestScope.validation}</h2>
<h2>${requestScope.firstName}</h2>
<h2>${requestScope.lastName}</h2>
<h2>${requestScope.email}</h2>
<h2>${requestScope.pwd}</h2>
<h2>${requestScope.confirmPwd}</h2>




<%@include file="includes/footer.jsp" %>
