<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>${requestScope.pageTitle}</title>

        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <script src="static/js/jquery.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container">
            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="home">Gamificator</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">    
                            <li><a href="account">Create a new account</a></li>
                        </ul>
                        <c:if test="${empty connected}">
                            <form class="navbar-form navbar-right" method="POST" action="login">
                                <div class="form-group">
                                    <input type="email" placeholder="email" name="email" class="form-control" required>
                                    <input type="password" placeholder="password" name="password" class="form-control" required>
                                    <button type="submit" class="btn btn-default">Login</button>
                                </div>
                            </form>
                        </c:if>
                        <c:if test="${not empty connected}">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="login">Logout</a></li>
                            </ul>  

                            <p class="navbar-text navbar-right">Logged in as ${connected}</p>

                        </c:if>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>