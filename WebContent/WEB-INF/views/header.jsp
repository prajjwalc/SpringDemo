<%@ page language="java" errorPage="myError.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Retail App</title>

    <!-- Bootstrap 4 CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- FontAwesome for Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        /* Navbar Styling */
        .navbar {
            background: linear-gradient(45deg, #007bff, #6610f2);
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
        }

        .navbar-brand {
            font-weight: bold;
            font-size: 22px;
        }

        .navbar-nav .nav-item .nav-link {
            font-size: 16px;
            color: #fff !important;
            transition: 0.3s;
        }

        .navbar-nav .nav-item .nav-link:hover {
            color: #ffeb3b !important;
            transform: scale(1.1);
        }

        .navbar-nav .nav-item .nav-link i {
            margin-right: 5px;
        }

        .welcome-text {
            color: white;
            font-weight: bold;
            margin-right: 10px;
        }

        .logout-link {
            color: #ffeb3b;
            font-weight: bold;
            transition: 0.3s;
        }

        .logout-link:hover {
            color: #ff4b5c;
            text-decoration: none;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="/SpringDemo/home"><i class="fas fa-store"></i> My Retail App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active"><a class="nav-link" href="/SpringDemo/home"><i class="fas fa-home"></i> Home</a></li>
                <li class="nav-item active"><a class="nav-link" href="/SpringDemo/products"><i class="fas fa-box"></i> Products</a></li>
                <li class="nav-item active"><a class="nav-link" href="/SpringDemo/cart"><i class="fas fa-shopping-cart"></i> Cart</a></li>
                <li class="nav-item active"><a class="nav-link" href="/SpringDemo/orders"><i class="fas fa-truck"></i> Orders</a></li>
                <li class="nav-item active"><a class="nav-link" href="/SpringDemo/aboutUs"><i class="fas fa-info-circle"></i> About Us</a></li>
            </ul>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <span class="welcome-text">
                        Hello, <%
                        if(session.getAttribute("username") == null) {
                            response.sendRedirect("/SpringDemo/login");
                        } else {
                            out.print(session.getAttribute("username"));
                        }
                        %>!
                    </span>
                    <a class="logout-link" href="/SpringDemo/logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Bootstrap 4 JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
