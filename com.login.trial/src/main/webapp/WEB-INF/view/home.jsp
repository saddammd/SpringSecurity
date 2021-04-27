<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<html>

 <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello</title>
  </head>
  <body>
  
    <h1  class = text-center><strong>Customer Details</strong></h1>
    <p class = "text-right">Welcome Dear <security:authentication property="principal.username"/><br>
    <security:authentication property="principal.authorities"/>
   
    </p>
    
<form:form action = "http://localhost:8080/com.login.trial/logout" method ="post">
<input type=submit value="logout" class="btn btn-primary"/>
</form:form>

    <hr>
 <div class = "container">  
 <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      <security:authorize access="hasAnyRole('ROLE_ADMIN')">
      <th scope="col">Action</th>
      </security:authorize>
    </tr>
  </thead>
  
    <tbody>
    <c:forEach var = "customer" items="${customerList}">
    <c:url var="updateLink" value = "/update">
    <c:param name="param" value="${customer.id}"></c:param>
    </c:url>
    
    <c:url var="DeleteLink" value = "/delete">
    <c:param name="del" value = "${customer.id}"></c:param>
        </c:url>
    <tr>
     <td>${customer.first_name}</td>
     <td>${customer.last_name}</td>
     <td>${customer.email}</td>
     <security:authorize access="hasAnyRole('ROLE_ADMIN')">
     <td><a href = "${updateLink}">Update</a> | 
         <a href = "${DeleteLink}" onclick="if(!(confirm('Are you sure Do you want to delete this customer'))) return false">Delete</a></td>
    </security:authorize>
    </tr>
    </c:forEach>
  </tbody>
  </table>

<div>
<button type="submit" class="btn btn-primary" onclick="window.location.href='addCustomer'; return false; ">
Add Customer</button>
</div>


</div>






    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
<body>

</html>