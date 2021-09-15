<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="style.css">
    <title>Team Aslan</title>
</head>
<body>
<c:if test="${error == 0}">
    <div class="alert alert-danger" role="alert">
            Email Has Already Used. Please Choose Another One!
    </div>
</c:if>
<c:if test="${error == 1}">
    <div class="alert alert-success" role="alert">
            Register Successful!
    </div>
</c:if>
<h2>Weekly 1: Sign In/Up Form</h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="/register" method="post">
            <h1>Create Account</h1>
            <div class="social-container">
                <a href="#"><i class="bi bi-twitter text-dark mx-1"></i></a>
                <a href="#"><i class="bi bi-facebook text-dark mx-1"></i></a>
                <a href="#"><i class="bi bi-linkedin text-dark mx-1"></i></a>
                <a href="#"><i class="bi bi-instagram text-dark mx-1"></i></a>
            </div>
            <span>or use your email for registration</span>
            <input type="text" placeholder="Name" name="username"/>
            <input type="email" placeholder="Email" name="email"/>
            <input type="password" placeholder="Password" name="password"/>
            <button>Sign Up</button>
            <small class="border-top mt-4 p-2 w-100">Created with <i class="bi bi-heart-fill icon-pink"></i> by Team Aslan</small>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="" method="post">
            <h1>Sign in</h1>
            <div class="social-container">
                <a href="#"><i class="bi bi-twitter text-dark mx-1"></i></a>
                <a href="#"><i class="bi bi-facebook text-dark mx-1"></i></a>
                <a href="#"><i class="bi bi-linkedin text-dark mx-1"></i></a>
                <a href="#"><i class="bi bi-instagram text-dark mx-1"></i></a>
            </div>
            <span>or use your account</span>
            <input type="email" placeholder="Email" name="email"/>
            <input type="password" placeholder="Password" name="password"/>
            <a href="#">Forgot your password?</a>
            <button class="mb-3" >Sign In</button>
            <small class="border-top mt-4 p-2 w-100">Created with <i class="bi bi-heart-fill icon-pink"></i> by Team Aslan</small>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
<footer>
    <p>
        Created with <i class="bi bi-heart-fill"></i> by
        <a target="_blank" href="https://nameless-escarpment-70661.herokuapp.com/">Team Aslan</a>

    </p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script type="text/javascript" src="logic.js"></script>
</body>
</html>