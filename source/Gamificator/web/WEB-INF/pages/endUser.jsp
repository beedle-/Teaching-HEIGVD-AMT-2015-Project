<%-- 
    Document   : home
    Author     : Bastien Rouiller
--%>

<%@include file="includes/header.jsp" %>

    <h2>hi EndUser</h2>
    <h4>${requestScope.applicationName} </h4>
    <h4>my identifier : ${requestScope.userIdentifer}</h4>
    <h4>I collected <b>${requestScope.scoreUser} </b> points </h4>
    <h4>My Trophies : ${requestScope.trophyResult} </h4>
 
<%@include file="includes/footer.jsp" %>
