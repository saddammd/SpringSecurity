<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 


<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Add Customer</title>
  </head>
  <body>
    <h1 class = "container" text-center>Add New Customer</h1>
   
   <div class = "container border border-primary form-group"> 
    <form:form action = "processAddCustomer" modelAttribute = "customer_entity" method="post">
    
    <form:label path="first_name"> First Name :</form:label>
    <form:input path="first_name" class="form-control "/><br>
    
    
    <form:label path="last_name"> Last Name :</form:label>
    <form:input path="last_name" class="form-control"/><br>
    
    
    <form:label path="email"> Email :</form:label>
    <form:input path="email" class="form-control"/><br>
    
    
    <input type = "submit" value ="save customer" class="btn btn-primary">
    
    </form:form>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>