<%-- 
    Document   : home
    Author     : Bastien Rouiller
--%>

<%@include file="includes/header.jsp" %>

    <h2>hi eu</h2>
    <h4>${requestScope.apiKey} API Key </h4>
    <h4>${requestScope.userIdentifer} endUser identifier </h4>
    <h4>${requestScope.scoreUser} collected points </h4>

<%@include file="includes/footer.jsp" %>
