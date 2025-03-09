<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login - My Retail App</title>

    <!-- Bootstrap 4 CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- FontAwesome for Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        body {
            background: linear-gradient(to right, #ff9966, #ff5e62);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .login-container {
            max-width: 400px;
            width: 100%;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        .login-container h4 {
            font-weight: bold;
            margin-bottom: 20px;
        }

        .input-group-text {
            background-color: #ff5e62;
            color: white;
            border: none;
        }

        .form-control:focus {
            border-color: #ff5e62;
            box-shadow: 0px 0px 5px rgba(255, 94, 98, 0.5);
        }

        .btn-warning {
            width: 100%;
            font-weight: bold;
            transition: 0.3s;
        }

        .btn-warning:hover {
            background-color: #ff3e4d;
            border-color: #ff3e4d;
            color: white;
        }
    </style>
</head>
<body>

    <!-- Login Form -->
    <div class="login-container">
        <h4>Login to My Retail App</h4>
        <form action="/SpringDemo/login" method="post">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input class="form-control" type="text" name="username" placeholder="Enter Username" required />
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    </div>
                    <input class="form-control" type="password" name="password" placeholder="Enter Password" required />
                </div>
            </div>
            <button class="btn btn-warning"><i class="fas fa-sign-in-alt"></i> Login</button>
        </form>
    </div>

    <!-- Bootstrap 4 JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
