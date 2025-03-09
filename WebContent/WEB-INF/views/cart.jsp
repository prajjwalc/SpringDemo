<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart - My Retail App</title>

    <!-- Bootstrap 4 CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    
    <!-- FontAwesome for Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        .cart-container {
            max-width: 900px;
            margin: auto;
            padding: 20px;
        }
        .table th, .table td {
            vertical-align: middle;
            text-align: center;
        }
        .textRed {
            color: red;
        }
        .btn-warning {
            width: 150px;
        }
    </style>
</head>
<body>

    <%@ include file="header.jsp"%>

    <div class="container cart-container mt-4">
        <h2 class="text-center mb-4">Your Shopping Cart</h2>

        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cart" items="${shoppingCarts}">
                    <tr>
                        <td><c:out value="${cart.productId}" /></td>
                        <td><c:out value="${cart.quantity}" /></td>
                        <td><c:out value="${cart.createdAt}" /></td>
                        <td><c:out value="${cart.modifiedAt}" /></td>
                        <td>
                            <a class="textRed" href="/SpringDemo/cart?action=delete&cartId=${cart.id}" title="Remove Item">
                                <i class="fas fa-trash-alt fa-lg"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="text-right">
            <form action="/SpringDemo/cart" method="post">
                <button type="submit" class="btn btn-warning"><i class="fas fa-shopping-bag"></i> Buy Now</button>
            </form>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-3 mt-4">
        <p>&copy; 2025 My Retail App. All rights reserved.</p>
    </footer>

    <!-- Bootstrap 4 JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
