<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Signup</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
        
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <style>
      .signup-container{
          width:1170px;
          margin:0 auto;
      }
    </style>
</head>
<body>
    <div class ="signup-container">
    
	<form method="post" action="register" class="signup-form">
      
      <div class="row main-content">
        
      	<div class="col-6 left-content">
      	
      			<img src="images/Cartoon-vector-illustration-of-man-working-with-computer.jpg" class="image">
      		
      	</div>

      	<div class="col-6 right-content">
          <h2 class="heading">Create your account now <br> <small>Get unlimited questions and answers for your Travelling</small> </h2> 
            		
                  
                  <div class="row">
                    <div class="col-6">
                      <div class="form-group">
                         <input type="text" name="firstname" placeholder="Firstname" class="form-control">
                      </div>
                    </div>
                    <div class="col-6">
                      <div class="form-group">
                      <input type="text" name="lastname" placeholder="Lastname" class="form-control">
                      </div>
                    </div>
                  </div>
                  	 
                <div class="form-group">
      
                <select name="address" id="location" class="form-control form-control-lg">
                    <c:forEach var="location" items="${locs}">
                        <option value="${location.id}">${location.street},${location.city}</option>
                    </c:forEach>
                    <option value="">other</option>
                 
		</select>
              </div>
              <div class="form-group">
              
                <input type="text" name="contact" placeholder="Contact" class="form-control">
              </div>
              <div class="form-group">
                  <input type="text" name="email" placeholder="Username or Email" class="form-control">   
              </div>
              <div class="form-group">
              <input type="password" name="password" class= "form-control" placeholder="Password">
            </div>
            <div class="form-group">
              <input type="submit" name="signup" value="Signup" class="btn btn-primary sub-btn">
            </div>
            </div>
      	</div>
      </div>

 
  </form>
    </div>
</body>
</html>