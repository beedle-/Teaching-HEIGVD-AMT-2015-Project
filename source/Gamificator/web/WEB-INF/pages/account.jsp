<%-- 
    Document   : home
    Author     : Bastien Rouiller
--%>

<%@include file="includes/header.jsp" %>

<h2>Create a new account</h2>

<form method="POST" action="accountManagement">
   <div class="form-group">
        <label for="email"> Email address:</label>
        <input type="email" class="form-control" name="email" required>
    </div>
    <div class="form-group">
        <label for="firstName">First Name:</label>
        <input type="text" class="form-control" name="firstName" required>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input type="text" class="form-control" name="lastName" required>
    </div>
    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" name="pwd" required>
    </div>
    <div class="form-group">
        <label for="confirmPwd">Confirm Password:</label>
        <input type="password" class="form-control" name="confirmPwd" required>
    </div>
    <button type="submit" class="btn btn-default">Create</button>
</form>

<%@include file="includes/footer.jsp" %>