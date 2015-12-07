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

<h2>${requestScope.pageTitle}</h2>

<form method="POST" action="account">
   <div class="form-group">
        <label for="email"> Email address:</label>
        <input type="email" value="${requestScope.email}" class="form-control" name="email"  
        <c:if test="${empty connected}">required</c:if>
        <c:if test="${not empty connected}">readonly</c:if>>
    </div>
    <div class="form-group">
        <label for="firstName">First Name:</label>
        <input type="text" value="${requestScope.firstName}" class="form-control" name="firstName" required>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input type="text" value="${requestScope.lastName}" class="form-control" name="lastName" required>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" name="password" required>
    </div>
    <div class="form-group">
        <label for="confirmPwd">Confirm Password:</label>
        <input type="password" class="form-control" name="confirmPwd" required>
    </div>
        <c:if test="${empty connected}"><button type="submit" class="btn btn-default">Create</button></c:if>
        <c:if test="${not empty connected}"><button type="submit" class="btn btn-default">Edit</button></c:if>
</form>

<%@include file="includes/footer.jsp" %>