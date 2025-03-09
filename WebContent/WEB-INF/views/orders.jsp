<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Retail App - Order Details</title>

<!-- Bootstrap 4 CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!-- FontAwesome for Icons -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
    integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<style>
/* Custom Styling */
.textRed { color: red; }
.padding-bottom10 { padding-bottom: 10px; }
.paddingTop10 { padding-top: 10px; }
.margin-bottom10 { margin-bottom: 10px; }
.myCard { box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.1); transition: transform 0.2s; }
.myCard:hover { transform: scale(1.02); }
.table-hover tbody tr:hover { background-color: #f5f5f5; }
.card-title { color: #007bff; font-weight: bold; }
.status-badge { font-size: 14px; padding: 5px 10px; border-radius: 10px; }
.status-pending { background-color: #ffc107; color: #212529; }
.status-delivered { background-color: #28a745; color: white; }
.status-cancelled { background-color: #dc3545; color: white; }
</style>
</head>

<body>
    <%@ include file="header.jsp"%>

    <div class="container-fluid mt-4">
        <div class="row">
            <c:forEach var="orderDetail" items="${orderDetails}">
                <div class="col-md-12 padding-bottom10">
                    <div class="card shadow rounded myCard">
                        <div class="card-body">
                            <h4 class="card-title">Order #${orderDetail.id}</h4>
                            
                            <!-- Status Badge -->
                            <p class="card-text">
                                <span class="status-badge 
                                    ${orderDetail.status == 'Pending' ? 'status-pending' : 
                                      orderDetail.status == 'Delivered' ? 'status-delivered' : 
                                      'status-cancelled'}">
                                    <i class="fas fa-info-circle"></i> ${orderDetail.status}
                                </span>
                            </p>

                            <p class="card-text">
                                <b><i class="fas fa-box"></i> Total Items:</b> ${orderDetail.total} <br>
                                <b><i class="fas fa-credit-card"></i> Payment ID:</b> ${orderDetail.paymentId}
                            </p>

                            <table class="table table-striped table-hover overflow-auto">
                                <thead class="thead-dark">
                                    <tr>
                                        <th><i class="fas fa-cube"></i> Product</th>
                                        <th><i class="fas fa-sort-numeric-up"></i> Quantity</th>
                                        <th><i class="fas fa-calendar-alt"></i> Created At</th>
                                        <th><i class="fas fa-edit"></i> Updated At</th>
                                        <th><i class="fas fa-truck"></i> Delivery Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="orderItem" items="${orderDetail.orderItems}">
                                        <tr>
                                            <td><c:out value="${orderItem.productId}" /></td>
                                            <td><c:out value="${orderItem.quantity}" /></td>
                                            <td><c:out value="${orderItem.createdAt}" /></td>
                                            <td><c:out value="${orderItem.modifiedAt}" /></td>
                                            <td><c:out value="${orderItem.deliveryDate}" /></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

<!-- Bootstrap & jQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" 
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" 
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
