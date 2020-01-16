<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <title>login</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/login.css">
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
      .login-container{
          width:1170px;
          margin:0 auto;
      }
    </style>
</head>
<body>
    <div class ="login-container">
      <form method="post" action="dashboard" class="login-form">


        <div class="row">
          <div class="col-6 left-content">
              <h1 class="heading">Login <small>to Discover</small><br><small>the Places.</small></h1>
            <div class="form-group">
                  <input type="text" name="email" placeholder="Username or Email" class="form-control form-control-lg">   
              </div>
              <div class="form-group">

              <input type="password" name="password" class= "form-control form-control-lg" placeholder="Password">
            </div>

            <div class="row center-div">
              <div class="col">
                <div class="form-group">
                  <button class="btn btn-primary btn-lg sub-btn" name="login">Login</button>
                </div>
              </div>
              <div class="col">
                <div class="form-group">
                    <a href="signup" class="btn btn-primary btn-lg sub-btn">Signup</a>
                </div>
              </div>
            </div>

          </div>

            <div class="col-6 right-content">

              <img src="images/Cartoon-vector-illustration-of-man-working-with-computer.jpg" class="image"/>
            </div>  
        </div>



      </form>

    </div>
</body>
</html>