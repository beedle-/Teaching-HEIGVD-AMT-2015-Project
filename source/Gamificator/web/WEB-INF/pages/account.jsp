<%-- 
    Document   : home
    Author     : Bastien Rouiller
--%>

<%@include file="includes/header.jsp" %>

<h2>Create a new account</h2>

<form role="form">
    <div class="form-group">
        <label for="email">Email address:</label>
        <input type="email" class="form-control" id="email">
    </div>
    <div class="form-group">
        <label for="firstName">First Name:</label>
        <input type="text" class="form-control" id="firstName">
    </div>
    <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input type="text" class="form-control" id="lastName">
    </div>
    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="pwd">
    </div>
    <div class="form-group">
        <label for="confirmPwd">Password:</label>
        <input type="password" class="form-control" id="confirmPwd">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>

<%@include file="includes/footer.jsp" %>